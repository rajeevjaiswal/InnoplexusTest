package com.rajeevjaiswal.innoplexustest.network;



import com.rajeevjaiswal.innoplexustest.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rajeev on 14/1/18.
 */

public interface RestAPI {

    @GET("users")
    Call<List<Contact>> getContacts();


}