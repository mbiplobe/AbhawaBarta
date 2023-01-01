package com.hafsa.abhawabarta;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutor {
    public static AppExecutor getAppExecutor() {
        return appExecutor;
    }

    private static AppExecutor appExecutor;

    public static AppExecutor getInstance() {
        if (appExecutor==null)
            appExecutor= new AppExecutor();
        return appExecutor;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    private final ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(3);

}
