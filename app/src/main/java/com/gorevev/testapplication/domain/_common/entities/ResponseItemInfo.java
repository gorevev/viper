package com.gorevev.testapplication.domain._common.entities;

import java.util.Map;

import lombok.Getter;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Getter
public class ResponseItemInfo {

    private int code;
    private String title;
    private String details;
    private Map<String, String> data;
}
