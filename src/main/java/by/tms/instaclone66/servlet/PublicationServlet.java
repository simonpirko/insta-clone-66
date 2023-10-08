package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = "/add_publication")
public class PublicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/publication/add_publication.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part content = req.getPart("content");
        String description = req.getParameter("description");
        LocalDate postOfDate = LocalDate.now();
        AuthorDto authorDto = (AuthorDto) req.getSession().getAttribute("author");
        Post post = new Post(authorDto,content,description,postOfDate);
    }
}
