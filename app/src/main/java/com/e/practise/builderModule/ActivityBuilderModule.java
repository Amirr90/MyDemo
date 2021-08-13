package com.e.practise.builderModule;

import com.e.practise.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {MainFragmentBuilderModule.class, MainViewModelModules.class})
    abstract MainActivity activity();
}

