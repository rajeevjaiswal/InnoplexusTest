package com.rajeevjaiswal.innoplexustest;

import android.app.Application;

import com.rajeevjaiswal.innoplexustest.dagger.component.DaggerNetComponent;
import com.rajeevjaiswal.innoplexustest.dagger.component.NetComponent;
import com.rajeevjaiswal.innoplexustest.dagger.module.AppModule;
import com.rajeevjaiswal.innoplexustest.dagger.module.NetModule;


/**
 * Created by rajeev on 14/1/18.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;

//    String API_ENDPOINT = "http://172.104.54.149/supreme_furniture/SupremeFurnitureApi/v1/";
    public String API_ENDPOINT = "http://jsonplaceholder.typicode.com/";
    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger%COMPONENT_NAME%
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(API_ENDPOINT))
                .build();



        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();
    }


        //....


    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
