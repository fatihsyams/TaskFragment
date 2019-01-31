package com.example.taskfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.taskfragment.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm= getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.relative_container, new LoginFragment())
                .commit();
    }
}
