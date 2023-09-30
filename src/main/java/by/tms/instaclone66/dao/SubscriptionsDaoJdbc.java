package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SubscriptionsDaoJdbc implements SubscriptionsDao {

    private static SubscriptionsDaoJdbc instance;

    private SubscriptionsDaoJdbc() {

    }

    public static SubscriptionsDaoJdbc getInstance() {
        if (instance == null) {
            instance = new SubscriptionsDaoJdbc();
        }
        return instance;
    }

    private static final String SELECT_ALL_AUTHORS_QUERY = "SELECT * FROM Account";

    @Override
    public List<AuthorDto> getAllPeoples() {
        List<AuthorDto> allAuthorDto = new ArrayList<>();
        try(Connection connection = JdbcUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_AUTHORS_QUERY);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(5));
                String bio = resultSet.getString(6);
                LocalDate registrationDate = resultSet.getDate(7).toLocalDate();
                AuthorDto authorDto = new AuthorDto(id,username,email,base64,bio,registrationDate);
                allAuthorDto.add(authorDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAuthorDto;
    }

    @Override
    public void saveSubscription() {

    }
}
