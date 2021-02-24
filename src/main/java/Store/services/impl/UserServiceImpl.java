package Store.services.impl;

import Store.DAO.IUserDAO;
import Store.model.User;
import Store.services.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public User authenticate(User user) {
        User userFormDataBase = userDAO.getUserByLogin(user.getLogin());

        if (userFormDataBase == null) {
            return null;
        }

        if (DigestUtils.md5Hex(user.getPassword())
                .equals(userFormDataBase.getPassword())) {
            return userFormDataBase;
        } else {
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Override
    public boolean registerUser(User user, String repeatedPassword) {
        if (!user.getPassword().equals(repeatedPassword)) {
            return false;
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
        return true;
    }

    @Override
    public User upgradeUser(User user) {
        this.userDAO.upgradeUser(user);
        return user;
    }


}
