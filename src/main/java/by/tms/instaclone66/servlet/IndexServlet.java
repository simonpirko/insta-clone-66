package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.Author;
import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

/**
 * @author Simon Pirko on 18.09.23
 */

@WebServlet("/login")
public class IndexServlet extends HttpServlet {
    private final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Author author = new Author(email, password);
        Optional<AuthorDto> findAuthorByEmail = authorService.getAuthorByEmail(author.getEmail());
        if (findAuthorByEmail.isPresent()) {
            AuthorDto currentAuthor = findAuthorByEmail.get();
            if (currentAuthor.getPassword().equals(password)) {
                /*req.setAttribute("dataAvatar", currentAuthor.getAvatar());*/
                req.getSession().setAttribute("author", currentAuthor);
                req.setAttribute("NOTIFICATION", "Welcome !!!");
                req.getServletContext().getRequestDispatcher("/pages/register/register.jsp").forward(req, resp);
            } else {
                req.setAttribute("NOTIFICATION", "Incorrect password".toUpperCase());
                req.getServletContext().getRequestDispatcher("/pages/login/index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("NOTIFICATION", "User is not found".toUpperCase());
            req.getServletContext().getRequestDispatcher("/pages/login/index.jsp").forward(req, resp);
        }
    }
}
