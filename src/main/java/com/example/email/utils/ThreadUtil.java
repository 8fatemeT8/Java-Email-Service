package com.example.email.utils;

public class ThreadUtil {

    public static void createThreadAndStart(Runnable runnable) {
        Runnable runWithHibernateSession = () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                throw e;
            }
        };
        Thread thread = new Thread(runWithHibernateSession);
        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
            }
        };

        thread.setUncaughtExceptionHandler(exceptionHandler);
        thread.start();
    }

}
