package com.gorevev.testapplication.domain._common.entities;

import java.util.Iterator;

/**
 * Created by denischuvasov on 20.02.17.
 */

public class ErrorResponse extends Response<Void> {

    public String getMessage() {

        if(getErrors() != null && !getErrors().isEmpty()) {
            StringBuffer buffer = new StringBuffer();

            Iterator<ResponseItemInfo> iterator = getErrors().iterator();
            if(iterator.hasNext()) {
                buffer.append(iterator.next());

                while (iterator.hasNext()) {
                    buffer.append(", ").append(iterator.next());
                }
            }

            return buffer.toString();
        }

        return "";
    }
}
