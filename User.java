import java.io.Serializable;
public class User implements Serializable {
	private static final long serialVersionUID = 1L; // For serialization compatibility
    private String userName;
    private String password;
    private String age;
    private String phoneNumber;
    private String email;
    private String gender;

    public User(String userName, String password, String age, String phoneNumber, String email, String gender) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
	
	public void setPassword(String password) {  // Added method to change password
        this.password = password;
		UserData.saveUser(); // Save user data immediately after password change
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
