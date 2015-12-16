package es.rufflecol.lara.strollcharlton;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailDataModel {

    @SerializedName("places")
    private List<DetailData> places;

    public List<DetailData> getPlaces() {
        return places;
    }
}
