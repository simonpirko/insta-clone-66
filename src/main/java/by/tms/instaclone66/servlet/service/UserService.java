package by.tms.instaclone66.servlet.service;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.storage.JdbcUserStorage;

import java.sql.SQLException;
import java.util.Optional;

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

    private final JdbcUserStorage jdbcUserStorage = JdbcUserStorage.getInstance();

    public void create(String userName, String email, String password) {
        User user = new User(userName, email, password);
        jdbcUserStorage.save(user);
    }

    public Optional<User> getByEmail(String email) {
        return jdbcUserStorage.findByEmail(email);
    }
}
