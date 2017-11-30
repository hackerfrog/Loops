package io.github.hackerfrog.tiles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Levels lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setTitle("Game Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                }).create().show();
    }

    public void showLevel(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn1lvl :
                lvl = new Levels(this, 1);
                break;
            case R.id.btn2lvl :
                lvl = new Levels(this, 2);
                break;
            case R.id.btn3lvl :
                lvl = new Levels(this, 3);
                break;
            case R.id.btn4lvl :
                lvl = new Levels(this, 4);
                break;
            case R.id.btn5lvl :
                lvl = new Levels(this, 5);
                break;
            case R.id.btn6lvl :
                lvl = new Levels(this, 6);
                break;
        }

        setContentView(lvl);
    }

}