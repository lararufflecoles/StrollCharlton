package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        TextView textView = (TextView) findViewById(R.id.detail_text);
        textView.setText(data.getDetail());

        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        Picasso.with(this)
                .load(data.getImage())
                .into(imageView);
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
        Intent shareDetailActivity = new Intent();

        shareDetailActivity.setAction(Intent.ACTION_SEND);
        shareDetailActivity.putExtra(Intent.EXTRA_SUBJECT, data.getTitle());
        shareDetailActivity.putExtra(Intent.EXTRA_TEXT, data.getDetail());
        shareDetailActivity.setType("text/plain");

        startActivity(Intent.createChooser(shareDetailActivity, getResources().getText(R.string.share)));
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
