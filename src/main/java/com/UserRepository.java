package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Index;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /*
    public User findByUserName(String userName);*/


    public User findByUserName(String name);




/*
    @Query(value = "select t.Followers from User t where t.id=?1")
    public List<User> findFollowing(Long id);
*/
 @Query(value = "select t.following from User t where t.userName=?1")
   public List<User> findFollowing(String name);

    @Query(value="select t from User t where t.userName!=?1")
    List<User> getUserother(String name);

    @Modifying
    @Transactional
    @Query(value="update User u set u.first_name=?1,u.last_name=?2,u.password=?3 where u.userName=?4")
   public void updateProfile(String first_name, String last_name, String password,String name);

    @Modifying
    @Transactional
    @Query(value="insert into users_interests(users_id,interests_id) values(?1,?2)",nativeQuery = true)
    public void updateInterest(Long id, long id1);

    @Modifying
    @Transactional
    @Query(value="delete from users_interests ui where ui.users_id=?1",nativeQuery = true)
   public void deleteInterests(Long id);

    @Query(value="insert into users_following(f2_id,following_id) values(?1,?2)",nativeQuery = true)
    public void updateProfileagain(Long mainid, Long newid);

    @Query(value="delete from users_following ui where ui.f2_id=?1 and ui.following_id=?2",nativeQuery = true)
    public void unfollow(Long mainid, Long newid);
}
