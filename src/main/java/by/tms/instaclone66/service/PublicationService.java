package by.tms.instaclone66.service;

import by.tms.instaclone66.dao.PostDaoJdbc;
import by.tms.instaclone66.dao.SubscriptionsDaoJdbc;
import by.tms.instaclone66.entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublicationService {
    private final PostDaoJdbc postDaoJdbc = PostDaoJdbc.getInstance();


    private static PublicationService instance;


    private PublicationService() {

    }

    public static PublicationService getInstance() {
        if (instance == null) {
            instance = new PublicationService();
        }
        return instance;
    }
    public void create(Post post) throws IOException {
        postDaoJdbc.save(post);
    }


    public List<PostDto> getPostsByAuthorId(AuthorDto authorDto){
        return postDaoJdbc.selectAllPostByAuthorId(authorDto);
    }

}
