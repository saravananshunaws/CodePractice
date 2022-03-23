package org.example.threads.wordcount;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class WordCountTask implements Runnable {
    private ArrayBlockingQueue<String> oneWordQueue;
    private ConcurrentHashMap<String, AtomicInteger> wordCount;
    private long waitTimeSecond;
    private CountDownLatch countDownLatch;
    private static AtomicReferenceArray wordCountArray;

    public WordCountTask(CountDownLatch countDownLatch, ConcurrentHashMap<String, AtomicInteger> wordCount,
                         ArrayBlockingQueue<String> oneWordQueue, long waitTimeSecond, AtomicReferenceArray wordCountArray) {
        this.wordCountArray = wordCountArray;
        this.countDownLatch = countDownLatch;
        this.oneWordQueue = oneWordQueue;
        this.wordCount = wordCount;
        this.waitTimeSecond = waitTimeSecond;
    }

    @Override
    public void run() {
        try {
            String oneWord;
            AtomicInteger nowCount;
            while ((oneWord = oneWordQueue.poll(waitTimeSecond, TimeUnit.SECONDS)) != null) {
                if ((nowCount = wordCount.get(oneWord)) == null) {
                    nowCount = new AtomicInteger(1);
                    AtomicInteger ifExistCount = wordCount.putIfAbsent(oneWord, nowCount);
                    if (ifExistCount != null) {
                        ifExistCount.getAndIncrement();
                    }
                } else {
                    nowCount.getAndIncrement();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}