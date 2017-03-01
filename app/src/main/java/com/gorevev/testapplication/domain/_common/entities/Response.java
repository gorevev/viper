package com.gorevev.testapplication.domain._common.entities;

import java.util.List;

import lombok.Data;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Data
public class Response<DataType> {

    private List<ResponseItemInfo> errors;
    private List<ResponseItemInfo> notice;

    private DataType data;
}
