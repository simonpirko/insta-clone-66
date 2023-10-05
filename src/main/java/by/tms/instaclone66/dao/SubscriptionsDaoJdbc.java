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

    private static final String SELECT_ALL_AUTHORS_QUERY = "SELECT * FROM Account A LEFT JOIN Follower F ON A.id = F.follower_id AND F.following_id = ? WHERE A.id <> ? AND F.follower_id IS NULL";
    private static final String INSERT_FOLLOWING = "INSERT INTO Follower(follower_id,following_id) VALUES (?,?)";
    private static final String SELECT_FOLLOWER = "SELECT A.* FROM Account A INNER JOIN Follower F on A.id = F.follower_id WHERE F.following_id = ?";
    private static final String DELETE_SUBSCRIPTION = "DELETE FROM Follower WHERE following_id = ? AND follower_id = ?";

    @Override
    public List<AuthorDto> selectAllExceptMe(int id) {
        List<AuthorDto> allAuthors = new ArrayList<>();
        try(Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS_QUERY);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idAuthor = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(5));
                String bio = resultSet.getString(6);
                LocalDate registrationDate = resultSet.getDate(7).toLocalDate();
                AuthorDto authorDto = new AuthorDto(idAuthor,username,email,base64,bio,registrationDate);
                allAuthors.add(authorDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAuthors;
    }

    @Override
    public void saveFollowing(int idFollower, int idFollowing) {
        try(Connection connection = JdbcUtils.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOLLOWING);
            preparedStatement.setInt(1,idFollower);
            preparedStatement.setInt(2,idFollowing);
            preparedStatement.executeUpdate();
        } catch ( SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AuthorDto> collectAllSubscribers(int idFollowing) {
        List<AuthorDto> subscribers = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOLLOWER);
            preparedStatement.setInt(1,idFollowing);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idAuthor = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(5));
                String bio = resultSet.getString(6);
                LocalDate registrationDate = resultSet.getDate(7).toLocalDate();
                AuthorDto authorDto = new AuthorDto(idAuthor,username,email,base64,bio,registrationDate);
                subscribers.add(authorDto);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return subscribers;
    }

    @Override
    public void deleteSubscription(int idFollowing, int idFollower) {
        try (Connection connection = JdbcUtils.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SUBSCRIPTION);
            preparedStatement.setInt(1,idFollowing);
            preparedStatement.setInt(2,idFollower);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
