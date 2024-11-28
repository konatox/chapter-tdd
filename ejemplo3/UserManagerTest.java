import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testRegisterUser() {
        userManager.registerUser("john_doe", "password123");
        assertEquals(1, userManager.getUsers().size());
    }

    @Test
    public void testAuthenticateUser() {
        userManager.registerUser("john_doe", "password123");
        assertTrue(userManager.authenticateUser("john_doe", "password123"));
        assertFalse(userManager.authenticateUser("john_doe", "wrongpassword"));
    }

    @Test
    public void testGetUsers() {
        userManager.registerUser("john_doe", "password123");
        userManager.registerUser("jane_doe", "password456");
        List<String> users = userManager.getUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains("john_doe"));
        assertTrue(users.contains("jane_doe"));
    }

    @Test
    public void testDeleteUser() {
        userManager.registerUser("john_doe", "password123");
        userManager.deleteUser("john_doe");
        assertEquals(0, userManager.getUsers().size());
    }
}
