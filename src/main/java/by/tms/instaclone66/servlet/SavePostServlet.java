package by.tms.instaclone66.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SavePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

// Подключение к базе данных
        String jdbcUrl = "jdbc:mysql://localhost:8080/db_name";
        String dbUsername = "username";
        String dbPassword = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
            String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);

            statement.executeUpdate();

            statement.close();
            connection.close();

            response.getWriter().println("Данные успешно сохранены в базе данных.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Ошибка при сохранении данных в базе данных.");
        }
    }
}

