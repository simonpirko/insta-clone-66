package by.tms.instaclone66.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Author {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private String avatar;
    private String bio;
    private LocalDate registrationOfDate;
    //private List<Post> posts;
}
