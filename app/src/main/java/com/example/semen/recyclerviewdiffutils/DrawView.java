package com.example.semen.recyclerviewdiffutils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawView extends View {
    Paint paint;
    Rect rect;
    public DrawView(Context context) {
        super(context);
        paint = new Paint();
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //заливка канвы цветом
        canvas.drawARGB(80,102,204,255);

        //настройка кисти
        // красный цвет
        paint.setColor(Color.RED);

        //толщина линии = 10
        paint.setStrokeWidth(10);

        //рисуем точку(50,50)
        canvas.drawPoint(50,50,paint);

        // рисуем линию от (100,100) до (500,50)
        canvas.drawLine(100,100,500,50,paint);

        // рисуем круг с центром в (100,200), радиус = 50
        canvas.drawCircle(100,200,50,paint);

        // рисуем прямоугольник
        // левая верхняя точка (200,150), нижняя правая (400,200)
        canvas.drawRect(100,200,400,200,paint);

        // настройка объекта Rect
        // левая верхняя точка (250,300), нижняя правая (350,500)
        rect.set(250,300,350,500);

        // рисуем прямоугольник из объекта rect
        canvas.drawRect(rect,paint);

    }
}
