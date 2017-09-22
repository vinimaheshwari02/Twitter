package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TwitterRepository extends JpaRepository<Tweet,Long> {

  // @Query(value = "select t.lid, t.tweeter, t.likee, t.dislikee, t.user.id, t.user.userName, t.user.email, t.user.first_name, t.user.last_name, t.user.password, t.user.interests from Tweet t where t.user.id=?1")
  @Query(value = "select t from Tweet t where t.user.id=?1")
    public List<Tweet> findByLid(long id);

    @Query(value = "Select t from Tweet t where t.tweeter like %?1%")
   public List<Tweet> findByTag(String name);


    @Modifying
    @Transactional
    @Query(value = "update Tweet t set t.likee =t.likee+1 where t.lid =?1")
   public void addLike(Long id);



    @Modifying
    @Transactional
    @Query(value = "update Tweet t set t.dislikee =t.dislikee+1 where t.lid =?1")
    public void addDisLike(Long id);

    @Query(value = "insert into tweet(twitter_id,dislikee,hashtag,likee,tweet,user_id) values(?1,0,'',0,?2,?3)",nativeQuery = true)
    public void addTweet(long id,String name,Long uid);


    // @Query(value="select t from Tweet t and User  where (u.id=?1) and (t.user.id=?1 or t.user.id=u.following[0].id)")
   // public List<Tweet> getAllTweet(Integer id);
}