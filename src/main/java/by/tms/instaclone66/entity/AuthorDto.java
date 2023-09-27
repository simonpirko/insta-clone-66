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
    private String userName;
    private String email;
    private String password;
    // private MultipartFile avatar;
    private byte[] avatar;
    private String bio;
    private LocalDate registrationOfDate;
    private List<Post> posts;
}
