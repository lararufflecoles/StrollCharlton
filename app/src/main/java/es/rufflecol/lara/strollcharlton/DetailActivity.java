package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    final static String PUT_EXTRA_DETAIL_DATA_ITEM = "Detail Data Item";

    private DetailData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextAppearance);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        data = intent.getParcelableExtra(PUT_EXTRA_DETAIL_DATA_ITEM);
        setTitle(data.getTitle());
        TextView textView = (TextView) findViewById(R.id.detail);
        textView.setText(data.getDetail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_detail_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                openShare();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_about:
                openAbout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openShare() {
//        Intent intent = getIntent();
//
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.getParcelableExtra(Intent.EXTRA_SUBJECT, getString(DetailActivity.PUT_EXTRA_DETAIL_DATA_ITEM));
//        sendIntent.getParcelableExtra(Intent.EXTRA_TEXT, getString(DetailActivity.PUT_EXTRA_DETAIL_DATA_ITEM));
//        sendIntent.setType("text/plain");
//
//        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share)));
    }

    private void openSettings() {
        Intent openSettingsView = new Intent(this, SettingsActivity.class);
        startActivity(openSettingsView);
    }

    private void openAbout() {
        Intent openAboutView = new Intent(this, AboutActivity.class);
        startActivity(openAboutView);
    }
}
