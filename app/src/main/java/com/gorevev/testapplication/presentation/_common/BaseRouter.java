package com.gorevev.testapplication.presentation._common;

import com.gorevev.testapplication.presentation.authentiacation.AuthTransitions;

import lombok.Getter;
import ru.terrakok.cicerone.Router;

/**
 * Created by e.gorev on 09.03.2017.
 */

@Getter
public class BaseRouter implements IBaseRouter {

    Router router;

    public BaseRouter(Router router) {
        this.router = router;
    }

    @Override
    public void back() {
        router.exit();
    }

    @Override
    public void showLogin() {
        router.navigateTo(AuthTransitions.LOGIN);
        //router.showSystemMessage("show login screen");
    }
}
