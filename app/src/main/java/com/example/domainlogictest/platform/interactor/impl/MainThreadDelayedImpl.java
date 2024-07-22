package com.example.domainlogictest.platform.interactor.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.domainlogictest.platform.interactor.MainThread;


public class MainThreadDelayedImpl implements MainThread {
    private Handler handler;
    long delay;

    public MainThreadDelayedImpl(long delayMs) {
        this.handler = new Handler(Looper.getMainLooper());
        delay = delayMs;
    }

    @Override
    public void post(Runnable runnable) {
        handler.postDelayed(runnable, delay);
    }
}
