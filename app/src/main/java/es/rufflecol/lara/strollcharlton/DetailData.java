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

    @SerializedName("image")
    private String image;

    @SerializedName("detail")
    private String detail;

    @SerializedName("website")
    private String website;

    @SerializedName("website_vanity")
    private String websiteVanity;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsiteVanity() {
        return websiteVanity;
    }

    public void setWebsiteVanity(String websiteVanity) {
        this.websiteVanity = websiteVanity;
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



    /** Parcelable to send DetailData to DetailActivity **/
    protected DetailData(Parcel in) /** Parcelabler created constructor **/ {
        title = in.readString();
        snippet = in.readString();
        image = in.readString();
        detail = in.readString();
        website = in.readString();
        websiteVanity = in.readString();
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
        dest.writeString(image);
        dest.writeString(detail);
        dest.writeString(website);
        dest.writeString(websiteVanity);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

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