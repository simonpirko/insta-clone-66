package by.tms.instaclone66.service;

import by.tms.instaclone66.dao.SubscriptionsDaoJdbc;
import by.tms.instaclone66.entity.AuthorDto;

import java.util.List;

public class SubscriptionsService {
    private static SubscriptionsService instance;
    private SubscriptionsService(){

    }
    private final SubscriptionsDaoJdbc subscriptionsDaoJdbc = SubscriptionsDaoJdbc.getInstance();
    public static SubscriptionsService getInstance(){
        if(instance == null){
            instance = new SubscriptionsService();
        }
        return instance;
    }

    public List<AuthorDto> showAllAuthors(int id){
        return subscriptionsDaoJdbc.selectAllExceptMe(id);
    }

    public List<AuthorDto> subscriptionOn(int idFollowing, int idFollower){
        return subscriptionsDaoJdbc.saveFollowing(idFollowing,idFollower);
    }
    public void subscriptionOff(){

    }

}
