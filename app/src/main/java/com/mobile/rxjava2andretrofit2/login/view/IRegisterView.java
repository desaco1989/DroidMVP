package com.mobile.rxjava2andretrofit2.login.view;

import com.mobile.rxjava2andretrofit2.base.IBaseView;

public interface IRegisterView extends IBaseView {

    void registerSuccess(String success);

    void registerError(String error);

}
