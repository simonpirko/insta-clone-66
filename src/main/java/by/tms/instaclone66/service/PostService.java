package by.tms.instaclone66.service;

import by.tms.instaclone66.dao.PostDaoJdbc;

public class PostService {
    private static PostService instance;

    private PostService() {

    }

    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        return instance;
    }
    PostDaoJdbc postDaoJdbc = PostDaoJdbc.getInstance();

    public void deletePost(int id) {
        postDaoJdbc.deletePost(id);
    }

}
