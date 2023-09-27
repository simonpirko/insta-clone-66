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
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@WebServlet(value = "/register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegistrationServlet extends HttpServlet {

    private final AuthorService authorService = AuthorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/register/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String email = req.getParameter("email").toLowerCase();
        String password = req.getParameter("password");
        Part avatar = req.getPart("avatar");
        String bio = req.getParameter("bio");
        /*        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");*/
        LocalDate registrationOfDate = LocalDate.now();
        /*        String registrationOfDate = today.format(formatter);*/

        Author author = new Author(userName, email, password, avatar, bio, registrationOfDate);

        Optional<AuthorDto> findAuthorByEmail = authorService.getAuthorByEmail(author);
        if(findAuthorByEmail.isPresent()){
                req.setAttribute("NOTIFICATION", "choose a different email address".toUpperCase());
                req.getServletContext().getRequestDispatcher("/pages/register/register.jsp").forward(req, resp);
            } else {
                authorService.create(author);
                Optional<AuthorDto> registeredUser = authorService.getAuthorByEmail(author);
                if(registeredUser.isPresent()) {
                    AuthorDto currentAuthor = registeredUser.get();
                    String base64 = Base64.getEncoder().encodeToString(currentAuthor.getAvatar());
                    req.setAttribute("dataAvatar", base64);
                    req.getSession().setAttribute("author", currentAuthor);
                    req.setAttribute("NOTIFICATION", "registration was successful".toUpperCase());
                    req.getServletContext().getRequestDispatcher("/pages/register/register.jsp").forward(req, resp);
                }
            }
        }
    }


