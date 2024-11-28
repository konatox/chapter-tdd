import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class UserManager {

    private Map<String, String> users = new HashMap<>();

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public List<String> getUsers() {
        return new ArrayList<>(users.keySet());
    }

    public void deleteUser(String username) {
        users.remove(username);
    }
}
