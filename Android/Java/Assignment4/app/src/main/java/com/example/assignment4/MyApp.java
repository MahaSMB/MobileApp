package com.example.assignment4;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApp extends Application {

    JSONManager jsonManager = new JSONManager();
    NetworkingManager networkingManager = new NetworkingManager();
    static ExecutorService executorService = Executors.newFixedThreadPool(4);
    static Handler mainhandler = new Handler(Looper.getMainLooper());
}
