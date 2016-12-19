package com.dsecet.askcicle.universities;

import android.support.annotation.NonNull;
import android.util.Log;

import com.askcicle.library.rx.retrofit.BaseResultVo;
import com.askcicle.library.rx.retrofit.HttpResult;
import com.askcicle.library.rx.retrofit.factory.ServiceFactory;
import com.askcicle.library.utils.ToastUtils;
import com.dsecet.askcicle.api.SimpleService;
import com.dsecet.askcicle.mode.University;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.jakewharton.rxbinding.internal.Preconditions.checkNotNull;

/**
 * Created by zl852 on 2016/12/13.
 */

public class UniversityPresenter implements UniversityContract.Presenter {

    private final UniversityContract.View mUniversityView;

    public UniversityPresenter (@NonNull UniversityContract.View statisticsView) {

        mUniversityView = checkNotNull(statisticsView, "UniversityView cannot be null!");

    }

    @Override
    public void start() {

    }

    @Override
    public void loadData() {

        SimpleService simpleService = ServiceFactory.getInstance().createService(SimpleService.class);

        Map<String, Object> bodyParameter = new HashMap<String, Object>();
        bodyParameter.put("Session-Token", "");
        bodyParameter.put("JsonContent", true);
        bodyParameter.put("page", 1);
        bodyParameter.put("size", 20);

        Observable<HttpResult<BaseResultVo<University>>> recentlyDate = simpleService.getUniversitys(bodyParameter);

        recentlyDate.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

                .subscribe(new Subscriber<HttpResult<BaseResultVo<University>>>() {
            @Override
            public void onCompleted() {
                ToastUtils.getInstance().showToast("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                ToastUtils.getInstance().showToast("onError");
            }

            @Override
            public void onNext(HttpResult<BaseResultVo<University>> listHttpResult) {

                List<University> listData = listHttpResult.data.listData;

                for (University university : listData) {
                    Log.e("name ", university.getName());
                }


            }
        });
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void LoadeMore() {

    }
}
