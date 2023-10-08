package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.Author;
import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.utils.JdbcUtils;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Base64;
import java.util.Optional;

public class AuthorDaoJdbc implements AuthorDao {

    private static AuthorDaoJdbc instance;

    private AuthorDaoJdbc() {

    }

    public static AuthorDaoJdbc getInstance() {
        if (instance == null) {
            instance = new AuthorDaoJdbc();
        }
        return instance;
    }


    private static final String INSERT_QUERY = "INSERT INTO Account(username,email,password,avatar,bio,registration_date)" +
            " VALUES (?,?,?,?,?,?)";
    private static final String SELECT_AUTHOR_BY_EMAIL_QUERY = "SELECT * FROM Account WHERE email = ?";


    @Override
    public void save(Author author) throws IOException {
        Part file = author.getAvatar();
        InputStream fileContent = file.getInputStream();
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, author.getUsername());
            preparedStatement.setString(2, author.getEmail());
            preparedStatement.setString(3, author.getPassword());
            preparedStatement.setBinaryStream(4, fileContent);
            preparedStatement.setString(5, author.getBio());
            preparedStatement.setDate(6, java.sql.Date.valueOf(author.getRegistrationOfDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JdbcUtils.printSQLException(e);
        }
    }

    @Override
    public Optional<AuthorDto> findAuthorByEmail(String email) {
        AuthorDto authorDto = new AuthorDto();
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_EMAIL_QUERY);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authorDto.setId(resultSet.getInt(1));
                authorDto.setUsername(resultSet.getString(2));
                authorDto.setEmail(resultSet.getString(3));
                authorDto.setPassword(resultSet.getString(4));
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(5));
                authorDto.setAvatar(base64);
                authorDto.setBio(resultSet.getString(6));
                authorDto.setRegistrationOfDate(resultSet.getDate(7).toLocalDate());
            }
        } catch (SQLException e) {
            JdbcUtils.printSQLException(e);
        }
        if (authorDto.getEmail() != null) {
            return Optional.of(authorDto);
        } else {
            return Optional.empty();
        }
    }
}
