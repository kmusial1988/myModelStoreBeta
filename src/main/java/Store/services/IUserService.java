package Store.services;

import Store.model.User;

public interface IUserService {
    User authenticate(User user);

    void addUser(User user);

    boolean registerUser (User user, String repeatedPassword);
    void upgradeUser(User user);

    User updateUserDB(User user);

    User updateUserPass(User user);
}
