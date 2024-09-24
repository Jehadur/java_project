import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingDetails extends JFrame {
    public BookingDetails(String ticketDetails, MainClass mainClass, JFrame previousFrame) {
        
        setTitle("Booking Confirmation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JTextArea detailsArea = new JTextArea();
        detailsArea.setText(ticketDetails);
        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);

      
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        add(scrollPane, BorderLayout.CENTER);

      
        JButton confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment Successful!");
            mainClass.deductCoins(10);  
            dispose();  
        });
        
       
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose(); 
            previousFrame.setVisible(true); 
        });

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmPaymentButton);
        buttonPanel.add(backButton);
        
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

