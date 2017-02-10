package com.gorevev.testapplication.presentation.splash;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;
import com.gorevev.testapplication.infrastructure.App;

/**
 * Created by Ginko on 04.12.2016.
 */

@Layout(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment implements ISplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @ProvidePresenter
    SplashPresenter providePresenter() {
        return App.getInstance().getSplashComponent().splashPresenter();
    }

    public static Fragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public void finishInitialization() {
        Toast.makeText(getActivity(), "finish initialization", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
