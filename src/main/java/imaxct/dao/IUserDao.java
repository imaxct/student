package imaxct.dao;

import imaxct.domain.User;

/**
 * Created by imaxct on 17-4-6.
 */
public interface IUserDao {
    boolean createUser(String username, String password);
    User getUserById(int id);
    User getUserByName(String username);
}
