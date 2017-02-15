package com.gorevev.testapplication.presentation.authentiacation.registration;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.domain.user.entities.RegUserParamsBuilder;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;
import com.gorevev.testapplication.presentation.authentiacation.confirmSms.ConfirmSMSDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@Layout(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment implements IRegistrationView {

    @BindView(R.id.ev_registration_surname)
    EditText etSurname;

    @BindView(R.id.et_registration_name)
    EditText etName;

    @BindView(R.id.et_registration_phone)
    EditText etPhone;

    @BindView(R.id.et_registration_email)
    EditText etEmail;

    @BindView(R.id.et_registration_password)
    EditText etPassword;

    @BindView(R.id.rb_registration_ip)
    RadioButton rbIP;

    @BindView(R.id.rb_registration_jul)
    RadioButton rbUL;

    @BindView(R.id.btn_registration_registration)
    Button btnRegistration;

    @InjectPresenter
    RegistrationPresenter presenter;

    @ProvidePresenter
    RegistrationPresenter providePresenter() {
        return App.getInstance().getAuthenticationComponent().registrationPresenter();
    }


    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @OnClick(R.id.btn_registration_registration)
    void onRegistrationClick() {
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        int status = rbIP.isChecked() ? 2 : 3;

        RegUserParams regUserParams = new RegUserParamsBuilder()
                .setFirstName(name)
                .setLastName(surname)
                .setPhone(phone)
                .setEmail(email)
                .setPassword(password)
                .setLegalStatus(status)
                .setIsCarrier(true)
                .setAcceptOffer(true)
                .setAcceptPersonalData(true)
                .createRegUserParams();
        presenter.registration(regUserParams);
    }


    @Override
    public void showError(Throwable throwable) {
        Snackbar.make(getView(), throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        btnRegistration.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        btnRegistration.setEnabled(true);
    }

    @Override
    public void showConfirmDialog() {
        ConfirmSMSDialogFragment dialogFragment = ConfirmSMSDialogFragment.newInstance();
        dialogFragment.show(getFragmentManager(), "ddd");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
