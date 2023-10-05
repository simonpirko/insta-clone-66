package by.tms.instaclone66.dao;

import by.tms.instaclone66.entity.AuthorDto;

import java.util.List;

public interface SubscriptionsDao {
    List<AuthorDto> selectAllExceptMe(int id);
    void saveFollowing(int idFollowing, int idFollower);
    List<AuthorDto> collectAllSubscribers(int idFollowing);

    void deleteSubscription(int idFollowing, int idFollower);

}

