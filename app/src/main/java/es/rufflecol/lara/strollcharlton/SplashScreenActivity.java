package es.rufflecol.lara.strollcharlton;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private String text;
    private boolean timerCompleted = false;
    private boolean jsonDownloaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView textView = (TextView) findViewById(R.id.splash_screen);
        textView.setText(R.string.app_name);

        DownloadJsonTask downloadJsonTask = new DownloadJsonTask();
        downloadJsonTask.execute();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerCompleted = true;
                startListActivityIfJsonDownloadedAndTimerCompleted();
            }
        }, 1000);
    }

    private class DownloadJsonTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... urls) {
            try {
                URL url = new URL(Config.DATA_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                text = readStream(urlConnection.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (text != null) {
                writeStreamToFile(text);
            } else {
                return false;
            }

            File directory = getFilesDir();
            File file = new File(directory, Config.FILE_NAME);
            if (file.exists()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean wasSuccessful) {
            if (wasSuccessful) {
                jsonDownloaded = true;
                startListActivityIfJsonDownloadedAndTimerCompleted();
            } else {
                Toast.makeText(SplashScreenActivity.this, "Error reading data", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void startListActivityIfJsonDownloadedAndTimerCompleted() {
        if (jsonDownloaded && timerCompleted) {
            Intent listActivity = new Intent(SplashScreenActivity.this, ListActivity.class);
            startActivity(listActivity);
            finish();
        }
    }

    private String readStream(InputStream inputStream) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }

    private void writeStreamToFile(String data) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(Config.FILE_NAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException exception) {
            Log.e("Exception", "File write failed: " + exception.toString());
        }
    }
}