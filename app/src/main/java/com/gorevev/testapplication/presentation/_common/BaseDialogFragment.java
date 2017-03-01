package com.gorevev.testapplication.presentation._common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gorevev.testapplication.utils.Logger;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by denischuvasov on 14.02.17.
 */

public class BaseDialogFragment extends MvpDialogFragment implements IBackButtonListener {

    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
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
}
