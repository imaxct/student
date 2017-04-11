package imaxct.service.impl;

import imaxct.dao.IUserDao;
import imaxct.domain.User;
import imaxct.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by imaxct on 17-4-6.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public boolean register(String username, String password) {
        return userDao.createUser(username, password);
    }

    public User login(String username, String password) {
        User user = userDao.getUserByName(username);
        if (user.getPassword().equals(password))
            return user;
        return null;
    }
}
