package by.tms.instaclone66.service;

import by.tms.instaclone66.dao.AuthorDaoJdbc;
import by.tms.instaclone66.entity.Author;
import by.tms.instaclone66.entity.AuthorDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AuthorService {
    private static final String EMAIL_ALREADY_REGISTERED_MSG = "Пользователь с таким email уже зарегистрирован !";
    private static final String REGISTRATION_COMPLETED_SUCCESSFULLY_MSG = "Регистрация прошла успешно ! ";
    AuthorDaoJdbc authorDaoJdbc = AuthorDaoJdbc.getInstance();
    private static AuthorService instance;

    private AuthorService() {

    }

    public static AuthorService getInstance() {
        if (instance == null) {
            instance = new AuthorService();
        }
        return instance;
    }


    public void create(Author author) throws IOException {
        authorDaoJdbc.save(author);
    }

    public Optional<AuthorDto> getAuthorByEmail(Author author) throws IOException {
        return authorDaoJdbc.findAuthorByEmail(author.getEmail());
    }


    public List<Author> printingAuthorData(){
        return null;
    }
    public void update(Author author) throws IOException {
        authorDaoJdbc.update(author);
    }
}
