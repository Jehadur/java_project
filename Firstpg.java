import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Firstpg extends JFrame implements ActionListener {

    JButton studentButton, driverButton;
	private JButton b1;

    public Firstpg() {
       
        setTitle("Firstpg");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

       
        ImageIcon backgroundImage = new ImageIcon("a.jpg"); 
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 500, 400); 
        setContentPane(background); 

       
        ImageIcon studentIcon = new ImageIcon("dd.jpg"); 
        ImageIcon driverIcon = new ImageIcon("d.jpg"); 

        studentButton = new JButton("Student", studentIcon);
        driverButton = new JButton("Driver", driverIcon);

        
        studentButton.setBounds(50, 100, 180, 180); 
        studentButton.setFont(new Font("Serif", Font.BOLD, 20)); 
        studentButton.setForeground(Color.CYAN); 
        studentButton.setVerticalTextPosition(SwingConstants.CENTER);
        studentButton.setHorizontalTextPosition(SwingConstants.CENTER);

        driverButton.setBounds(270, 100, 180, 180); 
        driverButton.setFont(new Font("Serif", Font.BOLD, 20)); 
        driverButton.setForeground(Color.CYAN); 
        driverButton.setVerticalTextPosition(SwingConstants.CENTER);
        driverButton.setHorizontalTextPosition(SwingConstants.CENTER);

        studentButton.addActionListener(this);
        driverButton.addActionListener(this);

       
        background.add(studentButton);
        background.add(driverButton);

       
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == studentButton) {
            
            new Login().setVisible(true);
        } else if (e.getSource() == driverButton) {
            
            new Soon().setVisible(true);
        }
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Firstpg();
            }
        });
    }
}
