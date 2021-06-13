package com.wiuma.nemf.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Showcase implements Serializable {

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("featured")
    @Expose
    public List<Featured> featured = null;

    @SerializedName("products")
    @Expose
    public List<Product> products = null;

    @SerializedName("categories")
    @Expose
    public List<Category> categories = null;

    @SerializedName("collections")
    @Expose
    public List<Collection> collections = null;

    @SerializedName("shops")
    @Expose
    public List<Shop> shops = null;

}
