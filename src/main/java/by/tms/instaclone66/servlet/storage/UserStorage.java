package by.tms.instaclone66.servlet.storage;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.service.UserService;

public interface UserStorage {
    void save(User user);
}
