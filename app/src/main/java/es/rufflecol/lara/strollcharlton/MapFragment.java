package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener /* interfaces */ {

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    private void initialiseMap() { /** Method I created, not one called from any of the classes or interfaces added above **/
        getMap().setMyLocationEnabled(true);
        getMap().getUiSettings().setZoomControlsEnabled(true);
        getMap().setOnMyLocationChangeListener(this);
        getMap().setOnInfoWindowClickListener(this);
    }

    public void setMapType(int type) { /** Method I created, not one called from any of the classes or interfaces added above **/
        getMap().setMapType(type);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        initialiseMap();

        List<DetailData> data = DetailData.fetchData();
        for (DetailData item : data) {
            MarkerOptions marker = new MarkerOptions()
                    .position(new LatLng(item.getLatitude(), item.getLongitude()))
                    .title(item.getTitle())
                    .snippet(item.getSnippet());
            map.addMarker(marker);
        }
    }

    @Override
    public void onMyLocationChange(Location location) {
        if (flag) {
            CameraPosition position = CameraPosition.builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude()))
                    .zoom(16f)
                    .build();
            getMap().animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
            flag = false;
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
//        Intent detailActivity = new Intent(getActivity(), DetailActivity.class);
//        detailActivity.putExtra(DetailActivity.PUT_EXTRA_DETAIL_DATA_ITEM, dataItem);
//        startActivity(detailActivity);
    }
}