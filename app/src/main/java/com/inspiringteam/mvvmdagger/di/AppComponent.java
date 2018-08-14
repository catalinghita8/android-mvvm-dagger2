package com.inspiringteam.mvvmdagger.di;

import com.inspiringteam.mvvmdagger.di.scopes.AppScoped;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import com.inspiringteam.mvvmdagger.Application;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScoped
@Component(modules = {
        ViewModelModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<Application> {

    // we can now do DaggerAppComponent.builder().application(this).build().inject(this),
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(android.app.Application application);

        AppComponent build();
    }
}
