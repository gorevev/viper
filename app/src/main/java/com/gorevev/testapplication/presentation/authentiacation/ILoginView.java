package com.gorevev.testapplication.presentation.authentiacation;

/**
 * Created by e.gorev on 30.01.2017.
 */

public interface ILoginView {

    void loggedIn();

    void loggedOut();

    void showError(String message);
}
