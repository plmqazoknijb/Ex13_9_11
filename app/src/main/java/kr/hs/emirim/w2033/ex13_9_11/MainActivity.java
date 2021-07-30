package kr.hs.emirim.w2033.ex13_9_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seek1, seek2;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tread 기본");
        seek1 = findViewById(R.id.seek1);
        seek2 = findViewById(R.id.seek2);
        tv1 = findViewById(R.id.tv1);
        Button btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        for(int i = seek1.getProgress(); i < 100; i+=2){
                            seek1.setProgress(seek1.getProgress()+2);

                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                Thread thread2 = new Thread(){
                    @Override
                    public void run() {
                        for(int i = seek2.getProgress(); i < 100; i+=1){
                            seek2.setProgress(seek2.getProgress()+2);
                            SystemClock.sleep(100);
                        }
                    }
                };
                thread2.start();
            }
        });
    }
}