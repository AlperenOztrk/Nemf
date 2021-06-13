package com.wiuma.nemf.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("definition")
    @Expose
    public String definition;
    @SerializedName("name_updateable")
    @Expose
    public Boolean nameUpdateable;
    @SerializedName("vacation_mode")
    @Expose
    public Integer vacationMode;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("shop_payment_id")
    @Expose
    public Integer shopPaymentId;
    @SerializedName("popular_products")
    @Expose
    public List<PopularProduct> popularProducts = null;
    @SerializedName("product_count")
    @Expose
    public Integer productCount;
    @SerializedName("shop_rate")
    @Expose
    public Integer shopRate;
    @SerializedName("comment_count")
    @Expose
    public Integer commentCount;
    @SerializedName("follower_count")
    @Expose
    public Integer followerCount;
    @SerializedName("is_editor_choice")
    @Expose
    public Boolean isEditorChoice;
    @SerializedName("is_following")
    @Expose
    public Boolean isFollowing;
    @SerializedName("cover")
    @Expose
    public Cover cover;
    @SerializedName("share_url")
    @Expose
    public String shareUrl;
    @SerializedName("logo")
    @Expose
    public Logo logo;

}
