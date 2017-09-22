package com;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tweet")
public class Tweet implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="twitterId",unique = true)
    private long lid;

    @Column(name="tweet")
    private String tweeter;

    @Column(name="hashtag")
    private String hashtag;

    @Column(name="likee")
    private int likee;

    @Column(name="dislikee")
    private int dislikee;

    @ManyToOne
    @JoinColumn(name="user_id")//,updatable = false)
   // @JsonManagedReference
    private User user;

    public Tweet() {
    }

    public Tweet(long lid, String tweeter, String hashtag, int likee, int dislikee, User user) {
        this.lid = lid;
        this.tweeter = tweeter;
        this.hashtag = hashtag;
        this.likee = likee;
        this.dislikee = dislikee;
       // this.user = user;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getTweeter() {
        return tweeter;
    }

    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }

    public int getLikee() {
        return likee;
    }

    public void setLikee(int likee) {
        this.likee = likee;
    }

    public int getDislikee() {
        return dislikee;
    }

    public void setDislikee(int dislikee) {
        this.dislikee = dislikee;
    }


  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
