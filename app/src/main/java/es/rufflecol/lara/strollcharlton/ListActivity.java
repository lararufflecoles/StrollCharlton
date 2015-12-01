package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListActivity extends AppCompatActivity implements RecyclerAdapter.OnRecyclerItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextAppearance);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);

        List<DetailData> dataList = DetailData.fetchData();
        adapter = new RecyclerAdapter(dataList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRecyclerItemClick(DetailData dataItem) {
        Intent detailActivity = new Intent(this, DetailActivity.class);
        detailActivity.putExtra(DetailActivity.PUT_EXTRA_DETAIL_DATA_ITEM, dataItem);
        startActivity(detailActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_list_view_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_map_view:
                openMap();
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

    private void openMap() {
        Intent openMapView = new Intent(this, MapActivity.class);
        startActivity(openMapView);
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