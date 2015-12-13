package es.rufflecol.lara.strollcharlton;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("places")
    private List<ModelItem> places;

    public List<ModelItem> getPlaces() {
        return places;
    }

    public void setPlaces(List<ModelItem> places) {
        this.places = places;
    }
}
