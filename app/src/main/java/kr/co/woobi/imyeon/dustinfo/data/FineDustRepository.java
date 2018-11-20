package kr.co.woobi.imyeon.dustinfo.data;



import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;
import retrofit2.Callback;

public interface FineDustRepository {
    boolean isAvailable();
    void getFineDustData(Callback<FineDust> callback);
}
