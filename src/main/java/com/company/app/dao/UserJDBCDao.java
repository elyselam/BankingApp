package com.company.app.dao;

import com.company.Main;
import com.company.app.models.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class UserJDBCDao implements UserRepository {

    private HashMap<String, Users> map = new HashMap<>();


    @Override
    public Users getByEmail(String email) {
        // format for Simple Statement
//        String sql = "SELECT id, first_name, last_name, email, hash from USERS where email = '" + email + "'";

        // format for PreparedStatement
        String sql = "SELECT id, first_name, last_name, email, hash from USERS where email = ?";

        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
//            Statement statement = c.createStatement();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet results = statement.executeQuery();

            User u = null;
            while(results.next()){
                int id = results.getInt("id");
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String _email = results.getString("email");
                String hash = results.getString("hash");

                u = new User(id, firstName, lastName, _email, hash);
            }
            return u;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Users findById(int id) {

        return null;
    }

    @Override
    public Collection<Users> findAll() {

        String sql = "{ call get_all_users() }";

        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            CallableStatement statement = c.prepareCall(sql);

            ResultSet results = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while(results.next()){
                int id = results.getInt("id");
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String _email = results.getString("email");
                String hash = results.getString("hash");

                users.add(new User(id, firstName, lastName, _email, hash));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public int save(Users obj) {

        // check the obj for an id
        // 0 id means this object has never been persisted 'insert'
        // otherwise 'update'
        int out_id = 0;
        Connection c = null;
        if(obj.getId() == 0) {
            // never saved 'insert'
            String sql = "{ ? = call add_new_user(?, ?, ?, ?) }";

            System.out.println("Executing statement \n " + sql);
            try {
                c = Main.manager.getConnection();
                CallableStatement statement = c.prepareCall(sql);

                // register the out parameter to get the value returned from
                // the callable statement.
                // Hopefully the new id
                statement.registerOutParameter(1, Types.INTEGER);

                statement.setString(2, obj.getFirstName());
                statement.setString(3, obj.getLastName());
                statement.setString(4, obj.getEmail());
                statement.setString(5, obj.getHash());

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

}

    @Override
    public void delete(Users obj) {

    }
}

    // don't forget to override you methods

