package com.gorevev.testapplication.presentation.main;

import com.gorevev.testapplication.presentation._common.IBaseRouter;

/**
 * Created by denischuvasov on 10.02.17.
 */
public interface IMainRouter extends IBaseRouter {

    void showOrders();

    void showFavoritesOrders();

    void showSearchOrders();

    void showAuthentication();
}
