package kr.co.woobi.imyeon.dustinfo.model.fine_dust;

import android.support.v4.widget.SwipeRefreshLayout;

public  class Station {
    private String latitude;
    private String  longitude;
    private String name;
    private  String id;


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
