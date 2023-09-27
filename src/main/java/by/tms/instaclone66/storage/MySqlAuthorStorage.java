package by.tms.instaclone66.storage;

import by.tms.instaclone66.model.Author;

import java.sql.*;
import java.util.Optional;

public class MySqlAuthorStorage implements AuthorStorage{
    private static MySqlAuthorStorage instance;
    public static MySqlAuthorStorage getInstance(){
        if (instance == null){
            instance = new MySqlAuthorStorage();
        }
        return instance;
    }
    @Override
    public void update(Author author) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_instclone", "root", "msqlsrvrpss")){
            PreparedStatement ps;
            ps = connection.prepareStatement("UPDATE ACCOUNT SET USERNAME = ?, PASSWORD = ?, EMAIL = ?, BIO = ? WHERE ID = ?");
            ps.setString(1, author.getUserName());
            ps.setString(2, author.getPassword());
            ps.setString(3, author.getEmail());
            //ps.setString(3, author.get());
            ps.setString(5, author.getBio());
            ps.setInt(6, author.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Author> getAuthorById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps;
            ps = connection.prepareStatement(" SELECT * FROM ACCOUNT\n" + "WHERE ID = ? LIMIT 1;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Author author = new Author(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("AVATAR"), rs.getString("BIO"), rs.getDate("REGISTRATION_DATE").toLocalDate());
            return Optional.of(author);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
