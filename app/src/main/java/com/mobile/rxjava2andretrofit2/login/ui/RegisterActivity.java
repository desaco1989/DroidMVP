package com.mobile.rxjava2andretrofit2.login.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.mobile.rxjava2andretrofit2.R;
import com.mobile.rxjava2andretrofit2.base.BaseMvpAppActivity;
import com.mobile.rxjava2andretrofit2.base.IBaseView;
import com.mobile.rxjava2andretrofit2.login.presenter.LoginPresenterImpl;
import com.mobile.rxjava2andretrofit2.login.view.IRegisterView;
import com.mobile.rxjava2andretrofit2.manager.RetrofitManager;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseMvpAppActivity<IBaseView, LoginPresenterImpl>
        implements IRegisterView {

    @BindView(R.id.imv_back)
    ImageView imvBack;
    @BindView(R.id.layout_back)
    FrameLayout layoutBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText edtConfirmPassword;
    @BindView(R.id.tev_register)
    TextView tevRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        edtUserName.setText("13510001000");
        edtPassword.setText("12345678");
        edtConfirmPassword.setText("12345678");
    }

    @Override
    protected void initViews() {
        addContentView(loadView, layoutParams);
        setToolbar(true, R.color.color_FFFFFFFF);
    }

    @Override
    protected void initLoadData() {

    }

    @Override
    protected LoginPresenterImpl attachPresenter() {
        return new LoginPresenterImpl(this);
    }

    @Override
    public void showLoading() {
        if (loadView != null && !loadView.isShown()) {
            loadView.setVisibility(View.VISIBLE);
            loadView.start();
        }
    }

    @Override
    public void hideLoading() {
        if (loadView != null && loadView.isShown()) {
            loadView.stop();
            loadView.setVisibility(View.GONE);
        }
    }

    @Override
    public void registerSuccess(String success) {

    }

    @Override
    public void registerError(String error) {
        showToast(error, true);
    }

    private void initRegister() {
        if (RetrofitManager.isNetworkAvailable(this)) {
            bodyParams.clear();
            bodyParams.put("username", edtUserName.getText().toString());
            bodyParams.put("password", edtPassword.getText().toString());
            bodyParams.put("repassword", edtConfirmPassword.getText().toString());
//        String data = MapManager.mapToJsonStr(bodyParams);
//        String requestData = JSONObject.toJSONString(bodyParams);
//        LogManager.i(TAG, "requestData*****" + requestData);
            presenter.register(bodyParams);
        } else {
            showToast(getResources().getString(R.string.please_check_the_network_connection), true);
        }
    }

    @OnClick({R.id.layout_back, R.id.tev_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_back:
                finish();
                break;
            case R.id.tev_register:
                initRegister();
                break;
        }
    }
}
