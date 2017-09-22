package com;

import java.io.Serializable;

public class Usersfoll implements Serializable{
   private Long mainid;
  private   Long newid;

    public Usersfoll() {
    }

    public Usersfoll(Long mainid, Long newid) {
        this.mainid = mainid;
        this.newid = newid;
    }

    public Long getMainid() {
        return mainid;
    }

    public void setMainid(Long mainid) {
        this.mainid = mainid;
    }

    public Long getNewid() {
        return newid;
    }

    public void setNewid(Long newid) {
        this.newid = newid;
    }
}
