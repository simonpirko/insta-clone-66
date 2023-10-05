package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.service.SubscriptionsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/subscribe")
public class SubscribeServlet extends HttpServlet {
    private final SubscriptionsService subscriptionsService = SubscriptionsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDto authorDto = (AuthorDto) req.getSession().getAttribute("author");
        req.setAttribute("peoples", subscriptionsService.showSubscriptions(authorDto.getId()));
        req.getServletContext().getRequestDispatcher("/pages/subscription/unsubscribe.jsp").forward(req, resp);
    }

    //follower -  на кого подписался
    //following - подписчик
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDto author = (AuthorDto) req.getSession().getAttribute("author");
        int idFollower = Integer.parseInt(req.getParameter("id"));
        subscriptionsService.subscribe(idFollower, author.getId());
        req.setAttribute("peoples", subscriptionsService.showSubscriptions(author.getId()));
        req.getServletContext().getRequestDispatcher("/pages/subscription/unsubscribe.jsp").forward(req, resp);
    }
}
