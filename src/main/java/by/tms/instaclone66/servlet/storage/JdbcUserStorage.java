package by.tms.instaclone66.servlet.storage;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.service.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JdbcUserStorage implements UserStorage {
    private static final String INSERT_QUERY = "INSERT INTO userName(userName,email,password) VALUES (?,?,?)";

    @Override
    public void save(User user) throws ClassNotFoundException, SQLException {
        try (Connection connection = SqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
