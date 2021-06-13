package com.wiuma.nemf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Collection implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("definition")
    @Expose
    public String definition;
    @SerializedName("start")
    @Expose
    public String start;
    @SerializedName("end")
    @Expose
    public Object end;
    @SerializedName("share_url")
    @Expose
    public String shareUrl;
    @SerializedName("cover")
    @Expose
    public Cover cover;
    @SerializedName("logo")
    @Expose
    public Logo logo;

}
