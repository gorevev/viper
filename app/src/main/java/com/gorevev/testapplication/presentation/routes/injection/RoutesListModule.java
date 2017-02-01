package com.gorevev.testapplication.presentation.routes.injection;

import com.gorevev.testapplication.presentation.common.BaseFragment;
import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.routes.IRoutesListPresenter;
import com.gorevev.testapplication.presentation.routes.IRoutesListRouter;
import com.gorevev.testapplication.presentation.routes.RoutesListPresenter;
import com.gorevev.testapplication.presentation.routes.RoutesListRouter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Module
public class RoutesListModule {

    BaseFragment fragment;

    public RoutesListModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ScreenScope
    public IRoutesListRouter providesRouter() {
        return new RoutesListRouter();
    }

    @Provides
    @ScreenScope
    public IRoutesListPresenter providesPresenter(IRoutesListRouter router) {
        return new RoutesListPresenter();
    }
}
