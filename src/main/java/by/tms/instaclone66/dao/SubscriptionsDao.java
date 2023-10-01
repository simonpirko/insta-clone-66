package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.AuthorDto;

import java.util.List;

public interface SubscriptionsDao {
    List<AuthorDto> selectAllExceptMe(int id);
    List<AuthorDto> saveFollowing(int idFollowing, int idFollower);

}

