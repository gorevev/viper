package com.gorevev.testapplication.infrastructure.network;

import java.util.Map;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class ResponseItemInfo {

    private int code;
    private String title;
    private String details;
    private Map<String, String> data;

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Map<String, String> getData() {
        return data;
    }
}
