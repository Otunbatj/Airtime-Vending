package com.software.tosino.etranzact.auth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.tosino.etranzact.R;
import com.software.tosino.etranzact.navigate.OnFragmentNavigationRequestListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private OnFragmentNavigationRequestListener mCallback;

    @BindView(R.id.img_header)
    ImageView imgHeader;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.text_forgot_password)
    TextView textForgotPassword;
    Unbinder unbinder;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logon, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.button_login, R.id.text_forgot_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_login:

                break;
            case R.id.text_forgot_password:

                break;
        }
    }

    public void setOnFragmentNavigationRequestListener(LoginActivity loginActivity) {
        this.mCallback = (OnFragmentNavigationRequestListener) loginActivity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCallback = null;
    }
}
