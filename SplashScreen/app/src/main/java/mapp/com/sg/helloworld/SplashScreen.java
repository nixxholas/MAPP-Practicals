package mapp.com.sg.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by nixho on 18-Oct-16.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Launch the layout -> splash.xml
        setContentView(R.layout.splash);
        Thread splashThread = new Thread() {

            public void run() {
                try {
                    // sleep time in milliseconds (3000 = 3sec)
                    sleep(3000);
                } catch (InterruptedException e) {
                    // Trace the error
                    e.printStackTrace();
                } finally {
                    // Launch the MainActivity class
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        };
        // To Start the thread
        splashThread.start();

    }
}
