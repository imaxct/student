package imaxct.dao;

import imaxct.domain.User;

import java.util.List;

/**
 * Created by imaxct on 17-4-6.
 */
public interface IUserDao {
    boolean createUser(User user);
    User getUserById(int id);
    User getUserByName(String username);
    List<User> getAllUsers();
}
