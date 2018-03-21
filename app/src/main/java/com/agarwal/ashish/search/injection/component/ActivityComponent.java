package com.agarwal.ashish.search.injection.component;

import dagger.Subcomponent;
import com.agarwal.ashish.search.injection.PerActivity;
import com.agarwal.ashish.search.injection.module.ActivityModule;
import com.agarwal.ashish.search.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
