package com.gorevev.testapplication.presentation.routes.injection;

import com.gorevev.testapplication.presentation.common.injection.ScreenScope;
import com.gorevev.testapplication.presentation.routes.RoutesListFragment;

import dagger.Subcomponent;

/**
 * Created by e.gorev on 01.02.2017.
 */

@ScreenScope
@Subcomponent(modules = {RoutesListModule.class})
public interface RoutesListComponent {

    void inject(RoutesListFragment fragment);
}
