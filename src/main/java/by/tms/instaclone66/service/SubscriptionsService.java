package by.tms.instaclone66.service;

import by.tms.instaclone66.dao.SubscriptionsDaoJdbc;
import by.tms.instaclone66.entity.AuthorDto;

import java.util.List;

public class SubscriptionsService {
    private static SubscriptionsService instance;

    private SubscriptionsService() {

    }

    private final SubscriptionsDaoJdbc subscriptionsDaoJdbc = SubscriptionsDaoJdbc.getInstance();

    public static SubscriptionsService getInstance() {
        if (instance == null) {
            instance = new SubscriptionsService();
        }
        return instance;
    }

    public List<AuthorDto> showAllAuthors(int id) {
        return subscriptionsDaoJdbc.selectAllUnSubscribers(id);
    }

    public void subscribe(int idFollower, int idFollowing) {
        subscriptionsDaoJdbc.saveSubscription(idFollower, idFollowing);
    }

    public void unsubscribe(int idFollower, int idFollowing) {
        subscriptionsDaoJdbc.deleteSubscription(idFollowing, idFollower);
    }

    public List<AuthorDto> showAllSubscriptions(int idFollowing) {
        return subscriptionsDaoJdbc.collectAllSubscriptions(idFollowing);
    }

    public List<AuthorDto> showAllSubscribers(int idFollowing){
        return subscriptionsDaoJdbc.collectAllSubscribers(idFollowing);
    }


}
