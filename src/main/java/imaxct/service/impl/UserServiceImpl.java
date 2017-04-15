package imaxct.service.impl;

import imaxct.bean.Msg;
import imaxct.domain.User;
import imaxct.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by imaxct on 17-4-6.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService implements IUserService {

    public Msg register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (this.userDao.getUserByName(username) != null){
            return new Msg("用户已存在");
        }else if (this.userDao.createUser(user)){
            return new Msg(0, "注册成功");
        } else{
            return new Msg("注册失败");
        }
    }

    public Msg<User> login(String username, String password) {
        User user = this.userDao.getUserByName(username);
        if (user == null){
            return new Msg<User>("用户不存在");
        }else if (user.getPassword().equals(password))
            return new Msg<User>(0, "ok", user);
        else return new Msg<User>("密码错误");
    }

    public Msg<List<User>> list() {
        return new Msg<List<User>>(0, "ok", this.userDao.getAllUsers());
    }
}
