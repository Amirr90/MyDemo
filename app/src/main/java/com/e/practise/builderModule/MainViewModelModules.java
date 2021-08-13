package com.e.practise.builderModule;

import androidx.lifecycle.ViewModel;

import com.e.practise.util.ViewModelKey;
import com.e.practise.viewModel.AppViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModules {
    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel.class)
    public abstract ViewModel bindViewModel(AppViewModel appViewModal);

}