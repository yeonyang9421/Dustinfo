package kr.co.woobi.imyeon.dustinfo.util;

import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FindDustApi {
    String BASE_URL="http://apis.skplanetx.com/";
//
    @Headers("appKey: d39d6ed5-38b2-3205-b7f2-db02ea0ecf3a")
    @GET("weather/dust?version=1")
    Call<FineDust> getFindDust(@Query("lat") double latitude, @Query("lon") double longitude);

}
