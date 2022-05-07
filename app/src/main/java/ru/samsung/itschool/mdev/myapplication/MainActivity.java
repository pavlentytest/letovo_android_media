package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button); // инициализация
    }

    public void doPlay(View v) {
        if(v.getId() == R.id.button) {
            if (mp == null) {
                mp = MediaPlayer.create(this, R.raw.canon);
                mp.start();
            } else {
                if (mp.isPlaying()) {
                    btn.setText("Pause");
                    btn.setBackgroundColor(Color.RED);
                    mp.pause();
                } else {
                    btn.setText("Start");
                    btn.setBackgroundColor(Color.BLUE);
                    mp.start(); // continue
                }
            }
        } else {
            mp.stop();
            mp = null;
        }
    }

    public void calc(View v) {
        EditText edA = findViewById(R.id.editTextA);
        EditText edB = findViewById(R.id.editTextB);
        int a = Integer.parseInt(edA.getText().toString());
        int b = Integer.parseInt(edB.getText().toString());
        Button btn3 = findViewById(R.id.button3);
        int res = -b/a;
        btn3.setText(Integer.toString(res));
    }
}