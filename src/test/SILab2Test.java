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
        // Test case 1: user with null username, setting username to email
        User user1 = new User(null, "password", "email@domain.com");
        List<User> allUsers1 = new ArrayList<>();
        SILab2.function(user1, allUsers1);
        Assertions.assertEquals("email@domain.com", user1.getUsername());

        // Test case 2: existing user with the same email
        User existingUser1 = new User("existingUser", "password", "existing@domain.com");
        List<User> allUsers2 = new ArrayList<>();
        allUsers2.add(existingUser1);
        User user2 = new User("username", "password", "existing@domain.com");
        boolean result1 = SILab2.function(user2, allUsers2);
        Assertions.assertFalse(result1);

        // Test case 3: existing user with the same username
        User existingUser2 = new User("username", "password", "existing2@domain.com");
        List<User> allUsers3 = new ArrayList<>();
        allUsers3.add(existingUser2);
        User user3 = new User("username", "password", "email@domain.com");
        boolean result2 = SILab2.function(user3, allUsers3);
        Assertions.assertFalse(result2);

        // Test case 4: password contains username and length < 8
        User user4 = new User("username", "password", "email@domain.com");
        List<User> allUsers4 = new ArrayList<>();
        boolean result3 = SILab2.function(user4, allUsers4);
        Assertions.assertFalse(result3);

        // Test case 5: password contains special characters and same is 0
        User user5 = new User("username", "pa$$word", "email@domain.com");
        List<User> allUsers5 = new ArrayList<>();
        boolean result4 = SILab2.function(user5, allUsers5);
        Assertions.assertTrue(result4);

        // Test case 6: password contains special characters and same is not 0
        User existingUser3 = new User("existingUser", "password", "existing3@domain.com");
        List<User> allUsers6 = new ArrayList<>();
        allUsers6.add(existingUser3);
        User user6 = new User("username", "pa$$word", "email@domain.com");
        boolean result5 = SILab2.function(user6, allUsers6);
        Assertions.assertFalse(result5);

        // Test case 7: password does not contain special characters
        User user7 = new User("username", "password", "email@domain.com");
        List<User> allUsers7 = new ArrayList<>();
        boolean result6 = SILab2.function(user7, allUsers7);
        Assertions.assertFalse(result6);

        // Test case 8: password contains special characters, same is 0
        User user8 = new User("username", "pa$$word", "email@domain.com");
        boolean result7 = SILab2.function(user8, new ArrayList<>());
        Assertions.assertFalse(result7);

        // Test case 9: password contains special characters, same is 0
        User user9 = new User("username", "pa$$word", "email@domain.com");
        List<User> allUsers8 = new ArrayList<>();
        boolean result8 = SILab2.function(user9, allUsers8);
        Assertions.assertFalse(result8);
    }
  
  
 @Test
    // Unit test for Multiple Condition
    public void testMultipleCondition() {
        // Test case 1: All conditions are true
        User user1 = new User(null, null, null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user1, new ArrayList<>()));

        // Test case 2: First condition is true, second condition is false, third condition is true
        User user2 = new User(null, "password", null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user2, new ArrayList<>()));

        // Test case 3: First condition is true, second condition is true, third condition is false
        User user3 = new User(null, null, "email");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user3, new ArrayList<>()));

        // Test case 4: First condition is true, second condition is false, third condition is false
        User user4 = new User(null, "password", "email");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user4, new ArrayList<>()));

        // Test case 5: First condition is false, second condition is true, third condition is true
        User user5 = new User("username", null, null);
        List<User> allUsers = new ArrayList<>();
        boolean result1 = SILab2.function(user5, allUsers);
        Assertions.assertFalse(result1);

        // Test case 6: First condition is false, second condition is false, third condition is true
        User user6 = new User("username", "password", null);
        boolean result2 = SILab2.function(user6, allUsers);
        Assertions.assertFalse(result2);

        // Test case 7: First condition is false, second condition is true, third condition is false
        User user7 = new User("username", null, "email");
        boolean result3 = SILab2.function(user7, allUsers);
        Assertions.assertFalse(result3);

        // Test case 8: First condition is false, second condition is false, third condition is false
        User user8 = new User("username", "password", "email");
        boolean result4 = SILab2.function(user8, allUsers);
        Assertions.assertFalse(result4);
    }
  
}
