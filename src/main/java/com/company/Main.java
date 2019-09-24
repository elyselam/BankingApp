package com.company;

import com.company.app.dao.UserJDBCDao;
import com.company.app.dao.UserRepository;
import com.company.app.models.Users;
import com.company.app.system.BankApplication;
import com.company.app.system.ConnectionManager;
import com.company.app.system.PostgresConnectionManager;
import com.company.platform.Application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Main {
    public static ConnectionManager manager;

    public static void main(String[] args) {
//        Application app = new BankApplication();
//        app.run(args);


        Properties properties = new Properties();

        try {
            String fileName = ClassLoader
                    .getSystemClassLoader().getResource("db_conn.properties")
                    .getFile();

            properties.load(new FileReader(fileName));

            manager = new PostgresConnectionManager(properties);

            UserRepository uRepo = new UserJDBCDao();
            Users u = uRepo.findByEmail("hayden@gmail.com");

            if(u != null) {
                System.out.println(u);
            } else {
                System.out.println("No user found");
            }
            System.out.println();

            u = new Users("e@gmail.com", "123", "1");
            int newId = uRepo.save(u);
            if(newId > 0) {
                u.setId(newId);
                System.out.println(u);
            }
            System.out.println();

            List<Users> users = (List<Users>) uRepo.findAll();
            for(Users user : users) {
                System.out.println(user);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
}
