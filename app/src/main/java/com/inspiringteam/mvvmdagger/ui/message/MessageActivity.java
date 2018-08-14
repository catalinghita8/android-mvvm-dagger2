package com.inspiringteam.mvvmdagger.ui.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inspiringteam.mvvmdagger.R;
import com.inspiringteam.mvvmdagger.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MessageActivity extends DaggerAppCompatActivity {
    @Inject
    MessageFragment mInjectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // Set up fragment
        MessageFragment fragment =
                (MessageFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (fragment == null) {
            fragment = mInjectedFragment;
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.contentFrame);
        }
    }
}
