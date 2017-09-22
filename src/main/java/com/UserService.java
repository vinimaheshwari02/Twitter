package com;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);

    }
    public List<User> getAllUser(){
        List<User> users=new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }
    public User getUser(String name){

        return userRepository.findByUserName(name);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
    public  void deleteUser(Long id){
        userRepository.delete(id);
    }

  /*  public List<User> findFollowing(Long id){
       return userRepository.findFollowing(id);
    }*/
    public List<User> findFollowing(String name){
        return userRepository.findFollowing(name);
    }

    public User findByUserNam(String name) {
        return userRepository.findByUserName(name);
    }

    public List<User> getUserother1(String name) {

        return userRepository.getUserother(name);

    }

    public ArrayList<String> getUserother12(String name) {
        List<User> topics = userRepository.getUserother(name);

        ArrayList<String> mylist = new ArrayList<String>();

        for (int i = 0; i < (topics.size()); i++) {


            Set<User> collection= topics.get(i).getFollowing();
            for (User s : collection) {

                if(name.equals(s.getUserName())){
                    mylist.add(topics.get(i).getUserName());
                    break;
                }

            }

            // 1 - can call methods of element
            // 2 - can use i to make index-based calls to methods of list

            // ...
        }
        System.out.println(mylist);

        return mylist;
    }

    public ArrayList<ArrayList<Object>> findByUserNamforFollowers(String name) {
        ArrayList<ArrayList<Object>> mine = new ArrayList<>();
       User t = userRepository.findByUserName(name);
       Set<User> f= t.getFollowing();

       for(User s:f){
           ArrayList<Object> o=new ArrayList<>();
           o.add(s.getId());
           o.add(s.getUserName());


           mine.add(o);
       }

       return mine;
    }

    public void updateProfile(User user) {


       // userRepository.updateProfile(1);

       userRepository.updateProfile(user.getFirst_name(),user.getLast_name(),user.getPassword(),user.getUserName());

       Set <Interest> itere=user.getInterests();
       System.out.println(itere);
        userRepository.deleteInterests(user.getId());
        System.out.println(itere);
       for(Interest s:itere){
           System.out.println(user.getId());
          System.out.println(s.getId());

          userRepository.updateInterest(user.getId(),s.getId());

       }


    }


    public void updateProfileagain(Long mainId, Long newid) {
        userRepository.updateProfileagain(mainId,newid);
    }

    public ArrayList<ArrayList<Object>> findNameofFollowing(String name) {
        ArrayList<ArrayList<Object>> mine = new ArrayList<>();
        User u= userRepository.findByUserName(name);
        Set<User> uf= u.getFollowing();

        for(User n:uf){
            ArrayList<Object> o=new ArrayList<>();
            o.add(n.getId());
            o.add(n.getUserName());


            mine.add(o);
        }
        return mine;
    }

    public void unfollow(Long mainid, Long newid) {
        userRepository.unfollow(mainid,newid);
    }
}