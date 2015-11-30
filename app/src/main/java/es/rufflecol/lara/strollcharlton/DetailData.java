package es.rufflecol.lara.strollcharlton;

import java.util.ArrayList;
import java.util.List;

public class DetailData {

    private String title;
    private String snippet;
    private String detail;
    private double latitude;
    private double longitude;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public static List<DetailData> fetchData() {

        List<DetailData> data = new ArrayList<>();

        DetailData charltonHouse = new DetailData();
        charltonHouse.setLatitude(51.480752);
        charltonHouse.setLongitude(0.037084);
        charltonHouse.setTitle("Charlton House");
        charltonHouse.setSnippet("Jacobean building built in 1612");
        charltonHouse.setDetail("blah blah blah");
        data.add(charltonHouse);

        DetailData charltonAthletic = new DetailData();
        charltonAthletic.setLatitude(51.486526);
        charltonAthletic.setLongitude(0.036524);
        charltonAthletic.setTitle("Charlton Athletic FC");
        charltonAthletic.setSnippet("Championship team who play at The Valley");
        charltonAthletic.setDetail("blah blah blah");
        data.add(charltonAthletic);

        return data;
    }
}