package com.gorevev.testapplication.presentation.authentiacation;

import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.IBasePresenter;
import com.gorevev.testapplication.presentation.common.Layout;
import com.gorevev.testapplication.infrastructure.App;

import javax.inject.Inject;

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
        return App.getInstance().getAuthenticationComponent(this).loginPresenter();
    }

    @Override
    protected void inject() {
        App.getInstance().getAuthenticationComponent(this);
    }

    @Override
    public void loggedIn() {
        Toast.makeText(getActivity(), "Logged in", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void loggedOut() {
        Toast.makeText(getActivity(), "Logged out", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_login)
    public void onLogin() {
        presenter.login(login.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.button_logout)
    public void onLogout() {
        presenter.logout();
    }
}
