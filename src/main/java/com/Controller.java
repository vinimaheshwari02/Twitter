package com;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.security.Principal;
import java.util.*;


@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private TwitterService twitterService;


    @CrossOrigin(origins = "*")
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/addUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> createUser(@RequestBody User user) {

        try {
            System.out.print(user.getFirst_name());
            // Handle the User object here
            userService.addUser(user);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/findUser",
            method = RequestMethod.GET

            )

    public ResponseEntity<?> Find(@RequestParam(value="name")String name) {

        try {
            // Handle the User object here
            System.out.print(userService.getUser(name));

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.getUser(name),HttpStatus.OK);
    }

   @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/findTweet",
            method = RequestMethod.GET
    )

    public ResponseEntity<?> FindTweet(@RequestParam(value="id")Integer id) {

        try {
            // Handle the User object here
         twitterService.getTweet(id);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(twitterService.getTweet(id),HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/addTweet",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> createTweet(@RequestBody Tweet tweet) {

        try {


            twitterService.addTweet(tweet);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
@CrossOrigin("*")
    @RequestMapping( value = "/updateUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
           // userService.updateUser(user);
            userService.updateProfile(user);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/deleteTweet",
            method = RequestMethod.GET
            )
    public ResponseEntity<?> deleteTweet(@RequestParam(value="id")Long id){
        try {


            twitterService.deleteTweet(id);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

   /* @RequestMapping( value = "/findFollowing",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>findFollowing(@RequestParam(value="id")Long id){
        try {


            userService.findFollowing(id);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.findFollowing(id),HttpStatus.OK);
    }
*/
    @RequestMapping( value = "/findFollowing",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>findFollowers(@RequestParam(value="name")String name){
        try {


            userService.findFollowing(name);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.findFollowing(name),HttpStatus.OK);
    }


    @RequestMapping(value = "/hom", method = RequestMethod.POST)
    @ResponseBody
  public Principal currentUserName(Principal principal) {
        return principal;
    }



@CrossOrigin(origins = "*")
    @RequestMapping( value = "/findByTag",
            method = RequestMethod.GET)
    public ResponseEntity<?>findByTag(@RequestParam(value="name")String name){
        try {


            twitterService.findByTag(name);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(twitterService.findByTag(name),HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping( value = "/findByName",
            method = RequestMethod.GET)
    public ResponseEntity<List<User>>findByUserNam(@RequestParam(value="name")String name){
        try {


            userService.findByUserNam(name);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(userService.findByUserNam(name),HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping( value = "/addLikeTweet",
            method = RequestMethod.POST            )
    public ResponseEntity<?> updateAddTweet(@RequestParam(value="id")Long id){
        try {
            twitterService.addLikeTweet(id);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/addDisLikeTweet",
            method = RequestMethod.POST            )
    public ResponseEntity<?> updateDeleteTweet(@RequestParam(value="id")Long id){
        try {
            twitterService.addDislikeTweet(id);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/findUserotherthan",
            method = RequestMethod.GET

    )

    public ResponseEntity<?> findOther(@RequestParam(value="name")String name) {

        try {
            // Handle the User object here
            System.out.print(userService.getUser(name));

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.getUserother1(name),HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping( value = "/findFollowers",
            method = RequestMethod.POST            )
    public ResponseEntity<?> followers(@RequestParam(value="name")String name){
        try {

         userService.getUserother12(name);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.getUserother12(name),HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/findFollowin",
            method = RequestMethod.POST            )
    public ResponseEntity<?> following(@RequestParam(value="name")String name){
        try {

            userService.findByUserNamforFollowers(name);

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.findByUserNamforFollowers(name),HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/updUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updUser(@RequestBody Usersfoll u){
        try {
            // userService.updateUser(user);
            System.out.println(u);
            System.out.println(u.getMainid());
            System.out.println(u.getNewid());
            userService.updateProfileagain(u.getMainid(),u.getNewid());

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/findFollowing1",
            method = RequestMethod.POST
           )
    public ResponseEntity<?> upd(@RequestParam(value="name")String name){
        try {
            // userService.updateUser(user);


            userService.findNameofFollowing(name);




        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.findNameofFollowing(name),HttpStatus.OK);
    }
    @CrossOrigin("*")
    @RequestMapping( value = "/unfollow",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> unfollow(@RequestBody Usersfoll u){
        try {
            // userService.updateUser(user);

            userService.unfollow(u.getMainid(),u.getNewid());

        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }



   /* @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/findAllTweet",
            method = RequestMethod.GET
    )

    public ResponseEntity<?> FindallTweet(@RequestParam(value="id")Integer id) {

        try {
            // Handle the User object here
            twitterService.getAllTweet(id);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(twitterService.getTweet(id),HttpStatus.OK);
    }
    */



}

