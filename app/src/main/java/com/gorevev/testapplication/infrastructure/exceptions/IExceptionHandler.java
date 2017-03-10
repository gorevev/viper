package com.gorevev.testapplication.infrastructure.exceptions;

import com.gorevev.testapplication.presentation._common.IBaseRouter;
import com.gorevev.testapplication.presentation._common.IBaseView;

/**
 * Created by e.gorev on 06.03.2017.
 */

public interface IExceptionHandler<View extends IBaseView, Router extends IBaseRouter> {

    boolean handleError(Throwable throwable, View view, Router router);

    String getProcessedErrorKey();
}
