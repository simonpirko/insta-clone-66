package by.tms.instaclone66.servlet.storage;

import by.tms.instaclone66.servlet.entity.User;

import java.sql.SQLException;


public interface UserStorage {
    void save(User user) throws ClassNotFoundException, SQLException;

}
