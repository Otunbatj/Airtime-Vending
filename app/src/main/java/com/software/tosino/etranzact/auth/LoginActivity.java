package com.software.tosino.etranzact.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.threeline.accion.agencybanking.R;
import com.threeline.accion.agencybanking.dialogs.PasswordResetSuccess;
import com.threeline.accion.agencybanking.navigate.OnFragmentNavigationRequestListener;
import com.threeline.accion.agencybanking.validation.OTPValidation;

public class LoginActivity extends AppCompatActivity implements OnFragmentNavigationRequestListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState != null) {
            getSupportFragmentManager().executePendingTransactions();
            Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);


            if (fragmentById != null) {
                getSupportFragmentManager().beginTransaction().remove(fragmentById).commit();
            }
        }
        LoginFragment loginFragment = LoginFragment.newInstance();
        navigateFragment(loginFragment, null);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof ForgotPassword) {
            ForgotPassword forgotPassword = (ForgotPassword) fragment;
            forgotPassword.setOnFragmentNavigationRequestListener(this);
        } else if (fragment instanceof LoginFragment) {
            LoginFragment loginFragment = (LoginFragment) fragment;
            loginFragment.setOnFragmentNavigationRequestListener(this);
        } else if (fragment instanceof OTPValidation) {
            OTPValidation otpValidation = (OTPValidation) fragment;
            otpValidation.setOnFragmentNavigationRequestListener(this);
        } else if (fragment instanceof ResetPassword) {
            ResetPassword resetPassword = (ResetPassword) fragment;
            resetPassword.setOnFragmentNavigationRequestListener(this);
        } else if (fragment instanceof PasswordResetSuccess) {
            PasswordResetSuccess passwordResetSuccess = (PasswordResetSuccess) fragment;
            passwordResetSuccess.setOnFragmentNavigationRequestListener(this);
        }
    }

    @Override
    public void navigateFragment(Fragment newFragment, Object object) {
        Bundle args;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (object != null) {
            args = (Bundle) object;
            newFragment.setArguments(args);
        }
        fragmentTransaction
                .replace(R.id.fragment_container, newFragment);
        fragmentTransaction.setCustomAnimations(R.anim.left_in, R.anim.right_out);
        fragmentTransaction.commit();
    }

    @Override
    public void showDialogFragment(Fragment fragment, Fragment targetFragment, int requestCode) {
        FragmentManager fm = getSupportFragmentManager();

        if(fragment instanceof PasswordResetSuccess){
            PasswordResetSuccess passwordResetSuccess = PasswordResetSuccess.newInstance();
            // SETS the target fragment for use later when sending results
            passwordResetSuccess.setTargetFragment(targetFragment, requestCode);
            passwordResetSuccess.show(fm, getString(R.string.pword_reset));
        }
    }

    @Override
    public void navigateActivity(Intent intent, boolean clearTask) {
        if (clearTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
        }
        startActivity(intent);
    }
}
