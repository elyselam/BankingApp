package com.company.app.dao;

import com.company.Main;
import com.company.app.models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserJDBCDao implements UserRepository {

    public Users getByEmail(String email) {
        String sql = "SELECT email, pword from user_table where email = ?";
        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();

            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet results = statement.executeQuery();
            Users u = null;
            while(results.next()){
                String email = results.getInt("email");
                int pword = results.getInt("pword");
                u = new Users (email, pword);
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Collection<Users> findAll() {

        String sql = "{ call get_all_users() }";

        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            CallableStatement statement = c.prepareCall(sql);

            ResultSet results = statement.executeQuery();

            List<Users> users = new ArrayList<>();
            while(results.next()){
                int id = results.getInt("id");
                String _email = results.getString("email");
                String password = results.getString("password");

                users.add(new Users(_email, password));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public int save(Users obj) {
        // check the obj for an email
//        // 0 id means this object has never been persisted 'insert'
//        // otherwise 'update'
        //return value
        int out_id = 0;
        Connection c = null;

        if(obj.getId() == 0) {
            // never saved 'insert'
            String sql = "{ ? = call add_new_user(?, ?) }";

            System.out.println("Executing statement \n " + sql);
            try {
                c = Main.manager.getConnection();
                CallableStatement statement = c.prepareCall(sql);
                // register the out parameter to get the value returned from the callable statement.
                // Hopefully the new id
                statement.registerOutParameter(1, Types.INTEGER);
                statement.setString(2, obj.getEmail());
                statement.setInt(3, obj.getPassword());

                // turn of auto-commit
                // we want to control the transaction
                c.setAutoCommit(false);
                statement.execute();
                // The result is stored on the statement
                out_id = (Integer) statement.getObject(1);
                // everything went well commit and reset the database auto-commit flag
                c.commit();
                c.setAutoCommit(true);

                return out_id;

            } catch (SQLException e) {
                // something went wrong try to rollback
                e.printStackTrace();
                if(c != null) {
                    try {
                        // this can fail for a number of reasons
                        // most likely the connection has been closed
                        c.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }



    @Override
    public void delete(Users obj) {
        String sql = "DELETE from user_table where email = ?";
        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, "e@gmail.com");

            int row = statement.executeUpdate();

            //print row deleted
            System.out.println("row deleted" + row);

            ResultSet results = statement.executeQuery();

    } catch (SQLException e) {
            e.printStackTrace();
        }





        public Users findById(int id) {
        return null;

    }


}

    // don't forget to override you methods

