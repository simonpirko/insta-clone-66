package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.service.SubscriptionsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet(value = "/subscription")
public class SubscriptionsServlet extends HttpServlet {
    private final SubscriptionsService subscriptionsService = SubscriptionsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDto author = (AuthorDto) req.getSession().getAttribute("author");
        req.setAttribute("peoples", subscriptionsService.showAllAuthors(author.getId()));
        req.getServletContext().getRequestDispatcher("/pages/subscription/subscribe.jsp").forward(req, resp);
    }

    //follower -  на кого подписался
    //following - подписчик
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
