package imaxct.service;

import imaxct.domain.User;

/**
 * Created by imaxct on 17-4-6.
 */
public interface IUserService {
    boolean register(String username, String password);
    User login(String username, String password);
}
