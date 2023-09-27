package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.Author;
import by.tms.instaclone66.entity.AuthorDto;

import java.io.IOException;
import java.util.Optional;

public interface AuthorDao {
    void save(Author author) throws IOException;
    Optional<AuthorDto> findAuthorByEmail(String email);
}
