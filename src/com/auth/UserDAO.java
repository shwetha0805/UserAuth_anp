package com.auth;


import java.util.List;

public interface UserDAO {
    void register(User user);
    User login(String username, String password);
    List<User> getAllUsers();
    void deleteUser(int id);
}
