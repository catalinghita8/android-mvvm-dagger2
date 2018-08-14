package com.inspiringteam.mvvmdagger.data;

import android.support.annotation.NonNull;

import com.inspiringteam.mvvmdagger.di.scopes.AppScoped;

import javax.inject.Inject;

// Fake repository
@AppScoped
public class MessageRepository {
    @Inject
    public MessageRepository() {
    }

    @NonNull
    public String getData(){
        return "Hello Medium!";
    }
}
