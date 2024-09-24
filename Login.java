import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton, signUpButton;
    private static String storedUsername;
    private static String storedPassword;
    private JButton b1;

    public Login() {
        try {
            
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            
            ImageIcon backgroundImage = new ImageIcon("a.jpg");
            JLabel background = new JLabel(backgroundImage);
            background.setBounds(0, 0, 500, 400); 
            setContentPane(background); 

            
            usernameField = new JTextField(15);
            passwordField = new JPasswordField(15);
            signInButton = new JButton("Sign In");
            signUpButton = new JButton("Sign Up");

            
            usernameField.setForeground(Color.WHITE);
            passwordField.setForeground(Color.WHITE);
            usernameField.setBackground(new Color(0, 0, 0, 150)); 
            passwordField.setBackground(new Color(0, 0, 0, 150));

            
            signInButton.addActionListener(this);
            signUpButton.addActionListener(this);

            
            usernameField.setBounds(150, 100, 200, 30);
            passwordField.setBounds(150, 150, 200, 30);
            signInButton.setBounds(150, 200, 90, 30);
            signUpButton.setBounds(260, 200, 90, 30);

           
            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setForeground(Color.WHITE); 
            usernameLabel.setBounds(80, 100, 100, 30);
            background.add(usernameLabel);

            background.add(usernameField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setForeground(Color.WHITE); 
            passwordLabel.setBounds(80, 150, 100, 30);
            background.add(passwordLabel);

            background.add(passwordField);
            background.add(signInButton);
            background.add(signUpButton);
            
            b1 = new JButton("Back");
            b1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            b1.setForeground(Color.white);
            b1.setBackground(Color.green);
            b1.setBounds(100, 300, 90, 30);
            b1.addActionListener(this);
            background.add(b1);

            setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error initializing the login window: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == signInButton) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    new MainClass(); 
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials");
                }
            } else if (e.getSource() == signUpButton) {
                new Streg(); 
                dispose(); 
            } else if (e.getSource() == b1) {
                Firstpg f = new Firstpg();
                this.setVisible(false);
                f.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new Login();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error starting application: " + ex.getMessage());
        }
    }

    public static void setCredentials(String username, String password) {
        storedUsername = username;
        storedPassword = password;
    }

    public static String getStoredUsername() {
        return storedUsername;
    }

    public static String getStoredPassword() {
        return storedPassword;
    }
}
