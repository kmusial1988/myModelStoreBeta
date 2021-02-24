package Store.services;

import Store.model.User;

public interface IUserService {
    User authenticate(User user);

    void addUser(User user);

    boolean registerUser (User user, String repeatedPassword);
    User upgradeUser(User user);

}
