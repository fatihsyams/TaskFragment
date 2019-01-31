package com.example.taskfragment.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.taskfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    FragmentManager fm;

    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.password)
    TextInputEditText password;
    @BindView(R.id.ln_satu)
    LinearLayout lnSatu;
    @BindView(R.id.ln_dua)
    LinearLayout lnDua;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_daftar)
    Button btnDaftar;
    @BindView(R.id.relative_container)
    RelativeLayout relativeContainer;
    Unbinder unbinder;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        fm = getActivity().getSupportFragmentManager();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_login, R.id.btn_daftar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:


                if (email.getText().toString().trim().length() == 0) {
                    email.setError("Jangan Kosong !");
                } else if (password.getText().toString().trim().length() == 0) {
                    password.setError("Jangan Kosong");
                } else if (password.getText().length() <= 8) {
                    password.setError("Jangan Lebih dari 8 Karakter");
                }


                break;
            case R.id.btn_daftar:
                    fm.beginTransaction()
                            .add(R.id.relative_container, new SignupFragment())
                            .addToBackStack("yoo")
                            .hide(LoginFragment.this)
                            .commit();

                break;
        }

    }
}
