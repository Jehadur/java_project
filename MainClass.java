import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {
    private JButton showProfileButton, changePasswordButton;
    private JButton versityToPlaceButton, placeToVersityButton;
    private JLabel coinLabel;
    private int coins = 5; // Initial coins
    private JButton b1;

    public MainClass() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        
        ImageIcon backgroundImage = new ImageIcon("l.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 400);
        setContentPane(background);

        
        showProfileButton = new JButton("Show Profile");
        changePasswordButton = new JButton("Change Password");

        
        versityToPlaceButton = new JButton("Versity to Desired Place");
        placeToVersityButton = new JButton("Current Place to Versity");

        
        coinLabel = new JLabel("Coins: " + coins);
        coinLabel.setForeground(Color.BLACK);
        coinLabel.setBounds(400, 10, 100, 30);

        
        showProfileButton.addActionListener(this);
        changePasswordButton.addActionListener(this);
        versityToPlaceButton.addActionListener(this);
        placeToVersityButton.addActionListener(this);

        
        showProfileButton.setBounds(10, 10, 150, 30);
        changePasswordButton.setBounds(170, 10, 150, 30);
        versityToPlaceButton.setBounds(100, 100, 300, 50);
        placeToVersityButton.setBounds(100, 160, 300, 50);

        
        background.add(showProfileButton);
        background.add(changePasswordButton);
        background.add(versityToPlaceButton);
        background.add(placeToVersityButton);
        background.add(coinLabel);

        b1 = new JButton("Back");
        b1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.green);
        b1.setBounds(100, 240, 90, 30);
        b1.addActionListener(this);
        background.add(b1);

        setVisible(true);
    }

    public void deductCoins(int amount) {
        coins += amount;
        coinLabel.setText("Coins: " + coins);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showProfileButton) {
            User user = UserData.getUser();
            if (user != null) {
                new Show(user);
            } else {
                JOptionPane.showMessageDialog(this, "No user data available.");
            }
        } 
		else if (e.getSource() == changePasswordButton) {
            changePassword();
        } 
		else if (e.getSource() == versityToPlaceButton || e.getSource() == placeToVersityButton) {
            new Main2(this);
            this.dispose();
        } else if (e.getSource() == b1) {
            new Login();
            this.setVisible(false);
        }
    }
	
	private void changePassword() {
        User user = UserData.getUser();
        if (user == null) {
            JOptionPane.showMessageDialog(this, "No user data available.");
            return;
        }

        String currentPassword = JOptionPane.showInputDialog(this, "Enter current password:");
        if (currentPassword != null && currentPassword.equals(user.getPassword())) {
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            if (newPassword != null && !newPassword.trim().isEmpty()) {
                user.setPassword(newPassword);  // Change the password
				 Login.setCredentials(user.getUserName(), newPassword); // Update the stored credentials
                JOptionPane.showMessageDialog(this, "Password changed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Password cannot be empty.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Current password is incorrect.");
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}

