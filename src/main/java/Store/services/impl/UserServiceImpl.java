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
    public void upgradeUser(User user) {
        this.userDAO.upgradeUser(user);

    }
    @Override
    public User updateUserDB(User user) {
        User userFromDB = userDAO.getUserByLogin(user.getLogin());
        if(userFromDB.getLogin().equals(user.getLogin())){
            userFromDB.setName(user.getName());
            userFromDB.setSurname(user.getSurname());
            return userFromDB;
        }

        return null;
    }
    @Override
    public User updateUserPass(User user) {
        User userFromDB = userDAO.getUserByLogin(user.getLogin());
        if(userFromDB.getLogin().equals(user.getLogin())) {
            userFromDB.setPassword(DigestUtils.md5Hex(user.getPassword()));
            return  userFromDB;
        }

        return null;
    }

}
