package com.gorevev.testapplication.presentation.authentiacation.startpage;

import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;

import butterknife.OnClick;

@Layout(R.layout.fragment_start_page)
public class StartPageFragment extends BaseFragment implements IStartPageView {

    public static final String TAG = StartPageFragment.class.getSimpleName();

    @InjectPresenter
    StartPagePresenter presenter;

    @ProvidePresenter
    public StartPagePresenter createStartPresenter() {
        return App.getInstance().getAuthenticationComponent().startPagePresenter();
    }

    public static StartPageFragment newInstance() {
        return new StartPageFragment();
    }


    @OnClick(R.id.button_register)
    void onRegisterButtonClick(View view) {
        presenter.showRegistration();
    }

    @OnClick(R.id.button_login)
    void onSignInButtonClick(View view) {
        presenter.showLogin();
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
