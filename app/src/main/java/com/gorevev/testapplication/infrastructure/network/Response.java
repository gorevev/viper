package com.gorevev.testapplication.infrastructure.network;

import java.util.List;

/**
 * Created by e.gorev on 01.02.2017.
 */

public class Response<DataType> {

    private List<ResponseItemInfo> errors;
    private List<ResponseItemInfo> notice;

    private DataType data;

    public List<ResponseItemInfo> getErrors() {
        return errors;
    }

    public void setErrors(List<ResponseItemInfo> errors) {
        this.errors = errors;
    }

    public List<ResponseItemInfo> getNotice() {
        return notice;
    }

    public void setNotice(List<ResponseItemInfo> notice) {
        this.notice = notice;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }
}
