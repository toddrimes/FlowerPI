package com.makeinfo.flowerpi.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PageModel {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("appId")
    @Expose
    public String appId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("alias")
    @Expose
    public String alias;
    @SerializedName("modules")
    @Expose
    public List<Module> modules = new ArrayList<Module>();
    @SerializedName("pages")
    @Expose
    public List<Object> pages = new ArrayList<Object>();

}