package com.gorevev.testapplication.presentation._common.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Ginko on 07.12.2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScreenScope {
}
