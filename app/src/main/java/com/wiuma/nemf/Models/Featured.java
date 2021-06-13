package com.wiuma.nemf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Featured implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("cover")
    @Expose
    public Cover cover;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("sub_title")
    @Expose
    public String subTitle;

}
