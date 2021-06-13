package com.wiuma.nemf.Services;

import com.wiuma.nemf.Models.Showcase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("discover")
    Call<ArrayList<Showcase>> getShowcase();
}
