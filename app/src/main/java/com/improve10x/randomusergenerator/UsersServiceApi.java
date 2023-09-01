package com.improve10x.randomusergenerator;

import com.improve10x.randomusergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsersServiceApi {

    @GET("venusTemplates")
    Call<List<User>> getUsers();

    @POST("venusTemplates")
    Call<User> saveUser(@Body User user);

    @DELETE("venusTemplates/{id}")
    Call<Void>  deleteUser(@Path("id") String id);
}
