package com.rajeevjaiswal.innoplexustest.dagger.component;

import android.app.Application;


import com.rajeevjaiswal.innoplexustest.main.MainActivity;
import com.rajeevjaiswal.innoplexustest.dagger.module.AppModule;
import com.rajeevjaiswal.innoplexustest.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rajeev on 14/1/18.
 */


  @Singleton
  @Component(modules={AppModule.class, NetModule.class})
  public interface NetComponent {
       void inject(MainActivity activity);


    Application getApplication();


  }

