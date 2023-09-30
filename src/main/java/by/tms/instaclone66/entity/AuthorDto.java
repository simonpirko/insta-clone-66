package by.tms.instaclone66.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
    // private MultipartFile avatar;
    private String avatar;
    private String bio;
    private LocalDate registrationOfDate;
    private List<Post> posts;

    public AuthorDto(Integer id, String username, String email, String avatar, String bio, LocalDate registrationOfDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.bio = bio;
        this.registrationOfDate = registrationOfDate;
    }
}
