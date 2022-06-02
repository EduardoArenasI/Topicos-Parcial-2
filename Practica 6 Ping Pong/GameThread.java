package com.example.p2_practica6;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class GameThread extends Thread
{
    private final SurfaceHolder surfaceHolder;
    private Handler handler;
    private boolean isRunning;

    private Bitmap backgroundImage;

    public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler)
    {
        this
    }

    @Override
    public void run()
    {
        long startTime = SystemClock.uptimeMillis();
        while (isRunning)
        {
            currentTimeInMillis = System.upTimeMillis();
            double timeNeededToDrawFrame =
                    (currentTimeInMillis - previousTimeInMillis) / 1000;
            previousTimeInMillis = currentTimeInMillis;
            DrawFrame(time);
            UpdatePhysics(timeNeededToDrawFrame);
        }
    }

    public void setRunning(boolean b) {
        isRunning = b;
    }
}
