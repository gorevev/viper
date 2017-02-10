package com.gorevev.testapplication.presentation._common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.gorevev.testapplication.R;

import java.lang.annotation.Annotation;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    protected NavigatorHolder navigatorHolder;

    @Inject
    protected Router router;

    protected Navigator navigator;

    private Unbinder unbinder;

    protected abstract Navigator createNavigator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class))
            throw new IllegalArgumentException();

        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        setContentView(layout.value());

        unbinder = ButterKnife.bind(this);

        navigator = createNavigator();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content);

        if (fragment == null ||
                !(fragment instanceof IBackButtonListener)
                || !((IBackButtonListener) fragment).onBackPressed()) {
                    super.onBackPressed();
                }
    }
}
