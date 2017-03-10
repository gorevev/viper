package com.gorevev.testapplication.presentation.authentiacation.login;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;
import com.gorevev.testapplication.infrastructure.App;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by e.gorev on 30.01.2017.
 */

@Layout(R.layout.fragment_login)
public class LoginFragment extends BaseFragment implements ILoginView {

    @BindView(R.id.login)
    EditText login;

    @BindView(R.id.password)
    EditText password;

    @InjectPresenter
    LoginPresenter presenter;

    @ProvidePresenter
    LoginPresenter providePresenter() {
        LoginPresenter presenter =  App.getInstance().getAuthenticationComponent().loginPresenter();
        return presenter;
    }

    @BindView(R.id.progress)
    LinearLayout progress;

    @BindView(R.id.button_login)
    Button buttonLogin;

    @BindView(R.id.button_registration)
    Button buttonRegistration;

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void showProgress() {
        buttonLogin.setVisibility(View.GONE);
        buttonRegistration.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        buttonLogin.setVisibility(View.VISIBLE);
        buttonRegistration.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    @Override
    public void loggedIn() {
        Toast.makeText(getActivity(), "Logged in", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_login)
    public void onLogin() {
        hideKeyboard();
        presenter.login(login.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.button_registration)
    public void onRegistration() {
        presenter.showRegistration();
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
