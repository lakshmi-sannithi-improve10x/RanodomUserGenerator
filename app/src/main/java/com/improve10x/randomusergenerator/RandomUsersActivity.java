package com.improve10x.randomusergenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.improve10x.randomusergenerator.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersActivity extends AppCompatActivity {

        private List<User> users = new ArrayList<>();
        private RandomUsersAdapter adapter;
        RecyclerView randomUserRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_users);
        initviews();
        setupAdapter();
        connectAdapter();
        getUsersApi();
    }

    private void initviews() {
      randomUserRv = findViewById(R.id.random_users_rv);
    }

    private void getUsersApi() {
        RandomUsersServiceApi randomUsersServiceApi = new RandomUsersApi().createRandomUserServiceApi();
        Call<List<User>> call = randomUsersServiceApi.getRandomUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> userList = response.body();
                adapter.setUsers(userList);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(RandomUsersActivity.this, "Failed get Item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        randomUserRv.setLayoutManager(new LinearLayoutManager(this));
        randomUserRv.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new RandomUsersAdapter();
        adapter.setUsers(users);
    }
}