package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int counter = 99;
    private static final String CURRENT_COUNTER="counter";
    private boolean wasRunning = false;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState !=null){
            counter = savedInstanceState.getInt(CURRENT_COUNTER);
        }
        running = true;
        countDown();
    }

    @Override
    public void onSaveInstanceState(Bundle savedINS){
        super.onSaveInstanceState(savedINS);
        savedINS.putInt(CURRENT_COUNTER,counter);
    }

    private void countDown(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textView = findViewById(R.id.textView);
                textView.setText(Integer.toString(counter));
                //Reset the counter
                if (counter == 0) {
                    counter = 99;
                }
                if(running){
                    counter--;
                }
                handler.postDelayed(this,100);
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onStop(){
        super.onStop();
        running = false;
    }
}
