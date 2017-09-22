package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    @Autowired
    private TwitterRepository twitterRepository;


    public List<Tweet>  getTweet(Integer id){
        return twitterRepository.findByLid(id);
    }

    public void addTweet(Tweet tweet) {
        int i = (int )(Math.random() * 1000 + 1);
        int j=(int)(Math.random()*5000+1);
        System.out.println("yes");
        System.out.println(tweet.getLid());

        twitterRepository.addTweet(i+j,tweet.getTweeter(),tweet.getUser().getId());


    }

    public void deleteTweet(Long id){
        twitterRepository.delete(id);
    }

    public List<Tweet> findByTag(String name){
        return twitterRepository.findByTag(name);

    }

    public void addLikeTweet(Long id){
        twitterRepository.addLike(id);
    }

    public void addDislikeTweet(Long id) {
        twitterRepository.addDisLike(id);
    }

  /*  public List<Tweet> getAllTweet(Integer id) {
      // return twitterRepository.getAllTweet(id);
    }*/

}