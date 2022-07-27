
package fr.m2i.javawebapp.session;

import java.util.ArrayList;
import java.util.List;

public class userDb {
    private static List<User> users = new ArrayList(){{
       add(new User("admin@admin.com", "admin", Role.ADMIN));
       add(new User("user@user.com", "user", Role.USER)); 
    }};
    
public static User checkUser(String email, String password){
    for (User user: users){
        if(user.getEmail().contains(email) && user.getPassword().contains(password)){
            return user;
        }
    }
    return null;
}
        public List<User> getUsers(){
            return users;
        }
}
