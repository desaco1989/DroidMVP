package com.mobile.rxjava2andretrofit2.main.view;


import com.mobile.rxjava2andretrofit2.base.IBaseView;

/**
 * author    : xxxxxxxxxxx
 * e-mail    : xxxxxxxxxxx@qq.com
 * date      : 2020/3/7 15:44
 * introduce :
 */


public interface IMainView extends IBaseView {

    void mainDataSuccess(String success);

    void mainDataError(String error);
}
