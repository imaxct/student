package imaxct.service.impl;

import imaxct.bean.Msg;
import imaxct.domain.User;
import imaxct.service.IUserService;
import imaxct.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by imaxct on 17-4-6.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService implements IUserService {

    public Msg<User> login(String stuNo, String password) {
        User user = this.userDao.getUserByStuNo(stuNo);
        if (user == null){
            return new Msg<User>("用户不存在");
        }else if (user.getIdNo().equals(password))
            return new Msg<User>(0, null, user);
        else {
            Msg<User> msg = Util.verify(stuNo, password);
            if (msg.getCode() == 0){
                User nUser = msg.getObj();
                if (this.userDao.createUser(nUser)){
                    return new Msg<User>(1, null, nUser);
                }else {
                    return new Msg<User>("非首次登录, 请使用身份证号.");
                }
            }else {
                return new Msg<User>("登录失败.");
            }
        }
    }

    public Msg<List<User>> list() {
        return new Msg<List<User>>(0, "ok", this.userDao.getAllUsers());
    }
}
