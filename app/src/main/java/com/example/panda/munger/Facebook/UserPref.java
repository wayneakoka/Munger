package com.example.panda.munger.Facebook;

/**
 * Created by Panda on 12/5/16.
 */

public class UserPref {

    public String username;
    public String facebookID;
    public String gender;

    public UserPref(){
    }

    public String getUsername()  {
        return username;
        }
    public String getfacebookID()  {
        return facebookID;
    }
    public String getgender()  {
        return gender;
    }

    public UserPref (String username, String facebookID, String gender){
        this.username = username;
        this.facebookID = facebookID;
        this.gender = gender;
    }


}
