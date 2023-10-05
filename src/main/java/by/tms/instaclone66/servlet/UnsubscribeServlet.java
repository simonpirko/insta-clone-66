package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.service.SubscriptionsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/unsubscribe")
public class UnsubscribeServlet extends HttpServlet {
    SubscriptionsService subscriptionsService = SubscriptionsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDto author = (AuthorDto) req.getSession().getAttribute("author");
        int idUnfollowing = Integer.parseInt(req.getParameter("id"));
        subscriptionsService.unsubscribe(idUnfollowing, author.getId());
        req.setAttribute("peoples", subscriptionsService.showSubscriptions(author.getId()));
        req.getServletContext().getRequestDispatcher("/pages/subscription/unsubscribe.jsp").forward(req, resp);
    }
}
