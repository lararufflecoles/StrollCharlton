package es.rufflecol.lara.strollcharlton;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DetailData implements Parcelable {

    @SerializedName("title")
    private String title;

    @SerializedName("snippet")
    private String snippet;

    @SerializedName("detail")
    private String detail;

    @SerializedName("image")
    private String image;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        charltonHouse.setTitle("Charlton House");
        charltonHouse.setSnippet("Jacobean building built in 1612");
        charltonHouse.setDetail("Jacobean building in the south-east London suburb of Charlton." +
                "\n\nBuilt in 1612 during the reign of James I for his son Prince Henry's tutor Sir Adam Newton." +
                "\n\nPresumed to have been designed by John Thorpe." +
                "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        charltonHouse.setImage("http://www.freetoursoflondon.com/wp-content/uploads/2015/10/shutterstock_48016777.jpg");
        charltonHouse.setLatitude(51.480752);
        charltonHouse.setLongitude(0.037084);
        data.add(charltonHouse);

        DetailData charltonAthletic = new DetailData();
        charltonAthletic.setTitle("Charlton Athletic FC");
        charltonAthletic.setSnippet("Championship team who play at The Valley");
        charltonAthletic.setDetail("Jacobean building in the south-east London suburb of Charlton." +
                "\n\nBuilt in 1612 during the reign of James I for his son Prince Henry's tutor Sir Adam Newton." +
                "\n\nPresumed to have been designed by John Thorpe." +
                "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        charltonAthletic.setImage("https://pbs.twimg.com/profile_images/341069384/wallpaper4-1024.jpg");
        charltonAthletic.setLatitude(51.486526);
        charltonAthletic.setLongitude(0.036524);
        data.add(charltonAthletic);

        DetailData whiteSwan = new DetailData();
        whiteSwan.setTitle("The White Swan");
        whiteSwan.setSnippet("Cosy pub on the main road through Charlton");
        whiteSwan.setDetail("Jacobean building in the south-east London suburb of Charlton." +
                "\n\nBuilt in 1612 during the reign of James I for his son Prince Henry's tutor Sir Adam Newton." +
                "\n\nPresumed to have been designed by John Thorpe." +
                "\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        whiteSwan.setImage("http://pubshistory.com/KentPubs/Charlton/WhiteHart.jpg");
        whiteSwan.setLatitude(51.481830);
            whiteSwan.setLongitude(0.037523);
        data.add(whiteSwan);

        return data;
    }

    protected DetailData(Parcel in) /** Parcelabler created constructor **/ {
        title = in.readString();
        snippet = in.readString();
        detail = in.readString();
        image = in.readString();
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
        dest.writeString(image);
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