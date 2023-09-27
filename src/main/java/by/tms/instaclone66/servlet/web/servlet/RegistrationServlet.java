package by.tms.instaclone66.servlet.web.servlet;

import by.tms.instaclone66.servlet.entity.User;
import by.tms.instaclone66.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (userService.getByEmail(email).isPresent()) {
            req.setAttribute("existsEmail", "Email is taken, please select another email");
            req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
        } else {
            userService.create(userName, email, password);
            req.getServletContext().setAttribute("message", "Registration is Success");
            req.getServletContext().getRequestDispatcher("/pages/Home.jsp").forward(req, resp);
        }
    }
}
