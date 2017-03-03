package com.gorevev.testapplication.presentation._common;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.gorevev.testapplication.presentation._common.resolution.IThrowableResolver;
import com.gorevev.testapplication.presentation._common.resolution.ThrowableResolver;
import com.gorevev.testapplication.utils.Logger;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends MvpAppCompatFragment implements IBackButtonListener {

    protected Unbinder unbinder;

    private IThrowableResolver resolver = new ThrowableResolver();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.d(name(), "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");

        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class))
            return null;

        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        View view = inflater.inflate(layout.value(), null);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Logger.d(name(), "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Logger.d(name(), "onDestroyView() called");

        if(unbinder != null)
            unbinder.unbind();

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(name(), "onDestroy() called");
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    protected String name() {
        return getClass().getSimpleName();
    }

    public IThrowableResolver getThrowableResolver() {
        return resolver;
    }

    public void showSnackbar(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG);
    }
}
