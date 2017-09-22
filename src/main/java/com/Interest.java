package com;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="interest")
public class Interest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false,unique = true)
    @NotNull
    private long id =0l;

    @Column(name="interest")
    private String interest;

    @ManyToMany(mappedBy = "interests")
    private Set<User> users;



    public Interest() {
    }

    public Interest(long id, String interest) {
        this.id = id;
        this.interest = interest;

    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @JsonIgnore
    public Set<User> getUsers(){
        return users;
    }
    public void setUsers(Set<User> users){
        this.users=users;
    }


}
