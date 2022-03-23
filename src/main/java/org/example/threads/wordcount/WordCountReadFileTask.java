package org.example.threads.wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCountReadFileTask implements Runnable {
    private String filePathAndName;
    private ArrayBlockingQueue<String> oneWordQueue;
    private String[] englishOrChinaWordCompile;
    private CountDownLatch countDownLatch;

    public WordCountReadFileTask(CountDownLatch countDownLatch, String filePathAndName, ArrayBlockingQueue<String> oneWordQueue, String[] englishOrChinaWordCompile) {
        this.countDownLatch = countDownLatch;
        this.filePathAndName = filePathAndName;
        this.oneWordQueue = oneWordQueue;
        this.englishOrChinaWordCompile = englishOrChinaWordCompile;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePathAndName));
            StringBuffer sb = new StringBuffer();
            List<String> strList = new ArrayList<String>();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
                //if (sb.length() > 10) {
                strList.add(sb.toString());
                sb.delete(0, sb.length());
                // }
            }
            if (sb != null) {
                strList.add(sb.toString());
            }
            br.close();
            for (String words : strList) {
                for (String oneCompile : englishOrChinaWordCompile) {
                    //Regular
                    Pattern p = Pattern.compile(oneCompile);
                    Matcher matcher = p.matcher(words);
                    while (matcher.find()) {
                        oneWordQueue.put(matcher.group());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}