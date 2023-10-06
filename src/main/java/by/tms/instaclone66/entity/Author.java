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
    private String userName;
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

    public Author(String userName, String email, String password, Part avatar, String bio, LocalDate registrationOfDate) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.bio = bio;
        this.registrationOfDate = registrationOfDate;
    }

    public Author(int id, String userName, String email, String password, Part avatar, String bio, LocalDate date) {

    }
}
