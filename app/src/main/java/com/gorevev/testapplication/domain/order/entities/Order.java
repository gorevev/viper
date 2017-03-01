package com.gorevev.testapplication.domain.order.entities;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.Locale;

import lombok.Data;

/**
 * Created by e.gorev on 01.02.2017.
 */

@Data
public class Order {

    public static final String DEFAULT_VALUE = "---";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({PAYMENT_CASH, PAYMENT_CASHLESS})
    public @interface CashType {
    }

    public static final int PAYMENT_CASH = 1;
    public static final int PAYMENT_CASHLESS = 2;

    private boolean empty;

    private int id;
    private int biddingId;
    private int statusId;
    private @CashType int paymentTypeId;
    private int serialNumber;
    private boolean withVAT;
    private String loadingTime;
    private String unloadingTime;
    private int truckTypeId;
    private int cargoTypeId;
    private double cargoWeight;
    private int cubicCapacityValue;
    private int loadingTypeId;
    private String comment;
    private Integer externalId;
    private int bidsCount;
    private boolean isFavorite;
    private Bidding bidding;
    private Point departurePoint;
    private Point destinationPoint;
    private Bid betterBid;
    private Bid lastClientBid;
    private Auction auction;
    private ExpressTender expressTender;
    private boolean isWinnerChosen;
    private boolean isWonByMe;

    public @CashType int getPaymentTypeId() {
        return paymentTypeId;
    }

    public boolean isAuction() {
        return bidding != null && bidding.getBiddingTypeId() == Bidding.TYPE_AUCTION;
    }

    public boolean isExpress() {
        return bidding != null && bidding.getBiddingTypeId() == Bidding.TYPE_EXPRESS;
    }

    public String getOrderNumberString() {
        return String.format("%03d/%03d", biddingId, serialNumber);
    }

    public int getCostValue() {
        if (betterBid != null) {
            return betterBid.getBidValue();
        } else if (auction != null) {
            return (int) auction.getOpeningBid();
        } else if (expressTender != null) {
            return (int) expressTender.getCost();
        }
        return -1;
    }

    public String getCost() {
        int costValue = getCostValue();
        if (costValue >= 0) {
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));
            return format.format(costValue);
        }
        return DEFAULT_VALUE;
    }

    public boolean isCurrentBidMine() {
        return lastClientBid != null && betterBid != null && lastClientBid.getId() == betterBid.getId();
    }

    public boolean canMakeBid() {
        return isWonByMe() || getBidding().getActualStatus() == Bidding.STATUS_ENDED;
    }
}
