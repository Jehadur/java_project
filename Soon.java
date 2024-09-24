import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Soon extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JPanel p1;
	JButton b1;
	
	    public Soon() 
		{
        super("Soon");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		
		
		p1 = new JPanel();
		p1.setSize(new Dimension(500,280));
		p1.setBackground(Color.black);
		p1.setLayout(null);
		
	    l1 = new JLabel("Coming Soon");
		l1.setFont(new Font("Serif",Font.BOLD,20));   
		l1.setForeground(Color.BLUE);
		l1.setBounds(180,150,150,30);   
		p1.add(l1);
		
		l2 = new JLabel("Back");
		l2.setFont(new Font("Serif",Font.BOLD,20));   
		l2.setForeground(Color.BLUE);
		l2.setBounds(180,200,150,30);   
		p1.add(l2);
		
		b1 = new JButton("Back");
		b1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		b1.setForeground(Color.white);
		b1.setBackground(Color.green);
		b1.setBounds(180,200,100,30);
		b1.addActionListener(this);
		p1.add(b1);
		
		this.add(p1);
}	
		public void actionPerformed(ActionEvent ae) 
		{
        if (ae.getSource() == b1) 
		 {
           
            new Firstpg();
            dispose();
         }
       }
		
		
			
		}
	