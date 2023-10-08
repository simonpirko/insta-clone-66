package by.tms.instaclone66.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private Integer id;
    private AuthorDto author;
    private String content;
    private String description;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private List<Like> likes;
}

