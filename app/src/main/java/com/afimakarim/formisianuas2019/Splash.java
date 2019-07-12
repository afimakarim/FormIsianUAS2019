package com.afimakarim.formisianuas2019;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private int waktu_loading  = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent activitymain =new Intent(Splash.this, MainActivity.class);
                startActivity(activitymain);
                finish();
            }
        },waktu_loading);
    }
}
