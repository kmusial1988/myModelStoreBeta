package Store.DAO;

import Store.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);

    void addUser(User user);
    
}
