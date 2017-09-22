package com;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;




@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "userName",unique = true)
    private String userName;

    @Column(name = "email",unique = true)
    private String email;


    @Column(name = "firstName")
    private String first_name;

    @Column(name = "lastName")
    private String last_name;


    @Column(name = "password")
    private String password;

    @ManyToMany()
    @JoinTable
    private Set<Interest> interests;



    @OneToMany(mappedBy = "user")
    //@JsonBackReference
    private Set<Tweet> tweets;


    @ManyToMany
  //  @JoinTable(name="f_f",joinColumns = {@JoinColumn(name="f1")},inverseJoinColumns = {@JoinColumn(name = "f2")})
    @JoinTable()
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

    private Set<User> following;

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @ManyToMany(mappedBy = "following",fetch = FetchType.EAGER)
    private Set<User> f2;

   //private List<Integer> followers;


public User(){

}
    public User(User user) {
        this.id = user.id;
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
       // this.followers=user.followers;
    }



    public User(Long id, String userName, String email, String first_name, String last_name, String password, Set<Interest> interests,List<Integer> followers) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.interests = interests;
       // this.followers = followers;
      //  this.tweets = tweets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Interest> getInterests(){
        return interests;
    }
    public void setInterests(Set<Interest> interests){
     this.interests=interests;
    }

    @JsonIgnore
    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }


    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }


    @JsonIgnore
        public Set<User> getF2() {
        return f2;
    }

    public void setF2(Set<User> f2) {
        this.f2 = f2;
    }

   /* public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }*/


  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (interests != null ? !interests.equals(user.interests) : user.interests != null) return false;
        if (tweets != null ? !tweets.equals(user.tweets) : user.tweets != null) return false;
        if (following != null ? !following.equals(user.following) : user.following != null) return false;
        return f2 != null ? f2.equals(user.f2) : user.f2 == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (interests != null ? interests.hashCode() : 0);
        result = 31 * result + (tweets != null ? tweets.hashCode() : 0);
        result = 31 * result + (following != null ? following.hashCode() : 0);
        result = 31 * result + (f2 != null ? f2.hashCode() : 0);
        return result;
    }*/
}

