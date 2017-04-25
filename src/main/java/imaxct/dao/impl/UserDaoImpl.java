package imaxct.dao.impl;

import imaxct.dao.IUserDao;
import imaxct.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by imaxct on 17-4-6.
 */

@Repository
public class UserDaoImpl extends BaseDao<User> implements IUserDao {

    public boolean createUser(User user) {
        return this.create(user);
    }

    public User getUserById(int id) {
        return this.find(User.class, id);
    }

    public User getUserByStuNo(String stuNo) {
        return this.uniqueResult("from User where stuNo = ?", stuNo);
    }

    public List<User> getAllUsers() {
        return this.listPage(0, 500, "from User");
    }
}
