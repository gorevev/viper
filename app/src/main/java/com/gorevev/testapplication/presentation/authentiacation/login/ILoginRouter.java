package com.gorevev.testapplication.presentation.authentiacation.login;

import com.gorevev.testapplication.presentation._common.IBaseRouter;

/**
 * Created by denischuvasov on 10.02.17.
 */

public interface ILoginRouter extends IBaseRouter {

    void showRegistration();

    void showPasswordRecovery();

    void showMainScreen();
}
