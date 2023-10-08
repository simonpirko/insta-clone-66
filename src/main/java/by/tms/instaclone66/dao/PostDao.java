package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.*;

import java.io.IOException;
import java.util.List;

public interface PostDao {
    void save(Post post) throws IOException;

    List<PostDto> selectAllPostByAuthorId(AuthorDto authorDto);

    List<Comment> selectAllCommentByPostId(AuthorDto authorDto);

    List<Like> selectAllLikesByPostId(AuthorDto authorDto);

    void deletePost(int id);
}