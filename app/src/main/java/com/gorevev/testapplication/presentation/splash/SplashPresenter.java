package com.gorevev.testapplication.presentation.splash;

import com.gorevev.testapplication.presentation.common.BasePresenter;

/**
 * Created by Ginko on 04.12.2016.
 */

public class SplashPresenter extends BasePresenter<ISplashView, ISplashRouter> implements ISplashPresenter {

    public SplashPresenter(ISplashRouter router) {
        this.setRouter(router);
    }

    @Override
    public void onStart() {

        getView().finishInitialization();
        getRouter().openLogin();
        /*String json = "{\n" +
                "  \"legalStatus\": 2,\n" +
                "  \"isCarrier\": true,\n" +
                "  \"lastName\": \"testLast\",\n" +
                "  \"firstName\": \"testFirst\",\n" +
                "  \"secondName\": \"testSecond\",\n" +
                "  \"email\": \"string@mail.ru\",\n" +
                "  \"phone\": \"89132564565\",\n" +
                "  \"timezone\": \"Asia/Novosibirsk\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"acceptPersonalData\": true,\n" +
                "  \"acceptOffer\": true\n" +
                "}";

        RegUserParams params = new Gson().fromJson(json, RegUserParams.class);

        userSession.registerGuest(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> getView().finishInitialization(),
                        throwable -> getView().showError(throwable.getMessage())
                );*/
    }

    @Override
    public void onStop() {

    }
}
