import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main2 extends JFrame implements ActionListener {
    private MainClass mainClass;  
	private JButton uttaraButton, farmgateButton, airportButton, bananiButton, backButton;
    private JLabel comingSoonLabel;
	


    public Main2(MainClass mainClass) {
		this.mainClass = mainClass;  
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        
        ImageIcon backgroundImage = new ImageIcon("l.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 400);
        setContentPane(background);

        
        uttaraButton = new JButton("UTTARA");
        farmgateButton = new JButton("FARMGATE");
        airportButton = new JButton("AIRPORT");
        bananiButton = new JButton("BANANI");

        
        backButton = new JButton("Back");
        backButton.setBounds(200, 320, 100, 30);
		backButton.setForeground(Color.white);
		backButton.setBackground(Color.green);
        backButton.addActionListener(this);

       
        comingSoonLabel = new JLabel("More coming soon...");
        comingSoonLabel.setForeground(Color.black);
        comingSoonLabel.setFont(new Font("Arial", Font.ITALIC, 14));

        
        uttaraButton.setBounds(100, 50, 300, 50);
        farmgateButton.setBounds(100, 120, 300, 50);
        airportButton.setBounds(100, 190, 300, 50);
        bananiButton.setBounds(100, 260, 300, 50);

       
        comingSoonLabel.setBounds(180, 350, 200, 30);
				
		

        
        uttaraButton.addActionListener(this);
        farmgateButton.addActionListener(this);
        airportButton.addActionListener(this);
        bananiButton.addActionListener(this);

        
        background.add(uttaraButton);
        background.add(farmgateButton);
        background.add(airportButton);
        background.add(bananiButton);
        background.add(comingSoonLabel);
        background.add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uttaraButton) {
            new Buy("UTTARA", 10, 10, this, mainClass); 
        } else if (e.getSource() == farmgateButton) {
            new Buy("FARMGATE", 12, 15, this, mainClass); 
        } else if (e.getSource() == airportButton) {
            new Buy("AIRPORT", 7, 10, this, mainClass); 
        } else if (e.getSource() == bananiButton) {
            new Buy("BANANI", 9, 12, this, mainClass); 
        } else if (e.getSource() == backButton) {
            this.dispose();  
            mainClass.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Main2(new MainClass());
    }
}
