package Store.DAO;

import Store.model.User;

import java.util.List;

public interface IUserDAO {
    User getUserByLogin(String login);

    void addUser(User user);
    void upgradeUser(User user);
    List<User> listUserDB(String login);


    User updateUserPass(User user);

}
