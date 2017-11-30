package io.github.hackerfrog.tiles;

import android.annotation.SuppressLint;
import android.graphics.Canvas;

public class GameThread implements Runnable {

    Levels levels;
    boolean flag = false;

    public GameThread(Levels levels) {
        this.levels = levels;
    }

    void setRunning(boolean flag){
        this.flag = flag;
    }

    @SuppressLint("WrongCall")
    @Override
    public void run() {
        if (flag) {
            Canvas canvas = null;
            try {
                Thread.sleep(0, 1);
                canvas = levels.getHolder().lockCanvas();
                synchronized (levels.getHolder()) {
                    levels.onDraw(canvas);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    levels.getHolder().unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
