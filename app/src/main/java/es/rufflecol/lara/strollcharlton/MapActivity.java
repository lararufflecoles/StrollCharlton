package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextAppearance);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_map_view_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_map_view:
                openNormalView();
                return true;
            case R.id.action_satellite_view:
                openSatelliteView();
                return true;
            case R.id.action_terrain_view:
                openTerrainView();
                return true;
            case R.id.action_list_view:
                openListView();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_useful_links:
                openUsefulLinks();
                return true;
            case R.id.action_about:
                openAbout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setMapType(int mapType) {
        FragmentManager fragmentManager = getSupportFragmentManager(); // Getting a reference to the FragmentManager
        MapFragment fragmentMap = (MapFragment) fragmentManager.findFragmentById(R.id.map); // Typecasting Fragment to MapFragment because Fragment can't see MapFragment's methods
        fragmentMap.setMapType(mapType); // If we don't do the above, we can't use our own method to set the map type
    }

    private void openNormalView() {
        setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void openSatelliteView() {
        setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    private void openTerrainView() {
        setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    private void openListView() {
        Intent openListView = new Intent(MapActivity.this, ListActivity.class);
        startActivity(openListView);
    }

    private void openSettings() {
        Intent openSettingsView = new Intent(MapActivity.this, SettingsActivity.class);
        startActivity(openSettingsView);
    }

    private void openUsefulLinks() {
        Intent openUsefulLinksView = new Intent(MapActivity.this, UsefulLinksActivity.class);
        startActivity(openUsefulLinksView);
    }

    private void openAbout() {
        Intent openAboutView = new Intent(MapActivity.this, AboutActivity.class);
        startActivity(openAboutView);
    }
}