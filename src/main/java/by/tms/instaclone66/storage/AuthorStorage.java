package by.tms.instaclone66.storage;

import by.tms.instaclone66.model.Author;

import java.util.Optional;

public interface AuthorStorage {
    void update(Author author);
    Optional<Author> getAuthorById(int id);
}
