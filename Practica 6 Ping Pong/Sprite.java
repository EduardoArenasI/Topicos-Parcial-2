package com.example.p2_practica6;

import android.graphics.Canvas;

public class Sprite
{
    protected DrawableResourceCollection drawableResourceCollection;
    private int currentFrame;

    public void draw(Canvas canvas)
    {
        drawableResourceCollection
                .get(currentFrame)
                .setBounds((int) xPosition,
                        (int) yPosition,
                        (int) xPosition + getWidth(),
                        (int) yPosition + getHeight());
        drawableResourceCollection.get(currentFrame).draw(canvas);
        currentFrame = GetNewFrame();
    }

}
