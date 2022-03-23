package org.example.threads.wordcount;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadFactory implements ThreadFactory {
    private final String prefixName;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public UserThreadFactory(String prefixName) {
        this.prefixName = prefixName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefixName + threadNumber.getAndIncrement();
        return new WorkThread(runnable, name);
    }

    class WorkThread extends Thread {
        private String name;

        public WorkThread(Runnable target, String name) {
            super(target);
            super.setName(name);
            this.name = name;
            System.out.println("Created:" + name);
        }

        @Override
        public void run() {
            try {
                /**
                 * super.run () is equivalent to Target.Run ()
                 */
                super.run();
            } finally {
                System.out.println("end thread:" + name);
            }
        }
    }
}