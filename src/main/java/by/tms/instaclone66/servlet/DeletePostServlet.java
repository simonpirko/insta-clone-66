package by.tms.instaclone66.servlet;

import by.tms.instaclone66.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/publication")
public class DeletePostServlet extends HttpServlet {
    private final PostService postService = PostService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login/publication.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deletePost = req.getParameter("deletePost");
        postService.deletePost(Integer.parseInt(deletePost));
        req.getServletContext().getRequestDispatcher("/pages/login/publication.jsp").forward(req, resp);
    }
}
