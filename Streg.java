import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

abstract class RegistrationHandler {
    public abstract void register(User user);
}

class DefaultRegistrationHandler extends RegistrationHandler {
    public void register(User user) {
        System.out.println("Registered user: " + user.getUserName());
        Login.setCredentials(user.getUserName(), user.getPassword());
    }
}

public class Streg extends JFrame implements ActionListener {
    private JTextField userName, age, num, email;
    private JPasswordField pf, cpf;
    private JRadioButton r1, r2;
    private JButton signup, back;
    private RegistrationHandler registrationHandler;

    public Streg() {
        registrationHandler = new DefaultRegistrationHandler();
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("a.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 400);
        setContentPane(background);

        userName = new JTextField(15);
        pf = new JPasswordField(15);
        cpf = new JPasswordField(15);
        age = new JTextField(15);
        num = new JTextField(15);
        email = new JTextField(15);
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        signup = new JButton("Sign Up");
        back = new JButton("Back");

        setComponentStyles();
        signup.addActionListener(this);
        back.addActionListener(this);
        setComponentBounds(background);
        setVisible(true);
    }

    private void setComponentStyles() {
        Color transparentBlack = new Color(0, 0, 0, 0.5f);
        userName.setForeground(Color.WHITE);
        pf.setForeground(Color.WHITE);
        cpf.setForeground(Color.WHITE);
        age.setForeground(Color.WHITE);
        num.setForeground(Color.WHITE);
        email.setForeground(Color.WHITE);

        userName.setBackground(transparentBlack);
        pf.setBackground(transparentBlack);
        cpf.setBackground(transparentBlack);
        age.setBackground(transparentBlack);
        num.setBackground(transparentBlack);
        email.setBackground(transparentBlack);
    }

    private void setComponentBounds(JLabel background) {
        int labelX = 80, fieldX = 150, ySpacing = 40;
        int yStart = 50;

        userName.setBounds(fieldX, yStart, 200, 30);
        pf.setBounds(fieldX, yStart + ySpacing, 200, 30);
        cpf.setBounds(fieldX, yStart + 2 * ySpacing, 200, 30);
        age.setBounds(fieldX, yStart + 3 * ySpacing, 200, 30);
        num.setBounds(fieldX, yStart + 4 * ySpacing, 200, 30);
        email.setBounds(fieldX, yStart + 5 * ySpacing, 200, 30);
        r1.setBounds(fieldX, yStart + 6 * ySpacing, 90, 30);
        r2.setBounds(fieldX + 100, yStart + 6 * ySpacing, 90, 30);
        signup.setBounds(fieldX, yStart + 7 * ySpacing, 90, 30);
        back.setBounds(fieldX + 100, yStart + 7 * ySpacing, 90, 30);

        
        addLabelAndField(background, "Username:", userName, yStart);
        addLabelAndField(background, "Password:", pf, yStart + ySpacing);
        addLabelAndField(background, "C.Password:", cpf, yStart + 2 * ySpacing);
        addLabelAndField(background, "Age:", age, yStart + 3 * ySpacing);
        addLabelAndField(background, "Number:", num, yStart + 4 * ySpacing);
        addLabelAndField(background, "Email:", email, yStart + 5 * ySpacing);

        
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.WHITE);
        background.add(genderLabel).setBounds(labelX, yStart + 6 * ySpacing, 100, 30);
        background.add(r1);
        background.add(r2);
        background.add(signup);
        background.add(back);
    }

    private void addLabelAndField(JLabel background, String labelText, JComponent field, int yPosition) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.WHITE);
        background.add(label).setBounds(80, yPosition, 100, 30);
        background.add(field);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            String s1 = userName.getText();
            String s2 = new String(pf.getPassword());
            String s3 = new String(cpf.getPassword());
            String s4 = age.getText();
            String s5 = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null;
            String s6 = num.getText();
            String s7 = email.getText();

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5 == null || s6.isEmpty() || s7.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
            } else if (!s2.equals(s3)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            } else {
                User user = new User(s1, s2, s4, s6, s7, s5);
                registrationHandler.register(user);
                UserData.setUser(user);

               // Call the method to save user details to file
               saveUserDetailsToFile(user);

                JOptionPane.showMessageDialog(this, "Sign up successful! You can now log in.");
                new Login();
                dispose();
            }
        } else if (e.getSource() == back) {
            new Login();
            dispose();
        }
    }
private void saveUserDetailsToFile(User user) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("registration_details.txt", true))) {
        writer.write("Username: " + user.getUserName());
        writer.write(", Password: " + user.getPassword());
        writer.write(", Age: " + user.getAge());
        writer.write(", Number: " + user.getPhoneNumber());
        writer.write(", Email: " + user.getEmail());
        writer.write(", Gender: " + user.getGender());
        writer.newLine();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error saving user details: " + e.getMessage());
        e.printStackTrace(); // Print the stack trace for debugging
    }
}

}
