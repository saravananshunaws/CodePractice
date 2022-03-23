package org.example.threads.wordcount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ThreadPool {
    private static ArrayBlockingQueue<String> oneWordQueue = new ArrayBlockingQueue<String>(Integer.MAX_VALUE / 4);
    private static ConcurrentHashMap<String, AtomicInteger> wordCount = new ConcurrentHashMap<String, AtomicInteger>();
    private static String[] englishOrChinaWordCompile = {"[a-zA-Z]+", "[\\u4e00-\\u9fa5]"};
    private static long waitTimeSecond = 5;
    private static CountDownLatch countDownLatch = new CountDownLatch(4);
    private static AtomicReferenceArray wordCountArray = new AtomicReferenceArray<String>(Integer.MAX_VALUE / 16);

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(10000);
        ThreadPoolExecutor readFilePool = new ThreadPoolExecutor(5, 5,
                waitTimeSecond, TimeUnit.SECONDS, blockingQueue, new UserThreadFactory("Study-WordCountReadFile-"),
                new UserRejectHandler());
        //executor.allowCoreThreadTimeOut(true);
        Long beginTime = System.currentTimeMillis();
        //Read the file of the D disk
        File file = new File("C:\\dev\\study\\java\\wordcount");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            //  Define file type
            for (File one : files) {
                String fileName = one.getName();
                readFilePool.execute(new WordCountReadFileTask(countDownLatch, "C:\\dev\\study\\java\\wordcount\\" + fileName,
                        oneWordQueue, englishOrChinaWordCompile));
            }
        }
        ThreadPoolExecutor sortWordPool = new ThreadPoolExecutor(5, 5,
                waitTimeSecond, TimeUnit.SECONDS, blockingQueue, new UserThreadFactory("Study-WordCount-"),
                new UserRejectHandler());
        //executor1.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 3; i++) {
            sortWordPool.execute(new WordCountTask(countDownLatch, wordCount, oneWordQueue, waitTimeSecond, null));
        }
        try {
            countDownLatch.await();
            readFilePool.shutdown();
            sortWordPool.shutdown();
            //  Write to the file
            List<Map.Entry<String, AtomicInteger>> list = new ArrayList(wordCount.entrySet());
            Comparator com = new Comparator<Map.Entry<String, AtomicInteger>>() {
                @Override
                public int compare(Map.Entry<String, AtomicInteger> o1, Map.Entry<String, AtomicInteger> o2) {
                    return ((Integer) o2.getValue().get()).compareTo((Integer) o1.getValue().get());
                }
            };
            list.sort(com);
            //  Write to the file
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\dev\\study\\java\\wordcount\\read.txt"));
            for (int i = 0; i < list.size(); i++) {
                if (i < 10) {
                    System.out.println("word " + list.get(i).getKey() + ", number of times " + list.get(i).getValue());
                }
                bw.write("word " + list.get(i).getKey() + ", number of times " + list.get(i).getValue());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}