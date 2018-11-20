package kr.co.woobi.imyeon.dustinfo.dust;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.woobi.imyeon.dustinfo.R;
import kr.co.woobi.imyeon.dustinfo.data.FineDustRepository;
import kr.co.woobi.imyeon.dustinfo.data.LocationFineDustRepository;
import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;

public class FineDustFragment extends Fragment implements FineDustContract.View {
    private TextView mLocationTextview;
    private TextView mTimeTextView;
    private TextView mDustTextView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private FineDustPressenter mPresenter;
    private FineDustRepository mRepository;
    public static  FineDustFragment newInstance(double lat, double lng){
        Bundle args = new Bundle();
        args.putDouble("lat", lat);
        args.putDouble("lng", lng);
        FineDustFragment fragment=new FineDustFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments() !=null){
            double lat = getArguments().getDouble("lat");
            double lng= getArguments().getDouble("lng");
            mRepository=new LocationFineDustRepository(lat, lng);
        }else{
            mRepository=new LocationFineDustRepository();

        }
        mPresenter=new FineDustPressenter(mRepository, this);
        mPresenter.loadFinedustData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_dust, container, false);
        mLocationTextview = view.findViewById(R.id.result_location_text);
        mTimeTextView = view.findViewById(R.id.result_time_text);
        mDustTextView = view.findViewById(R.id.result_dust_text);
        if (savedInstanceState != null) {
            //복원
            mLocationTextview.setText(savedInstanceState.getString("location"));
            mTimeTextView.setText(savedInstanceState.getString("time"));
            mDustTextView.setText(savedInstanceState.getString("dust"));
        }
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadFinedustData();
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("location", mLocationTextview.getText().toString());
        outState.putString("time", mTimeTextView.getText().toString());
        outState.putString("dust", mDustTextView.getText().toString());

    }

    @Override
    public void showFineDustResult(FineDust fineDust) {
        mLocationTextview.setText(fineDust.getWeather().getDust().get(0).getStation().getName());
        mTimeTextView.setText(fineDust.getWeather().getDust().get(0).getTimeObservation());
        mDustTextView.setText(fineDust.getWeather().getDust().get(0).getPm10().getValue() + " ㎍/m³,"
                + fineDust.getWeather().getDust().get(0).getPm10().getGrade());

    }

    @Override
    public void showLoadError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadingStart() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void loadingEnd() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void reload(double lat, double lng) {
        mRepository = new LocationFineDustRepository(lat, lng);
        mPresenter =new FineDustPressenter(mRepository, this);
        mPresenter.loadFinedustData();
    }
}
