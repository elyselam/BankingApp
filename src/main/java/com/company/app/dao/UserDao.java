package com.company.app.dao;
import com.company.app.models.Users;
import java.util.HashMap;



public class UserDao {

    HashMap<String, Users> map = new HashMap<>();
    public Users getUser(String email) {
        return map.get(email);
    }


    //used in CustomerLoginService. returns bool
    public boolean checkPassword(Users user, String password) {
        //hashcode returns a int that's why using ==
        return user.getPassword() == password.hashCode();
    }
}

