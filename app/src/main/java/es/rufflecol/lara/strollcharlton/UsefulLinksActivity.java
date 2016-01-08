package es.rufflecol.lara.strollcharlton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UsefulLinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_links);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextAppearance);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        StrollDataModel data = readDataFromFileAndParse();

        TextView usefulLinksIntroTextView = (TextView) findViewById(R.id.useful_links);
        usefulLinksIntroTextView.setText(Html.fromHtml(data.getUsefulLinks()));
        usefulLinksIntroTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private StrollDataModel readDataFromFileAndParse() {
        String text = readJsonFromFile();
        Gson gson = new Gson();
        StrollDataModel parsedData = gson.fromJson(text, StrollDataModel.class);
        return parsedData;
    }

    private String readJsonFromFile() {
        String returnValue = "";

        try {
            InputStream inputStream = openFileInput(Config.FILE_NAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                returnValue = stringBuilder.toString();
            }
        } catch (FileNotFoundException exception) {
            Log.e("Login activity", "File not found: " + exception.toString());
        } catch (IOException exception) {
            Log.e("Login activity", "Cannot read file: " + exception.toString());
        }
        return returnValue;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_generic_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}