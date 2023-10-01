package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.utils.JdbcUtils;

import java.sql.*;
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

    private static final String SELECT_ALL_AUTHORS_QUERY = "SELECT * FROM Account WHERE id <> ?";

    @Override
    public List<AuthorDto> selectAllExceptMe(int id) {
        List<AuthorDto> allAuthorDto = new ArrayList<>();
        try(Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idAuthor = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(5));
                String bio = resultSet.getString(6);
                LocalDate registrationDate = resultSet.getDate(7).toLocalDate();
                AuthorDto authorDto = new AuthorDto(idAuthor,username,email,base64,bio,registrationDate);
                allAuthorDto.add(authorDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAuthorDto;
    }

    @Override
    public List<AuthorDto> saveFollowing(int idFollowing, int idFollower) {

        return null;
    }
}
