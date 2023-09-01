package com.improve10x.randomusergenerator;

import com.improve10x.randomusergenerator.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUsersServiceApi {

    @GET("api/person/10")
    Call<List<User>>  getRandomUsers();
}
