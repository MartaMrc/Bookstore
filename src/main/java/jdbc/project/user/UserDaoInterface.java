package jdbc.project.user;

import hibernate.project.entities.User;

public interface UserDaoInterface {
    void createAccountUser(User user);

    // login user
    void logUs();
}
