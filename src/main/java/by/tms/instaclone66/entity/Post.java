package by.tms.instaclone66.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.Part;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private AuthorDto authorDto;
    private Part content;
    private String description;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private List<Like> likes;

    public Post(AuthorDto author, Part content, String description, LocalDate publicationDate) {
        this.authorDto = author;
        this.content = content;
        this.description = description;
        this.publicationDate = publicationDate;
    }
}
