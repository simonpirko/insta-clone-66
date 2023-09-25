package by.tms.instaclone66.servlet.service;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.storage.JdbcUserStorage;
import by.tms.instaclone66.servlet.storage.UserStorage;

import java.sql.SQLException;

public class UserService {
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    private final JdbcUserStorage jdbcUserStorage =  new JdbcUserStorage();
    public void create (String userName,String email,String password) throws SQLException, ClassNotFoundException {
        User user = new User(userName,email,password);
        jdbcUserStorage.save(user);

    }
}
