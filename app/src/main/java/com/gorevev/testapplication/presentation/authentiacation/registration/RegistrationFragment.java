package com.gorevev.testapplication.presentation.authentiacation.registration;

import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gorevev.testapplication.R;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.infrastructure.App;
import com.gorevev.testapplication.presentation._common.BaseFragment;
import com.gorevev.testapplication.presentation._common.Layout;
import com.gorevev.testapplication.presentation.authentiacation.confirm_sms.ConfirmSMSDialogFragment;

import butterknife.BindView;
import butterknife.OnClick;


@Layout(R.layout.fragment_registration)
public class RegistrationFragment extends BaseFragment implements IRegistrationView {

    @BindView(R.id.surname)
    EditText etSurname;

    @BindView(R.id.name)
    EditText etName;

    @BindView(R.id.phone)
    EditText etPhone;

    @BindView(R.id.email)
    EditText etEmail;

    @BindView(R.id.password)
    EditText etPassword;

    @BindView(R.id.individual_entrepreneur)
    RadioButton rbIndividualEntrepreneur;

    @BindView(R.id.button_registration)
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

    @OnClick(R.id.button_registration)
    void onRegistrationClick() {

        RegUserParams params = RegUserParams.builder()
                .firstName(etName.getText().toString())
                .lastName(etSurname.getText().toString())
                .phone(etPhone.getText().toString())
                .email(etEmail.getText().toString())
                .password(etPassword.getText().toString())
                .legalStatus(rbIndividualEntrepreneur.isChecked() ? 2 : 3)
                .isCarrier(true)
                .acceptOffer(true)
                .acceptPersonalData(true)
                .build();

        presenter.registration(params);
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
}
