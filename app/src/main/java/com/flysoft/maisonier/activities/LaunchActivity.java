package com.flysoft.maisonier.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.flysoft.maisonier.R;

public class LaunchActivity extends AppCompatActivity {

    private ProgressBar loading;
    private int valueProgre = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
        initView();
        setProgressValue(valueProgre);

    }

    private void initView() {
        loading = (ProgressBar) findViewById(R.id.loadingBar);
    }

    private void setProgressValue(final int progress) {

        // set the progress
        loading.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 5);
            }
        });
        thread.start();
    }
}
