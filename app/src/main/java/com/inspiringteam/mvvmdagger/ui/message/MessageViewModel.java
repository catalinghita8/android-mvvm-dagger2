package com.inspiringteam.mvvmdagger.ui.message;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.inspiringteam.mvvmdagger.data.MessageRepository;
import com.inspiringteam.mvvmdagger.di.scopes.AppScoped;

import javax.inject.Inject;

@AppScoped
public class MessageViewModel extends ViewModel{
    @NonNull
    private final MessageRepository mRepository;

    @Inject
    public MessageViewModel(@NonNull MessageRepository mRepository) {
        this.mRepository = mRepository;
    }

    @NonNull
    public MessageUiModel getUiModel(){
        return new MessageUiModel(mRepository.getData());
    }
}
