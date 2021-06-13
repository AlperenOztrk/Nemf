package com.wiuma.nemf.Models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopularProduct implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("code")
    @Expose
    public Object code;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("definition")
    @Expose
    public String definition;
    @SerializedName("old_price")
    @Expose
    public Integer oldPrice;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("stock")
    @Expose
    public Integer stock;
    @SerializedName("max_installment")
    @Expose
    public Object maxInstallment;
    @SerializedName("commission_rate")
    @Expose
    public Integer commissionRate;
    @SerializedName("cargo_time")
    @Expose
    public Integer cargoTime;
    @SerializedName("is_cargo_free")
    @Expose
    public Boolean isCargoFree;
    @SerializedName("is_new")
    @Expose
    public Boolean isNew;
    @SerializedName("reject_reason")
    @Expose
    public Object rejectReason;
    @SerializedName("category_id")
    @Expose
    public Integer categoryId;
    @SerializedName("view_count")
    @Expose
    public Integer viewCount;
    @SerializedName("difference")
    @Expose
    public String difference;
    @SerializedName("is_editor_choice")
    @Expose
    public Boolean isEditorChoice;
    @SerializedName("comment_count")
    @Expose
    public Integer commentCount;
    @SerializedName("is_owner")
    @Expose
    public Boolean isOwner;
    @SerializedName("is_approved")
    @Expose
    public Boolean isApproved;
    @SerializedName("is_active")
    @Expose
    public Boolean isActive;
    @SerializedName("share_url")
    @Expose
    public String shareUrl;
    @SerializedName("is_liked")
    @Expose
    public Boolean isLiked;
    @SerializedName("like_count")
    @Expose
    public Integer likeCount;
    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("category")
    @Expose
    public Category category;

}
