package com.gorevev.testapplication.infrastructure.exceptions;

import com.gorevev.testapplication.presentation._common.IBaseRouter;
import com.gorevev.testapplication.presentation._common.IBaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e.gorev on 07.03.2017.
 */

public class ErrorResolver {

    HashMap<String, IExceptionHandler> handlers = new HashMap<>();

    public ErrorResolver(IExceptionHandler... handlers) {
        for (IExceptionHandler handler : handlers) {
            this.handlers.put(handler.getProcessedErrorKey(), handler);
        }
    }

    public void putHandler(IExceptionHandler handler) {
        handlers.put(handler.getProcessedErrorKey(), handler);
    }

    public boolean handleError(Throwable throwable, IBaseView view, IBaseRouter router) {

        for (Map.Entry<String, IExceptionHandler> handlerEntry : handlers.entrySet()) {
            if (handlerEntry.getValue().handleError(throwable, view, router))
                return true;
        }

        return false;
    }
}
