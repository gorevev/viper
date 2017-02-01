package com.gorevev.testapplication.presentation.authentiacation;

import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

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

    @Inject
    ILoginPresenter presenter;

    @BindView(R.id.login)
    EditText login;

    @BindView(R.id.password)
    EditText password;

    @NonNull
    @Override
    protected IBasePresenter getPresenter() {
        return presenter;
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
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_login)
    public void onLogin() {
        presenter.login(login.getText().toString(), password.getText().toString());
    }
}
