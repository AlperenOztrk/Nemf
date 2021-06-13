package com.wiuma.nemf.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("parent_id")
    @Expose
    public Integer parentId;
    @SerializedName("order")
    @Expose
    public Integer order;
    @SerializedName("parent_category")
    @Expose
    public ParentCategory parentCategory;
    @SerializedName("logo")
    @Expose
    public Logo logo;
    @SerializedName("cover")
    @Expose
    public Cover cover;
    @SerializedName("children")
    @Expose
    public List<Object> children = null;

}
