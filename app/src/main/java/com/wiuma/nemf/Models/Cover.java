package com.wiuma.nemf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cover implements Serializable {

    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("medium")
    @Expose
    public Medium medium;
    @SerializedName("thumbnail")
    @Expose
    public Thumbnail thumbnail;

}
