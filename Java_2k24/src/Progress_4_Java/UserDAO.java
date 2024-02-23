package Progress_4_Java;

public interface UserDAO {
    void addUser(User user);
    User getUser(String username);
    void updateUser(User user);
    void deleteUser(String username);
    User login(String username, String password);
}