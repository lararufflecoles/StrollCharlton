package es.rufflecol.lara.strollcharlton;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFragment extends SupportMapFragment implements
        OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener /* interfaces */ {

    private Map<String, DetailData> markerIdToDetailDataMap = new HashMap<>(); // HashMap added so we can combine DetailData and Marker

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    public void setMapType(int type) { /** Method called when user taps MapActivity.java toolbar action button **/
        getMap().setMapType(type);
    }

    private void initialiseMap(GoogleMap map) { /** Method putting all the tasks together that need to be run when the map is initialised **/
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true); /** Adds the + - options to the screen **/
        map.setOnInfoWindowClickListener(this);
    }
    
    private void setLocationToCharlton(GoogleMap map) {
        LatLng charlton = new LatLng(51.484835, 0.038323);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(charlton, 14f);
        map.animateCamera(cameraUpdate);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        initialiseMap(map);
        setLocationToCharlton(map);

        List<DetailData> dataList = readDataFromFileAndParse();
        for (DetailData item : dataList) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(new LatLng(item.getLatitude(), item.getLongitude()))
                    .title(item.getTitle())
                    .snippet(item.getSnippet());
            Marker marker = map.addMarker(markerOptions); // 'Marker marker =' now assigns 'map.addMarker(markerOptions)' to itself - a local variable
            String markerId = marker.getId(); // We can now reference marker and get its ID... and assign that to markedId
            markerIdToDetailDataMap.put(markerId, item); // Therefore, markerId and item can now be put into the HashMap markerIdToDetailDataMap
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent detailActivity = new Intent(getActivity(), DetailActivity.class);
        String markerId = marker.getId(); // Getting the id of the marker clicked
        DetailData item = markerIdToDetailDataMap.get(markerId); // Getting the DetailData item from the HashMap using the marker id as the key
        detailActivity.putExtra(DetailActivity.PUT_EXTRA_DETAIL_DATA_ITEM, item); //
        startActivity(detailActivity);
    }

    private List<DetailData> readDataFromFileAndParse() {
        String text = readJsonFromFile();
        Gson gson = new Gson();
        DetailDataModel parsedData = gson.fromJson(text, DetailDataModel.class);
        List<DetailData> dataList = parsedData.getPlaces();
        return dataList;
    }

    private String readJsonFromFile() {
        String returnValue = "";

        try {
            InputStream inputStream = getActivity().openFileInput("places.json");

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
}