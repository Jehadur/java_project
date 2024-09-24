import java.io.*;

public class UserData {
    private static User currentUser;

    public static void setUser(User user) {
        currentUser = user;
        saveUser(); // Save user whenever the currentUser is set
    }

    public static User getUser() {
        if (currentUser == null) {
            loadUser();  // Load user data from file
        }
        return currentUser;
    }

    public static void saveUser() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            oos.writeObject(currentUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUser() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            currentUser = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
