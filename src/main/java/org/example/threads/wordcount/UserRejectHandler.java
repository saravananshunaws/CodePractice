package org.example.threads.wordcount;

import java.util.*;
import java.math.*;
import java.io.*;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class UserRejectHandler implements RejectedExecutionHandler
{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
    {
        System.out.printf("RejectedTaskHandler: The task %s has been rejected", r.toString());
    }
}