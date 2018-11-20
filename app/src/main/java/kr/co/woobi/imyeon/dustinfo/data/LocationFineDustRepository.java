package kr.co.woobi.imyeon.dustinfo.data;

import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;
import kr.co.woobi.imyeon.dustinfo.util.FineDustUtil;
import retrofit2.Callback;

public class LocationFineDustRepository implements FineDustRepository {
    private FineDustUtil mFineDustUtil;
    private  double mLatitude;
    private  double mLongitude;

    public LocationFineDustRepository() {
        mFineDustUtil = new FineDustUtil();
    }

    public LocationFineDustRepository(double lat, double lng) {
        this();
        this.mLatitude = lat;
        this.mLongitude = lng;
    }

    @Override
    public boolean isAvailable() {
        if(mLatitude !=0.0 && mLongitude !=0.0){
            return true;
        }
        return false;
    }

    @Override
    public void getFineDustData(Callback<FineDust> callback) {
        mFineDustUtil.getApi().getFindDust(mLatitude, mLongitude).enqueue(callback);
    }
}
