package com.inspiringteam.mvvmdagger.ui.message;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inspiringteam.mvvmdagger.BaseView;
import com.inspiringteam.mvvmdagger.R;
import com.inspiringteam.mvvmdagger.di.scopes.ActivityScoped;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class MessageFragment extends DaggerFragment implements BaseView {
    private TextView mMessageTextView;

    private MessageViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get ViewModel
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(MessageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_message, container, false);
        mMessageTextView = root.findViewById(R.id.message_tv);

        return root;
    }

    @Override
    public void bindViewModel() {
        updateView(mViewModel.getUiModel());
    }

    private void updateView(MessageUiModel uiModel) {
        mMessageTextView.setText(uiModel.getMessageText());
    }

    @Override
    public void onResume() {
        super.onResume();
        bindViewModel();
    }

    @Override
    public void onPause() {
        super.onPause();
        unbindViewModel();
    }

    @Override
    public void unbindViewModel() {

    }
}
