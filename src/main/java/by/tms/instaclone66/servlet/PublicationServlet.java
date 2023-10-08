package by.tms.instaclone66.servlet;

import by.tms.instaclone66.entity.AuthorDto;
import by.tms.instaclone66.entity.Post;
import by.tms.instaclone66.entity.PostDto;
import by.tms.instaclone66.service.PublicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(value = "/add_publication")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class PublicationServlet extends HttpServlet {
    private final PublicationService publicationService = PublicationService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorDto authorDto = (AuthorDto) req.getSession().getAttribute("author");
        req.setAttribute("posts", publicationService.getPostsByAuthorId(authorDto));
        req.getServletContext().getRequestDispatcher("/pages/publication/add_publication.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part content = req.getPart("content");
        String description = req.getParameter("description");
        LocalDate postOfDate = LocalDate.now();
        AuthorDto authorDto = (AuthorDto) req.getSession().getAttribute("author");
        Post post = new Post(authorDto,content,description,postOfDate);
        publicationService.create(post);
        doGet(req,resp);

        /*authorDto.setPosts(publicationService.getPostsByAuthorId(authorDto));*/
        /*req.setAttribute("posts", publicationService.getPostsByAuthorId(authorDto));
        req.getServletContext().getRequestDispatcher("/pages/publication/add_publication.jsp").forward(req,resp);*/
    }
}
