package com.company.app.services;
import com.company.app.dao.UserDao;
import com.company.app.models.Users;

public class UserAuthenticateServices {

    UserDetailServices userDetailServices;

    public UserAuthenticateServices() {}

    public void setUserDetailServices(UserDetailServices userDetailServices) {
        this.userDetailServices = userDetailServices;
    }

    public Users auth(String email, String password) {
        //Do your compare
        return  null;
    }
}
