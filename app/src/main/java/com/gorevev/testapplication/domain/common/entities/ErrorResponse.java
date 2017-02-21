package com.gorevev.testapplication.domain.common.entities;

import java.util.Iterator;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class ErrorResponse extends Response<Void> {

    public String getMessage() {
        if(getErrors() != null &&
                !getErrors().isEmpty()) {
            StringBuffer buffer = new StringBuffer();

            Iterator<ResponseItemInfo> it = getErrors().iterator();
            if(it.hasNext()) {
                buffer.append(it.next());
                while (it.hasNext()) {
                    buffer.append(", ")
                            .append(it.next());
                }
            }

            return buffer.toString();
        }
        return "";
    }
}
