package imaxct.service;

import imaxct.bean.Msg;
import imaxct.domain.User;

import java.util.List;

/**
 * Created by imaxct on 17-4-6.
 */
public interface IUserService {

    Msg<User> login(String username, String password);

    Msg<List<User>> list();
}
