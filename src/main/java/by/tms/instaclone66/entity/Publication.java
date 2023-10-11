package by.tms.instaclone66.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publication {
    private Integer id;
    private User user;
    private String content;
    private String description;
    private LocalDate postOfDate;
    private List<Comment> comments;
    private List<Like> likes;

    public Publication(Integer id, String content, String description, LocalDate postOfDate) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.postOfDate = postOfDate;
    }

    public Publication(User author, String content, String description, LocalDate postOfDate) {
        this.user = author;
        this.content = content;
        this.description = description;
        this.postOfDate = postOfDate;
    }
}

