package com.postinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoIdMOdel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("google_place_id")
    @Expose
    private String googlePlaceId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("locality")
    @Expose
    private Object locality;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("administrative_area_level_1")
    @Expose
    private Object administrativeAreaLevel1;
    @SerializedName("administrative_area_level_2")
    @Expose
    private Object administrativeAreaLevel2;
    @SerializedName("address_components")
    @Expose
    private Object addressComponents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeoIdMOdel withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public GeoIdMOdel withGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GeoIdMOdel withLocation(String location) {
        this.location = location;
        return this;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public GeoIdMOdel withLat(Object lat) {
        this.lat = lat;
        return this;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public GeoIdMOdel withLng(Object lng) {
        this.lng = lng;
        return this;
    }

    public Object getLocality() {
        return locality;
    }

    public void setLocality(Object locality) {
        this.locality = locality;
    }

    public GeoIdMOdel withLocality(Object locality) {
        this.locality = locality;
        return this;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public GeoIdMOdel withCountry(Object country) {
        this.country = country;
        return this;
    }

    public Object getAdministrativeAreaLevel1() {
        return administrativeAreaLevel1;
    }

    public void setAdministrativeAreaLevel1(Object administrativeAreaLevel1) {
        this.administrativeAreaLevel1 = administrativeAreaLevel1;
    }

    public GeoIdMOdel withAdministrativeAreaLevel1(Object administrativeAreaLevel1) {
        this.administrativeAreaLevel1 = administrativeAreaLevel1;
        return this;
    }

    public Object getAdministrativeAreaLevel2() {
        return administrativeAreaLevel2;
    }

    public void setAdministrativeAreaLevel2(Object administrativeAreaLevel2) {
        this.administrativeAreaLevel2 = administrativeAreaLevel2;
    }

    public GeoIdMOdel withAdministrativeAreaLevel2(Object administrativeAreaLevel2) {
        this.administrativeAreaLevel2 = administrativeAreaLevel2;
        return this;
    }

    public Object getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(Object addressComponents) {
        this.addressComponents = addressComponents;
    }

    public GeoIdMOdel withAddressComponents(Object addressComponents) {
        this.addressComponents = addressComponents;
        return this;
    }
}
