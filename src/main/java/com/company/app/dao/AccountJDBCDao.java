package com.company.app.dao;

import com.company.Main;
import com.company.app.models.Account;
import com.company.app.models.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class AccountJDBCDao implements AccountRepository{

    public Account getByEmail(String email) {
        String sql = "SELECT email, balance, id from account_table where email = ?";
        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet results = statement.executeQuery();
            Account u = null;
            while(results.next()){
                Double balance = results.getDouble("balance");
                int id = results.getInt("id");
                u = new Account (_email, balance, id);
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    //find all transactions within this account
    public Collection<Account> findAll() {
        String sql = "{ call get_transactions() }";
        System.out.println("Executing statement \n " + sql);
        try {
            Connection c = Main.manager.getConnection();
            CallableStatement statement = c.prepareCall(sql);

            ResultSet results = statement.executeQuery();

            List<Users> transactions = new ArrayList<>();
            while(results.next()){
                String email = results.getString("email");
                Double balance = results.getDouble("balance");
                Integer id = results.getInt("id");

                transactions.add(new Users(email, balance, id));
            }
            return transactions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public int save(Account obj) {
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


    public void delete(Account obj) {

    }
}



//    //<id, {email, password, balance}
//    HashMap<Integer, Account> map = new HashMap<>();
//
//    public Account getAccount(int id) {
//        return map.get(id);
//    }
//
//    //get balance by keying on id
//    public double viewBalance(Account acct) {
//        return acct.getBalance();
//    }
//
//
//    public int createNewAccount() {
//        Account account = new Account();
//        //id is integer
//        map.put(account.getId(), account);
//        //email, {id, balance}
//        return account.getId();
//    }
//
//
