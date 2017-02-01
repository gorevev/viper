package com.gorevev.testapplication.presentation.common;

/**
 * Created by Ginko on 08.12.2016.
 */

public interface IBasePresenter<View, Router> {

    void onStart();

    void onStop();

    void setView(View view);

    View getView();

    void setRouter(Router router);

    Router getRouter();
}
