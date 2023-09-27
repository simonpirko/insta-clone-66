package by.tms.instaclone66.entity;

import javax.servlet.http.Part;
import java.time.LocalDate;
import java.util.List;

public class Post {
    private Integer id;
    private Author author;
    private Part content;
    private String discription;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private List<Like> likes;
}
