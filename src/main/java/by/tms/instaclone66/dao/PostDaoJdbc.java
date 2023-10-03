package by.tms.instaclone66.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.tms.instaclone66.utils.JdbcUtils.getConnection;

public class PostDaoJdbc implements PostDao {
    private static PostDaoJdbc instance;

    private PostDaoJdbc() {

    }

    public static PostDaoJdbc getInstance() {
        if (instance == null) {
            instance = new PostDaoJdbc();
        }
        return instance;
    }


    private static final String DELETE_POST_QUERY = "delete from Post where id = ?;";

    public void deletePost(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_POST_QUERY);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

