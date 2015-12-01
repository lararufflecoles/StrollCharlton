package es.rufflecol.lara.strollcharlton;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class DetailData implements Parcelable {

    private String title;
    private String snippet;
    private String detail;
    private double latitude;
    private double longitude;

    public DetailData() /** Default constructor, needs to be re-declared as the Parcelabler one overrides it **/ {
    }

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


    protected DetailData(Parcel in) /** Parcelabler created constructor **/ {
        title = in.readString();
        snippet = in.readString();
        detail = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(snippet);
        dest.writeString(detail);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DetailData> CREATOR = new Parcelable.Creator<DetailData>() {
        @Override
        public DetailData createFromParcel(Parcel in) {
            return new DetailData(in);
        }

        @Override
        public DetailData[] newArray(int size) {
            return new DetailData[size];
        }
    };
}