package com.gorevev.testapplication.presentation.authentiacation.confirm_sms;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseDialogFragment;
import com.gorevev.testapplication.presentation._common.Layout;

import butterknife.BindView;
import butterknife.OnClick;

@Layout(R.layout.fragment_confirm_smsdialog)
public class ConfirmSMSDialogFragment extends BaseDialogFragment implements IConfirmSMSView {

    @BindView(R.id.ev_confirm_dialog_confirmation_code)
    TextInputEditText evConfirmationCode;

    @BindView(R.id.btn_confirm_dialog_send)
    AppCompatButton btnSend;

    @BindView(R.id.btn_confirm_dialog_resend)
    AppCompatButton btnResend;

    @BindView(R.id.tv_confirm_dialog_resend_info)
    TextView tvResendInfo;

    @InjectPresenter
    ConfirmSMSPresenter presenter;

    @ProvidePresenter
    ConfirmSMSPresenter provideConfirmSMSPresenter() {
        return App.getInstance().getAuthenticationComponent().confirmSMSPresenter();
    }

    public static ConfirmSMSDialogFragment newInstance() {
        return new ConfirmSMSDialogFragment();
    }

    @OnClick(R.id.btn_confirm_dialog_send)
    public void onSendClick() {
        presenter.confirmCode(evConfirmationCode.getText().toString());
    }

    @OnClick(R.id.btn_confirm_dialog_resend)
    public void onResendClick() {
        presenter.resendConfirmCode();
    }

    @Override
    public void showSnackbar(Throwable throwable) {
        Snackbar.make(getView(), throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showSnackbar(@StringRes int id) {
        Snackbar.make(getView(), getString(id), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showRemainingTime(int seconds) {
        btnResend.setVisibility(View.GONE);
        tvResendInfo.setVisibility(View.VISIBLE);
        tvResendInfo.setText(getString(R.string.confirm_sms_resend_timer, seconds));
    }

    @Override
    public void showResendButton() {
        btnResend.setVisibility(View.VISIBLE);
        tvResendInfo.setVisibility(View.GONE);
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
