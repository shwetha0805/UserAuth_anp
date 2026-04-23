package dao;

import java.util.List;
import model.User;

public interface UserDao {
    boolean register(User user);
    User login(String username, String password);

    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(String username);
}