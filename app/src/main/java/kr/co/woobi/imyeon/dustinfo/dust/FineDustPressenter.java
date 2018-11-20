package kr.co.woobi.imyeon.dustinfo.dust;

import kr.co.woobi.imyeon.dustinfo.data.FineDustRepository;
import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FineDustPressenter implements FineDustContract.UserActionListener {
    private final FineDustRepository mRepository;
    private final FineDustContract.View mView;

    public FineDustPressenter(FineDustRepository repository, FineDustContract.View View) {
        this.mRepository = repository;
        this.mView = View;
    }

    @Override
    public void loadFinedustData() {
        if(mRepository.isAvailable()){
            mView.loadingStart();

            mRepository.getFineDustData(new Callback<FineDust>() {
                @Override
                public void onResponse(Call<FineDust> call, Response<FineDust> response) {
                    mView.showFineDustResult(response.body());
                    mView.loadingEnd();
                }

                @Override
                public void onFailure(Call<FineDust> call, Throwable t) {
                    mView.showLoadError(t.getLocalizedMessage());
                    mView.loadingEnd();

                }
            });
        }

    }
}
