package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.*;
import by.tms.instaclone66.utils.JdbcUtils;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
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

    private static final String INSERT_POST = "INSERT INTO Post(account_id,content,description,post_date) VALUES (?,?,?,?)";

    private static final String SELECT_POST_LIKE_COMMENT = "SELECT P.id,P.content,P.description,P.post_date FROM Post P INNER JOIN Account A ON P.account_id = A.id WHERE A.id = ?";

    private static final String DELETE_POST_QUERY = "DELETE FROM Post WHERE id = ?";


    @Override
    public void save(Post post) throws IOException {
        Part file = post.getContent();
        InputStream fileContent = file.getInputStream();
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST);
            preparedStatement.setInt(1, post.getAuthorDto().getId());
            preparedStatement.setBinaryStream(2, fileContent);
            preparedStatement.setString(3, post.getDescription());
            preparedStatement.setDate(4, java.sql.Date.valueOf(post.getPublicationDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deletePost(int id) {
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_POST_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PostDto> selectAllPostByAuthorId(AuthorDto authorDto) {
        List<PostDto> postDtos = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POST_LIKE_COMMENT);
            preparedStatement.setInt(1, authorDto.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String base64 = Base64.getEncoder().encodeToString(resultSet.getBytes(2));
                PostDto postDto = new PostDto(resultSet.getInt(1), base64,
                        resultSet.getString(3), resultSet.getDate(4).toLocalDate());
                postDtos.add(postDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return postDtos;
    }

    @Override
    public List<Comment> selectAllCommentByPostId(AuthorDto authorDto) {
        return null;
    }

    @Override
    public List<Like> selectAllLikesByPostId(AuthorDto authorDto) {
        return null;
    }
}
