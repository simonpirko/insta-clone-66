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

public class Author {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private Part avatar;
    private String bio;
    private LocalDate registrationOfDate;
    private List<Post> posts;

    public Author(String email,String password){
        this.email = email;
        this.password = password;
    }

    public Author(String username, String email, String password, Part avatar, String bio, LocalDate registrationOfDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.bio = bio;
        this.registrationOfDate = registrationOfDate;
    }

}
