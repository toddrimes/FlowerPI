package com.makeinfo.flowerpi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Datum {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("itemType")
    @Expose
    public String itemType;
    @SerializedName("mpxId")
    @Expose
    public String mpxId;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("seriesType")
    @Expose
    public String seriesType;
    @SerializedName("seriesCategory")
    @Expose
    public String seriesCategory;
    @SerializedName("showColor")
    @Expose
    public String showColor;
    @SerializedName("hdposterurl")
    @Expose
    public String hdposterurl;
    @SerializedName("hdposterurlResume")
    @Expose
    public String hdposterurlResume;
    @SerializedName("gridFocusImage")
    @Expose
    public String gridFocusImage;

}