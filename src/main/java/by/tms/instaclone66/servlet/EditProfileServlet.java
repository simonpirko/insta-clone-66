package by.tms.instaclone66.servlet;



import by.tms.instaclone66.entity.Author;
import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@WebServlet("/edit_profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditProfileServlet extends HttpServlet {
    private final AuthorService authorService = AuthorService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/edit_profile.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");
        Part avatar = req.getPart("avatar");
        String bio = req.getParameter("bio");
        AuthorDto currentAuthor = (AuthorDto) req.getSession().getAttribute("author");
        LocalDate date = currentAuthor.getRegistrationOfDate();
        int id = currentAuthor.getId();
        Author author = new Author(id, userName, email, password, avatar, bio, date);
        authorService.update(author);
        resp.sendRedirect("/pages/register/register.jsp");
    }
}
