package com.improve10x.randomusergenerator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.randomusergenerator.model.Address;
import com.improve10x.randomusergenerator.model.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public  void  getRandomUsers() throws IOException {
        RandomUsersServiceApi randomUsersServiceApi = new RandomUsersApi().createRandomUserServiceApi();
        Call<List<User>> call = randomUsersServiceApi.getRandomUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public void getUsers() throws IOException {
        UsersServiceApi usersServiceApi = new UsersApi().createUserApi();
        Call<List<User>> call = usersServiceApi.getUsers();
        List<User> users = call.execute().body();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(new Gson().toJson(users));
    }

    @Test
    public  void saveUser() throws IOException {
        UsersServiceApi usersServiceApi = new UsersApi().createUserApi();
        Address address = new Address("basireddy bavi Street", "Kurnool", "Andhrapradesh", "India",
                "5161", 56789, "9526341521", "433.2", "IND");
        User user = new User("Sai", 20, "developer", 567, 57, "1234-3452",
                false, false, 156, 5.6f, "black", "sai@improve10x.com", "female", true, "B+",
                "sri", 0.02f, "Hindu", address, "1995", 1.0f);
        Call<User> call = usersServiceApi.saveUser(user);
        User randomUser = call.execute().body();
        assertNotNull(randomUser);
        System.out.println(new Gson().toJson(randomUser));
    }

    @Test
    public  void deleteUser() throws IOException {
      UsersServiceApi usersServiceApi = new UsersApi().createUserApi();
        Call<Void>  call = usersServiceApi.deleteUser("648c3c94c632b703e83049d5");
        call.execute();
    }
}