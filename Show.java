import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Show extends JFrame implements ActionListener 
{
	private JButton b1;
    public Show(User user) {
        
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        
        ImageIcon backgroundImage = new ImageIcon("a.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 400); 
        setContentPane(background); 

        
        JLabel usernameLabel = new JLabel("Username: " + user.getUserName());
        JLabel passwordLabel = new JLabel("Password: " + user.getPassword());
        JLabel ageLabel = new JLabel("Age: " + user.getAge());
        JLabel phoneNumberLabel = new JLabel("Phone Number: " + user.getPhoneNumber());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JLabel genderLabel = new JLabel("Gender: " + user.getGender());

        
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        ageLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        genderLabel.setForeground(Color.WHITE);

        
        usernameLabel.setBounds(50, 50, 400, 30);
        passwordLabel.setBounds(50, 90, 400, 30);
        ageLabel.setBounds(50, 130, 400, 30);
        phoneNumberLabel.setBounds(50, 170, 400, 30);
        emailLabel.setBounds(50, 210, 400, 30);
        genderLabel.setBounds(50, 250, 400, 30);

        
        background.add(usernameLabel);
        background.add(passwordLabel);
        background.add(ageLabel);
        background.add(phoneNumberLabel);
        background.add(emailLabel);
        background.add(genderLabel);
		
		b1 = new JButton("Back");
		b1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		b1.setForeground(Color.white);
		b1.setBackground(Color.green);
		b1.setBounds(100, 300, 90, 30);
		b1.addActionListener(this);
		background.add(b1);

        setVisible(true);
    }
	public void actionPerformed(ActionEvent ae)
	{ 	
		if (ae.getSource() == b1) 
		 {
           
            new MainClass();
            dispose();
         }
		
	}
}
