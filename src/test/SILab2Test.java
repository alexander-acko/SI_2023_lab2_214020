import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
  
  @Test
    // Unit test for Every Branch 
    public void testEveryBranch() {
      // Test case 1: user is null
        User user1 = new User(null, "password", "name@email.com");
        List<User> allUsers1 = new ArrayList<>();
        SILab2.function(user1, allUsers1);
        Assertions.assertEquals("name@email.com", user1.getUsername());
      
      // Test case 2: password is null
        User user2 = new User("user", null, "name@email.com");
        List<User> allUsers2 = new ArrayList<>();
        SILab2.function(user2, allUsers2);
        Assertions.assertEquals("name@email.com", user2.getUsername());
      
      // Test case 3: email is null
        User user1 = new User("user", "password", null);
        List<User> allUsers3 = new ArrayList<>();
        SILab2.function(user3, allUsers3);
        Assertions.assertEquals("name@email.com", user3.getUsername());
      
      // Test case 4: email dosen't contain '@' or '.'
        User user4 = new User("user", "password", "name@emailcom");
        List<User> allUsers4 = new ArrayList<>();
        boolean result4 = SILab2.function(user4, allUsers4);
        Assertions.assertFalse(result4);
      
      // Test case 5: password doesn't contain special characters
        User user5 = new User("user", "pa$$word", "name@email.com");
        List<User> allUsers5 = new ArrayList<>();
        boolean result5 = SILab2.function(user5, allUsers5);
        Assertions.assertTrue(result5);

      // Test case 6: password length < 8
        User user6 = new User("user", "pass", "name@email.com");
        List<User> allUsers6 = new ArrayList<>();
        boolean result6 = SILab2.function(user6, allUsers6);
        Assertions.assertFalse(result6);

      // Test case 7: password contains username
        User user7 = new User("user", "pass_user", "name@email.com");
        List<User> allUsers7 = new ArrayList<>();
        boolean result7 = SILab2.function(user7, allUsers7);
        Assertions.assertFalse(result7);
      
      // Test case 8: password contains space " "
        User user8 = new User("user", "pass word", "name@email.com");
        List<User> allUsers8 = new ArrayList<>();
        boolean result8 = SILab2.function(user8, allUsers8);
        Assertions.assertFalse(result8);
      
      // Test case 9: email is present in allUsers
        User existingUser1 = new User("user", "passuser", "name@email.com");
        List<User> allUsers9 = new ArrayList<>();
        allUsers9.add(existingUser1);
        User user9 = new User("user", "pa$$word", "name@email.com");
        boolean result9 = SILab2.function(user9, allUsers9);
        Assertions.assertFalse(result9);
      
       // Test case 10: username is present in allUsers
        User existingUser2 = new User("user", "passuser", "name@email.com");
        List<User> allUsers10 = new ArrayList<>();
        allUsers10.add(existingUser2);
        User user10 = new User("user", "pa$$word", "name@email.com");
        boolean result10 = SILab2.function(user10, allUsers10);
        Assertions.assertFalse(result10);

    }
  
  
 @Test
    // Unit test for Multiple Condition
    public void testMultipleCondition() {
        // Test case 1: user is null, password and email any value
        User user1 = new User(null, null, null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user1, new ArrayList<>()));

        // Test case 2: User is not null, password is null, email is any value 
        User user2 = new User(null, "password", null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user2, new ArrayList<>()));

        // Test case 3: User is not null, passowrd is not null, email is null
        User user3 = new User("user", "password", null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user3, new ArrayList<>()));

        // Test case 4: user, passowrd and email are not null
        User user4 = new User("user", "password", "name@email.com");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user4, new ArrayList<>()));
    }
  
}
