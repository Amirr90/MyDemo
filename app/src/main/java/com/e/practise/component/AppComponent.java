package com.e.practise.component;

import com.e.practise.builderModule.ActivityBuilderModule;
import com.e.practise.di.AppModule;
import com.e.practise.util.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;


@Singleton
@Component(modules = {ActivityBuilderModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,}
)

public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(DaggerApplication screen);

        AppComponent build();
    }

}
