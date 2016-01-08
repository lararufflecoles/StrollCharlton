package es.rufflecol.lara.strollcharlton;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StrollDataModel {


    @SerializedName("useful_links")
    private String usefulLinks;

    public String getUsefulLinks() {
        return usefulLinks;
    }



    @SerializedName("places")
    private List<DetailData> places;

    public List<DetailData> getPlaces() {
        return places;
    }
}