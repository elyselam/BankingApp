//package com.company.app.dao;
//import com.company.app.models.Users;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Collection;
//import java.util.HashMap;
//
//
//
//public class UserDao implements UserRepository{
//
//    private HashMap<String, Users> map = new HashMap<>();
//
//    public Users getUser(String email) {
//        return map.get(email);
//    }
//
//
//    //used in CustomerLoginService. returns bool
//    public boolean checkEmailAndPassword(String email, String password) {
//        //hashcode returns a int that's why using ==
//        if(map.get(email) == null){return false;}
//        return map.get(email).getPassword() == password.hashCode();
//    }
//
//    public void createNewUser(String email, String password, int id) {
//        Users user = new Users();
//        map.put(email, user);
//    }
//
//    public UserDao() {
//        loadUsers();
//    }
//
//    private void loadUsers(){
//        //read in the user data from the file system and
//        //from jdbc
//        findAll();
//
//        //and for each user, add to map
//        //put the data in the map
//        map.put(email, user):
//
//        returning map;
//    }
//
//    private void writeUsers(){
//        //empty the user data files and
//
//        //write the map to the file
//    }
//
//    @Override
//    public Users getByEmail(String email) {
//        //search the map for a user with this email
//
//        return null;
//    }
//
//    @Override
//    public Users findById(int id) {
//        //search the map for a user with this id
//        return null;
//    }
//
//    @Override
//    public Collection<Users> findAll() {
//        //create a list from the user map and return the list
//        return null;
//    }
//
//    @Override
//    public int save(Users obj) {
//        //perform an upsert
//
//        //insert if obj reps a new User
//
//        Users user = new Users(email, password);
//        map.put(email, user);
//        //update otherwise
//        writeUsers();
//        return 0;
//    }
//
//    @Override
//    public void delete(Users obj) {
//        //remove the user from the map
//        writeUsers();
//    }
//}
//
