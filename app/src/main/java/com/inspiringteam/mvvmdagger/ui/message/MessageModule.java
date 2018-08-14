package com.inspiringteam.mvvmdagger.ui.message;

import com.inspiringteam.mvvmdagger.di.scopes.FragmentScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MessageModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MessageFragment messageFragment();
}
