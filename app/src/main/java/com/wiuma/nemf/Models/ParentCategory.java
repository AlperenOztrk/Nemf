package com.wiuma.nemf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParentCategory implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("parent_id")
    @Expose
    public Object parentId;
    @SerializedName("order")
    @Expose
    public Integer order;
    @SerializedName("parent_category")
    @Expose
    public Object parentCategory;

}
