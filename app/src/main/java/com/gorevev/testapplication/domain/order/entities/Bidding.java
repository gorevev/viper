package com.gorevev.testapplication.domain.order.entities;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.Getter;

@Getter
public class Bidding {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TYPE_ALL, TYPE_AUCTION, TYPE_EXPRESS})
    public @interface BiddingType {}

    public static final int TYPE_ALL = 0;
    public static final int TYPE_AUCTION = 1;
    public static final int TYPE_EXPRESS = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATUS_WAITING_START, STATUS_WAITING_BID, STATUS_ENDED})
    public @interface ActualStatus {}

    public static final int STATUS_WAITING_START = 14;
    public static final int STATUS_WAITING_BID = 16;
    public static final int STATUS_ENDED = 20;

    private int id;
    private int clientId;
    private int statusId;
    private String name;
    private @BiddingType int biddingTypeId;
    private int orderTypeId;
    private int accessTypeId;
    private String publishDate;
    private String startDate;
    private String endDate;
    private String actualEndDate;
    private boolean isMedDoc;
    private String comment;
    private @ActualStatus int actualStatus;

    public @BiddingType int getBiddingTypeId() {
        return biddingTypeId;
    }
}
