package com.agarwal.ashish.search.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.agarwal.ashish.search.data.DataManager;
import com.agarwal.ashish.search.data.remote.ApiService;
import com.agarwal.ashish.search.injection.ApplicationContext;
import com.agarwal.ashish.search.injection.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext Context context();
    Application application();
    ApiService apiService();
    DataManager dataManager();

}
