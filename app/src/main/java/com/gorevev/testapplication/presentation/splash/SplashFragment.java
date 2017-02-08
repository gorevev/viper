package com.gorevev.testapplication.presentation.splash;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.IBasePresenter;
import com.gorevev.testapplication.presentation.common.Layout;
import com.gorevev.testapplication.infrastructure.App;

import javax.inject.Inject;

/**
 * Created by Ginko on 04.12.2016.
 */

@Layout(R.layout.fragment_splash)
public class SplashFragment extends BaseFragment implements ISplashView {

    @InjectPresenter
    SplashPresenter presenter;

    @ProvidePresenter
    SplashPresenter providePresenter() {
        return App.getInstance().getSplashComponent(this).splashPresenter();
    }

    @Override
    public void finishInitialization() {
        Toast.makeText(getActivity(), "finish initialization", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void inject() {

    }
}
