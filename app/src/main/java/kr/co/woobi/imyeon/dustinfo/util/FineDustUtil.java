package kr.co.woobi.imyeon.dustinfo.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FineDustUtil {
    private FindDustApi mGetApi;

    public FineDustUtil() {
        Retrofit mRetrofit= new Retrofit.Builder()
                .baseUrl(FindDustApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mGetApi=mRetrofit.create(FindDustApi.class);
    }
    public  FindDustApi getApi(){
        return mGetApi;
    }
}
