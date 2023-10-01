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
        String action = req.getParameter("action");
        AuthorDto authorDto = (AuthorDto) req.getSession().getAttribute("author");
        int idFollowing = authorDto.getId();
        switch (action){
            case "/list":
                req.setAttribute("peoples",subscriptionsService.showAllAuthors(idFollowing));
                req.getServletContext().getRequestDispatcher("/pages/subscription/subscription.jsp").forward(req,resp);
            case "/subscribe":
                int idFollower = Integer.parseInt(req.getParameter("id"));
                System.out.println("Subscribe id " + idFollowing);
                req.setAttribute("peoples",subscriptionsService.subscriptionOn(idFollowing,idFollower));
                req.getServletContext().getRequestDispatcher("/pages/subscription/subscription.jsp").forward(req,resp);
            case "/unsubscribe":
                System.out.println("unsubscribe");

                /*subscriptionsService.subscriptionOn(id);*/
                //follower -  на кого подписался
                //following - подписчик
                //



        }
/*        req.setAttribute("peoples",subscriptionsService.showAllAuthors());
        req.getServletContext().getRequestDispatcher("/pages/subscription/subscription.jsp").forward(req,resp);*/




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }
}
