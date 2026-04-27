package com.example.izhik_lab8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class Draw2D extends View {
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();

    public Draw2D(Context context) {
        super(context);
    }

    public Draw2D(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();
        float horizon = height * 0.68f;

        drawSky(canvas, width, horizon);
        drawGround(canvas, width, height, horizon);
        drawPond(canvas, width, height);
        drawCaption(canvas, width, height);
    }

    private void drawSky(Canvas canvas, float width, float horizon) {
        paint.setShader(new LinearGradient(0, 0, 0, horizon,
                Color.rgb(18, 46, 130), Color.rgb(105, 174, 230), Shader.TileMode.CLAMP));
        canvas.drawRect(0, 0, width, horizon, paint);
        paint.setShader(null);
    }

    private void drawGround(Canvas canvas, float width, float height, float horizon) {
        paint.setShader(new LinearGradient(0, horizon, 0, height,
                Color.rgb(45, 138, 68), Color.rgb(31, 99, 50), Shader.TileMode.CLAMP));
        canvas.drawRect(0, horizon, width, height, paint);
        paint.setShader(null);

        paint.setColor(Color.argb(90, 255, 255, 255));
        canvas.drawRect(0, horizon, width, horizon + 4f, paint);
    }

    private void drawPond(Canvas canvas, float width, float height) {
        rect.set(width * 0.28f, height * 0.78f, width * 0.66f, height * 0.90f);
        paint.setColor(Color.rgb(56, 173, 205));
        canvas.drawOval(rect, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.argb(180, 255, 255, 255));
        canvas.drawArc(rect, 200, 120, false, paint);
        paint.setStyle(Paint.Style.FILL);
    }

    private void drawCaption(Canvas canvas, float width, float height) {
        paint.setColor(Color.WHITE);
        paint.setTextSize(Math.max(24f, width * 0.045f));
        canvas.drawText("Графика и анимация", width * 0.06f, height * 0.08f, paint);

        canvas.save();
        paint.setColor(Color.argb(210, 255, 246, 176));
        paint.setTextSize(Math.max(18f, width * 0.032f));
        float x = width * 0.62f;
        float y = height * 0.22f;
        canvas.rotate(-28f, x, y);
        // canvas.drawText("Лучик солнца", x, y, paint);
        canvas.restore();
    }
}
