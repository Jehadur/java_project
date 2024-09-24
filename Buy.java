import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Buy extends JFrame implements ActionListener {
    private MainClass mainClass;  
    private JLabel distanceLabel, costLabel, paymentLabel, paymentMethodLabel;
    private JTextField paymentNumberField;
    private JRadioButton bikashOption, nagadOption;
    private JButton bookNowButton, cancelButton, backButton;
    private ButtonGroup paymentMethodGroup;
    private JFrame previousFrame;
    private Timer cancelTimer;
    private boolean bookingConfirmed = false; 

    public Buy(String destination, int distance, int cost, JFrame previousFrame, MainClass mainClass) {
        this.mainClass = mainClass;  
        this.previousFrame = previousFrame;  

        
        setTitle("Booking Payment");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        
        distanceLabel = new JLabel("Destination: " + destination + " (" + distance + " kilometers)");
        costLabel = new JLabel("Cost: " + cost + " TK");
        distanceLabel.setBounds(50, 20, 300, 30);
        costLabel.setBounds(50, 60, 200, 30);

       
        paymentMethodLabel = new JLabel("Select Payment Method:");
        paymentMethodLabel.setBounds(50, 100, 200, 30);
        bikashOption = new JRadioButton("Bikash");
        nagadOption = new JRadioButton("Nagad");
        bikashOption.setBounds(50, 130, 100, 30);
        nagadOption.setBounds(150, 130, 100, 30);

        
        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(bikashOption);
        paymentMethodGroup.add(nagadOption);

        
        paymentLabel = new JLabel("Enter Payment Number:");
        paymentLabel.setBounds(50, 170, 200, 30);
        paymentNumberField = new JTextField(15);
        paymentNumberField.setBounds(50, 200, 200, 30);

        
        bookNowButton = new JButton("Book Now");
        bookNowButton.setBounds(50, 240, 100, 30);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(160, 240, 100, 30);
        backButton = new JButton("Back");
        backButton.setBounds(270, 240, 100, 30);

        
        bookNowButton.addActionListener(this);
        cancelButton.addActionListener(this);
        backButton.addActionListener(this);

        
        add(distanceLabel);
        add(costLabel);
        add(paymentMethodLabel);
        add(bikashOption);
        add(nagadOption);
        add(paymentLabel);
        add(paymentNumberField);
        add(bookNowButton);
        add(cancelButton);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookNowButton) {
            String selectedPaymentMethod = bikashOption.isSelected() ? "Bikash" : "Nagad";
            String paymentNumber = paymentNumberField.getText();
            if (paymentNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a payment number.");
            } else {
                bookingConfirmed = true; 
                String ticketDetails = "Ticket Details:\n"
                        + "Destination: " + distanceLabel.getText().split(": ")[1].split(" \\(")[0] + "\n"
                        + "Distance: " + distanceLabel.getText().replaceAll(".*\\((\\d+) kilometers\\).*", "$1") + " kilometers\n"   //(\\d+) captures one or more digits (the distance value) and stores it in a group.
                                                                                                                                      //.* matches any sequence of characters (including none or many).
                                                                                                                                      //"$1" refers to the first captured group (i.e., the distance value).
                        + "Cost: " + costLabel.getText().split(": ")[1] + "\n"
                        + "Payment Method: " + selectedPaymentMethod + "\n"
                        + "Payment Number: " + paymentNumber;

               
                new BookingDetails(ticketDetails, mainClass, this);

                
                cancelTimer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (bookingConfirmed) {
                            mainClass.deductCoins(10);  
                            cancelTimer.stop(); 
                        }
                    }
                });
                cancelTimer.setRepeats(false); 
                cancelTimer.start(); 
            }
        } else if (e.getSource() == cancelButton) {
            if (bookingConfirmed) {
                
                bookingConfirmed = false; 
                if (cancelTimer != null && cancelTimer.isRunning()) {
                    cancelTimer.stop(); 
                }
                JOptionPane.showMessageDialog(this, "Booking canceled successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No active booking to cancel.");
            }
        } else if (e.getSource() == backButton) {
            this.dispose();  
            previousFrame.setVisible(true); 
        }
    }

    public static void main(String[] args) {
        
        new Buy("UTTARA", 10, 10, new JFrame(), new MainClass());  
    }
}
