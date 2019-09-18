import com.company.app.dao.DaoInterface;
import com.company.app.models.Account;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class UserDao implements DaoInterface {
    //protected AccountInfo user;
    public static final String file = "src/resources/data.txt";
    public static HashMap<String, Account> map = new HashMap();

    public static HashMap<String, Account> getData() {
        return map;
    }

    public UserDao() {
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            this.map =  (HashMap<String, Account>) fileInput.readObject();
            fileInput.close();
            System.out.println("Have been Read");
            //data.get(userName).getUserInfo();

        }
        catch(FileAlreadyExistsException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Account Read(String userName){
        try {
            ObjectInputStream fileInput = new ObjectInputStream(new FileInputStream(file));
            Object userInfo =  fileInput.readObject();
            fileInput.close();
            System.out.println("Have been Read");
            //data.get(userName).getUserInfo();
            return (Account) map.get(userName);
        }
        catch(FileAlreadyExistsException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Write(String userName, Account user){
        try {
            ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(file));
            map.put(userName, user);
            System.out.println("Have been Written");
            fileOutput.writeObject(map);
            fileOutput.close();

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

