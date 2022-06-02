package com.example.p2_practica6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback
{
    private GameThread GameThread;
    private TextView statusText;
    private SurfaceHolder holder;
    private Context context;

    public GameSurfaceView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        this.holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
    }

    Canvas canvas = holder.lockCanvas(null);

    Bitmap backgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.background2);
    canvas.drawBitmap(backgroundImage, 0, 0, null);

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        GameThread.setRunning(true);
        try
        {
            GameThread.start();
        }
        catch (Exception error)
        {
            GameThread = CreateNewAndrongThread();
            GameThread.start();
            GameThread.setRunning(true);
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        GameThread.setSurfaceSize(width, height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
        GameThread.setRunning(false);
        boolean retry = true;
        while (retry)
        {
            try
            {
                GameThread.join();
                retry = false;
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public void setTextView(TextView viewById) {
        statusText = textView;
    }
}
