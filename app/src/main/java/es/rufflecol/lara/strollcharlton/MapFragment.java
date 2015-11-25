package es.rufflecol.lara.strollcharlton;

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

public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, GoogleMap.OnMyLocationChangeListener, GoogleMap.OnInfoWindowClickListener /* interfaces */ {

    private boolean flag = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    private void initialiseMap() /** Method I created, not one called from any of the classes or interfaces added above **/
    {
        getMap().setMyLocationEnabled(true);
        getMap().getUiSettings().setZoomControlsEnabled(true);
        getMap().setOnMyLocationChangeListener(this);
        getMap().setOnInfoWindowClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        initialiseMap();

        map.addMarker(new MarkerOptions()
                .position(new LatLng(21.276812, -157.826665))
                .title("Moana Surfrider")
                .snippet("Tremendous beach side hotel"));
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

        // getActivity should be called whenever you need a context within a fragment

//        switch (marker.getTitle()) {
//            case "Charlton House":
//                Intent intentCharltonHouse = new Intent(getActivity(), DetailActivity.class);
//                intentCharltonHouse.putExtra("activityDetailTitle", R.string.charlton_house_detail_title);
////                intentCharltonHouse.putExtra("activityDetailImage", R.drawable.charlton_house);
//                intentCharltonHouse.putExtra("activityDetailUrl", R.string.charlton_house_url_link);
//                intentCharltonHouse.putExtra("activityDetailText", R.string.charlton_house_detail_text);
//                startActivity(intentCharltonHouse);
//                break;
//        }
    }
}