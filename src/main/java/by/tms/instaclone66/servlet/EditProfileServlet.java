package by.tms.instaclone66.servlet;

import by.tms.instaclone66.model.Author;
import by.tms.instaclone66.storage.MySqlAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/edit_profile")
public class EditProfileServlet extends HttpServlet {
    private final MySqlAuthorStorage authorStorage = MySqlAuthorStorage.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = (int) req.getSession().getAttribute("currentAuthorID");
        Author author = authorStorage.getAuthorById(authorId).get();
        req.getSession().setAttribute("currentAuthor", author);
        getServletContext().getRequestDispatcher("pages/edit_profile.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
