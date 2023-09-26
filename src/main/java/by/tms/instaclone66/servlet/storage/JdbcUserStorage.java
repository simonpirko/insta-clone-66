package by.tms.instaclone66.servlet.storage;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.service.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class JdbcUserStorage implements UserStorage {
    private static JdbcUserStorage instance;
    private JdbcUserStorage(){}

    public static JdbcUserStorage getInstance(){
        if(instance == null){
            instance = new JdbcUserStorage();
        }
        return instance;
    }
    private static final String INSERT_QUERY;
    private static final String SELECT_EMAIL_QUERY;

    static {
        SELECT_EMAIL_QUERY = "SELECT * FROM Users WHERE email = ?";
        INSERT_QUERY = "INSERT INTO Users(userName,email,password) VALUES (?,?,?)";
    }

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

    @Override
    public Optional<User> findByEmail(String email) {
        User user = new User();
        try (Connection connection = SqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMAIL_QUERY);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String newEmail = resultSet.getString("email");
                String password = resultSet.getString("password");
               user.setUserName(userName);
               user.setEmail(newEmail);
               user.setPassword(password);
            }
            if (user.getEmail() != null) {
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
