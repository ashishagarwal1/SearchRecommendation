package com.agarwal.ashish.search;

import com.facebook.stetho.Stetho;

public class SearchDbAccessApplication extends SearchApplication {

    public static final String TAG = "QnaCustomDevApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
