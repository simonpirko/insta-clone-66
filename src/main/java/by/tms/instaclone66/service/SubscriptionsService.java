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

    public List<AuthorDto> showAllAuthors(){
        return subscriptionsDaoJdbc.getAllPeoples();
    }

    public void subscriptionOn(){

    }
    public void subscriptionOff(){

    }

}
