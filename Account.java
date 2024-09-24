import java.util.HashMap;
import java.util.Map;

public class Account {
    private static Map<String, Account> accounts = new HashMap<>();
    
    private String username;
    private String password;
    private String age;
    private String gender;
    private String number;
    private String email;

    public Account(String username, String password, String age, String gender, String number, String email) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.number = number;
        this.email = email;
    }

    public static boolean addAccount(String username, String password, String age, String gender, String number, String email) {
        if (accounts.containsKey(username)) {
            return false; 
        }
        accounts.put(username, new Account(username, password, age, gender, number, email));
        return true;
    }

    public static Account getAccount(String username) {
        return accounts.get(username);
    }

    public boolean checkAccount(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }
}
