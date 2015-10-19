package com.makeinfo.flowerpi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Module {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("moduleType")
    @Expose
    public String moduleType;
    @SerializedName("properties")
    @Expose
    public Properties properties;
    @SerializedName("tileType")
    @Expose
    public Long tileType;
    @SerializedName("itemCount")
    @Expose
    public Long itemCount;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("data")
    @Expose
    public List<Datum> data = new ArrayList<Datum>();

}