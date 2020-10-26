package com.mobile.rxjava2andretrofit2.mine.model;

import com.mobile.rxjava2andretrofit2.mine.model.base.IMineModel;
import com.mobile.rxjava2andretrofit2.mine.request.MineRequest;
import com.mobile.rxjava2andretrofit2.manager.RetrofitManager;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * author    : xxxxxxxxxxx
 * e-mail    : xxxxxxxxxxx@qq.com
 * date      : 2019/3/10 17:03
 * introduce :
 */

public class MineModelImpl implements IMineModel {

    private static final String TAG = "MineModelImpl";

    public MineModelImpl() {
    }

    @Override
    public Observable<ResponseBody> mineData(Map<String, String> bodyParams) {
        return RetrofitManager.getInstance().getRetrofit()
                .create(MineRequest.class)
                .getMineData(bodyParams);
    }

    @Override
    public Observable<ResponseBody> submitFeedback(Map<String, String> bodyParams) {
        return RetrofitManager.getInstance().getRetrofit()
                .create(MineRequest.class)
                .getFeedbackResult(bodyParams);
    }

}
