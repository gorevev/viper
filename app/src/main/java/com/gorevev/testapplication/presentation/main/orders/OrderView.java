package com.gorevev.testapplication.presentation.main.orders;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.order.entities.Bidding;
import com.gorevev.testapplication.domain.order.entities.Order;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderView extends FrameLayout {

    public static final String TEMPLATE_DIRECTION = "%s - %s";

    @BindView(R.id.order_item)
    protected View orderItemView;

    @BindView(R.id.direction)
    protected TextView directionView;

    @BindView(R.id.auto_type)
    protected TextView autoTypeView;

    @BindView(R.id.sale_status)
    protected TextView saleStatusView;

    @BindView(R.id.price)
    protected TextView priceView;

    @BindView(R.id.favorite_icon)
    protected ImageButton favoriteIconView;

    @BindView(R.id.type)
    protected TextView typeView;

    @BindView(R.id.win_notification_icon)
    protected View winNotificationIcon;

    @BindView(R.id.make_bid)
    protected AppCompatButton makeBid;

    @BindView(R.id.clock_image)
    protected ImageView clockImageView;

    private Order order;

    public OrderView(Context context) {
        this(context, null);
    }

    public OrderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_order, this);
        ButterKnife.bind(this);
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        orderItemView.setOnClickListener(listener);
    }

    public void setOrder(Order order) {
        this.order = order;
        bindOrder();
    }

    private void bindOrder() {
        if (order != null) {
            directionView.setText(
                    String.format(TEMPLATE_DIRECTION,
                    order.getDeparturePoint().getLocalityName(),
                    order.getDestinationPoint().getLocalityName()));

            typeView.setText(getTypeString(order.getBidding().getBiddingTypeId()));
            saleStatusView.setText(getStatusString());
            favoriteIconView.setSelected(order.isFavorite());
            priceView.setText(order.getCost());

            makeBid.setEnabled(order.canMakeBid());
            makeBid.setText(getActionButtonNameByStatus());

            makeBid.setVisibility(order.canMakeBid() ? GONE : VISIBLE);

            winNotificationIcon.setVisibility(order.isWonByMe() ? VISIBLE : GONE);
        }
    }

    private String getStatusString() {
        return (order.getBidding().getActualStatus() == Bidding.STATUS_ENDED
                ? "end date stub"
                : "delivery time stub")
                + " " + getStatusText();
    }

    private String getStatusText() {
        int stringResId = R.string.order_list_waiting_start;

        switch (order.getBidding().getActualStatus()) {
            case Bidding.STATUS_WAITING_START:
                stringResId = R.string.order_list_waiting_start;
                break;
            case Bidding.STATUS_WAITING_BID:
                stringResId = R.string.order_list_waiting_bid;
                break;
            case Bidding.STATUS_ENDED:
                stringResId = order.isWonByMe() ? R.string.order_list_won : R.string.order_list_ended;
                break;
        }

        return getContext().getString(stringResId);
    }

    private int getActionButtonNameByStatus() {
        if(order.isAuction()) {
            return order.getLastClientBid() == null
                    ? R.string.order_list_action_auction_bid
                    : R.string.order_list_action_auction_your_bid;
        } else if(order.getLastClientBid() != null) {
            return R.string.order_list_action_express_bid_mine;
        } else {
            return R.string.order_list_action_express_bid;
        }
    }

    private int getTypeString(@Bidding.BiddingType int biddingTypeId) {
        switch (biddingTypeId) {
            case Bidding.TYPE_AUCTION:
                return R.string.order_view_auction;
            case Bidding.TYPE_EXPRESS:
                return R.string.order_view_express;
            default:
                return R.string.order_view_auction;
        }
    }
}
