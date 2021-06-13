package com.wiuma.nemf;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wiuma.nemf.Models.Showcase;
import com.wiuma.nemf.Services.APIClient;
import com.wiuma.nemf.Services.APIInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Showcase>> data = new MutableLiveData<>();
    public MutableLiveData<String> status = new MutableLiveData<>("empty");

    public void fetchShowcase() {
        status.setValue("fetch started");
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<Showcase>> call = apiInterface.getShowcase();
        call.enqueue(new Callback<ArrayList<Showcase>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<Showcase>> call, @NotNull Response<ArrayList<Showcase>> response) {
                status.setValue("fetch onResponse");
                if (response.body() != null) {
                    status.setValue("fetch response is not null");
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<Showcase>> call, @NotNull Throwable t) {
                status.setValue("fetch onFailure");
                Log.e("onFailure", t.toString());
            }
        });
    }
}
