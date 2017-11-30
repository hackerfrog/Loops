package io.github.hackerfrog.tiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import io.github.hackerfrog.tiles.img.*;

public class GameGrid {

    Canvas canvas;
    Context context;

    int height;
    int width;
    int x, y;
    int baseX, baseY;

    public GameGrid(Context context, Canvas canvas, int x, int y) {
        this.context    = context;
        this.canvas     = canvas;
        this.x          = x;
        this.y          = y;

        height  = 100 * y;
        width   = 100 * x;

        baseX   = canvas.getWidth()/2 - width/2;
        baseY   = canvas.getHeight()/2 - height/2;
    }

    public int getHeight()      {   return height;  }
    public int getWidth()       {   return width;   }

    public int getObj(int id) {
        if (id == R.drawable.c_bl)
            return c_bl.rotateMod;
        else if (id == R.drawable.c_br)
            return  c_br.rotateMod;
        else if (id == R.drawable.c_tl)
            return  c_tl.rotateMod;
        else if (id == R.drawable.c_tr)
            return  c_tr.rotateMod;
        else if (id == R.drawable.ci_b)
            return  ci_b.rotateMod;
        else if (id == R.drawable.ci_l)
            return  ci_l.rotateMod;
        else if (id == R.drawable.ci_r)
            return  ci_r.rotateMod;
        else if (id == R.drawable.ci_t)
            return  ci_t.rotateMod;
        else if (id == R.drawable.i_v)
            return  i_v.rotateMod;
        else if (id == R.drawable.i_h)
            return  i_h.rotateMod;
        else
            return 1;
    }

    public Canvas make(int [][] ids, int [][] rot) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Bitmap bitmap = null;
                int r = 0;
                switch (ids[i][j]) {
                    case R.drawable.c_tl :
                        c_tl tl = new c_tl(context);
                        tl.setRotateCount(rot[i][j] % tl.rotateMod);
                        bitmap = tl.getBitmap();
                        break;
                    case R.drawable.c_tr :
                        c_tr tr = new c_tr(context);
                        tr.setRotateCount(rot[i][j] % tr.rotateMod);
                        bitmap = tr.getBitmap();
                        break;
                    case R.drawable.c_bl :
                        c_bl bl = new c_bl(context);
                        bl.setRotateCount(rot[i][j] % bl.rotateMod);
                        bitmap = bl.getBitmap();
                        break;
                    case R.drawable.c_br :
                        c_br br = new c_br(context);
                        br.setRotateCount(rot[i][j] % br.rotateMod);
                        bitmap = br.getBitmap();
                        break;
                    case R.drawable.ci_t :
                        ci_t cit = new ci_t(context);
                        cit.setRotateCount(rot[i][j] % cit.rotateMod);
                        bitmap = cit.getBitmap();
                        break;
                    case R.drawable.ci_r :
                        ci_r cir = new ci_r(context);
                        cir.setRotateCount(rot[i][j] % cir.rotateMod);
                        bitmap = cir.getBitmap();
                        break;
                    case R.drawable.ci_b :
                        ci_b cib = new ci_b(context);
                        cib.setRotateCount(rot[i][j] % cib.rotateMod);
                        bitmap = cib.getBitmap();
                        break;
                    case R.drawable.ci_l :
                        ci_l cil = new ci_l(context);
                        cil.setRotateCount(rot[i][j] % cil.rotateMod);
                        bitmap = cil.getBitmap();
                        break;
                    case R.drawable.c_blank :
                        c_blank cblank = new c_blank(context);
                        cblank.setRotateCount(rot[i][j] % cblank.rotateMod);
                        bitmap = cblank.getBitmap();
                        break;
                    case R.drawable.i_v :
                        i_v iv = new i_v(context);
                        iv.setRotateCount(rot[i][j] % iv.rotateMod);
                        bitmap = iv.getBitmap();
                        break;
                    case R.drawable.i_h :
                        i_h ih = new i_h(context);
                        ih.setRotateCount(rot[i][j] % ih.rotateMod);
                        bitmap = ih.getBitmap();
                        break;
                }
                canvas.drawBitmap(bitmap, baseX + j*100, baseY + i*100, null);
            }
        }

        return canvas;
    }

    public boolean checkWin(int [][] list, int [][] rot) {
        int sum = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sum += rot[i][j] % getObj(list[i][j]);
            }
        }
        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }

}
