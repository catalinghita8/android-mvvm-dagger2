package com.inspiringteam.mvvmdagger.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.inspiringteam.mvvmdagger.di.message.MessageViewModelFactory;
import com.inspiringteam.mvvmdagger.di.scopes.AppScoped;
import com.inspiringteam.mvvmdagger.ui.message.MessageViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MessageViewModel.class)
    abstract ViewModel bindMessageViewModel(MessageViewModel messageViewModel);

    @Binds
    @AppScoped
    abstract ViewModelProvider.Factory bindViewModelFactory(MessageViewModelFactory factory);
}
