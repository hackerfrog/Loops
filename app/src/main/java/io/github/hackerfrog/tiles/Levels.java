package io.github.hackerfrog.tiles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Levels extends SurfaceView {

    Context context;
    Thread thread;
    SurfaceHolder surfaceHolder;
    Bitmap bitmap;
    Paint paint;

    GameGrid gameGrid;
    GameThread gameThread;

    int lvl = 1;
    int canvasHeight, canvasWidth;
    boolean rotRun = true, solved = false;


    int list1[][] = {{ R.drawable.ci_r, R.drawable.c_tr }, { R.drawable.ci_r, R.drawable.c_br}};
    public int pos1[][] = {{ 2, 1}, { 2, 0}};

    int list2[][] = {{ R.drawable.c_tl, R.drawable.c_tr, R.drawable.c_tl, R.drawable.c_tr }, { R.drawable.c_bl, R.drawable.c_br, R.drawable.c_bl, R.drawable.c_br }, { R.drawable.c_tl, R.drawable.c_tr, R.drawable.c_tl, R.drawable.c_tr }, { R.drawable.c_bl, R.drawable.c_br, R.drawable.c_bl, R.drawable.c_br }};
    public int pos2[][] = {{ 2, 1, 3, 2}, { 3, 2, 2, 1}, { 1, 2, 2, 3}, { 2, 3, 1, 2}};

    int list3[][] = {{ R.drawable.ci_r, R.drawable.c_tr, R.drawable.c_tl, R.drawable.ci_l }, { R.drawable.c_tl, R.drawable.c_br, R.drawable.c_bl, R.drawable.c_tr }, { R.drawable.c_bl, R.drawable.c_tr, R.drawable.c_tl, R.drawable.c_br }, { R.drawable.ci_r, R.drawable.c_br, R.drawable.c_bl, R.drawable.ci_l }};
    public int pos3[][] = {{ 2, 1, 3, 2}, { 2, 0, 0, 2}, { 2, 0, 0, 2}, { 2, 3, 1, 2}};

    int list4[][] = {{ R.drawable.c_tl, R.drawable.c_tr, R.drawable.c_tl, R.drawable.c_tr }, { R.drawable.c_bl, R.drawable.c_br, R.drawable.c_bl, R.drawable.c_br }};
    public int pos4[][] = {{ 0, 3, 1, 0}, { 0, 1, 3, 0}};

    int list5[][] = {{ R.drawable.ci_b, R.drawable.c_blank, R.drawable.ci_b }, { R.drawable.i_v, R.drawable.c_blank, R.drawable.i_v }, { R.drawable.ci_t, R.drawable.c_blank, R.drawable.ci_t }};
    public int pos5[][] = {{ 2, 0, 1}, { 1, 0, 1}, { 0, 0, 3}};

    int list6[][] = {{ R.drawable.c_tl, R.drawable.i_h, R.drawable.i_h, R.drawable.c_tr }, { R.drawable.c_bl, R.drawable.c_tr, R.drawable.c_tl, R.drawable.c_br }, { R.drawable.ci_b, R.drawable.i_v, R.drawable.i_v, R.drawable.ci_b }, { R.drawable.ci_t, R.drawable.ci_t, R.drawable.ci_t, R.drawable.ci_t }};
    public int pos6[][] = {{ 1, 0, 1, 3}, { 0, 2, 0, 2}, { 0, 0, 1, 0}, { 2, 3, 0, 3}};


    public Levels(Context context, int lvl) {
        super(context);
        this.context = context;
        this.lvl = lvl;

        gameThread = new GameThread(this);
        thread = new Thread(gameThread);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas canvas = surfaceHolder.lockCanvas();
                onDraw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
                gameThread.setRunning(rotRun);
                thread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {}
        });

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.c_bl);

        bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasHeight = canvas.getHeight();
        canvasWidth  = canvas.getWidth();

        // Common variables in all levels
        Rect topBar = new Rect(0, 0, canvas.getWidth(), 140);

        switch (lvl) {
// Level 1
            case 1:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#221111"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 2, 2);

                canvas = gameGrid.make(list1, pos1);

                if (gameGrid.checkWin(list1, pos1)) {
                    lvl = 2;
                    solved = true;
                }
                break;
// Level 2
            case 2:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#37474F"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 4, 4);

                canvas = gameGrid.make(list2, pos2);

                if (gameGrid.checkWin(list2, pos2)) {
                    lvl = 3;
                    solved = true;
                }
                break;
// Level 3
            case 3:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#0D1B4C"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 4, 4);

                canvas = gameGrid.make(list3, pos3);

                if (gameGrid.checkWin(list3, pos3)) {
                    lvl = 4;
                    solved = true;
                }
                break;
// Level 4
            case 4:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#0D3304"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 4, 2);

                canvas = gameGrid.make(list4, pos4);

                if (gameGrid.checkWin(list4, pos4)) {
                    lvl = 5;
                    solved = true;
                }
                break;
// Level 5
            case 5:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#330420"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 3, 3);

                canvas = gameGrid.make(list5, pos5);

                if (gameGrid.checkWin(list5, pos5)) {
                    lvl = 6;
                    solved = true;
                }
                break;
// Level 6
            case 6:
                // Canvas Background Color
                canvas.drawColor(Color.parseColor("#0D3304"));
                // Canvas Back Button
                paint = new Paint();
                paint.setARGB(20, 255, 255, 255);
                canvas.drawRect(topBar, paint);
                paint.setARGB(255, 255, 255, 255);
                paint.setTextSize(80);
                canvas.drawText("BACK", canvas.getWidth() / 2 - 100, 95, paint);

                gameGrid = new GameGrid(context, canvas, 4, 4);

                canvas = gameGrid.make(list6, pos6);

                if (gameGrid.checkWin(list6, pos6)) {
                    lvl = 1;
                    solved = true;
                }
                break;

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float inX = event.getX();
        float inY = event.getY();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                if (solved) {
                    solved = false;
                    rotRun = true;
                    gameThread.setRunning(rotRun);
                    thread.start();
                }
                else if (inY <= 140) {

                    Intent i = new Intent(context, ResetActivity.class);
                    context.startActivity(i);

                } else if (inX >= canvasWidth/2 - gameGrid.getWidth()/2
                            && inX <= canvasWidth/2 + gameGrid.getWidth()/2
                            && inY >= canvasHeight/2 - gameGrid.getHeight()/2
                            && inY <= canvasHeight/2 + gameGrid.getHeight()/2) {


                    int RotY = (int) ((inX - (canvasWidth/2 - gameGrid.getWidth()/2)) / 100);
                    int RotX = (int) ((inY - (canvasHeight/2 - gameGrid.getHeight()/2)) / 100);

                    System.out.println("RotXY : " + RotX + " , " + RotY);

                    if (lvl == 1)
                        pos1[RotX][RotY] += 1;
                    else if (lvl == 2)
                        pos2[RotX][RotY] += 1;
                    else if (lvl == 3)
                        pos3[RotX][RotY] += 1;
                    else if (lvl == 4)
                        pos4[RotX][RotY] += 1;
                    else if (lvl == 5)
                        pos5[RotX][RotY] += 1;
                    else if (lvl == 6)
                        pos6[RotX][RotY] += 1;

                    rotRun = true;
                    gameThread.setRunning(rotRun);
                    thread.start();

                }

                System.out.println("Touch ( " + inX + " , " + inY + " )");
                break;
        }

        return true;
    }
}
