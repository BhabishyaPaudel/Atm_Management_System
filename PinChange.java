import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    JTextField pinholder, newpinholder;
    JButton PinChange, cancel;
    String pin;

    PinChange(String pin) {
        this.pin = pin;
        System.out.println(pin);
        if (pin == null) {
            return;
        }
        setVisible(true);
        setSize(900, 900);
        setLocation(300, 0);
        setTitle("PinChange Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 900, 900);

        JLabel text = new JLabel("Pinchange Window ");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 400, 30);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel Cpin = new JLabel("New Pin: ");
        Cpin.setFont(new Font("Raleway", Font.BOLD, 18));
        Cpin.setBounds(200, 350, 160, 30);
        Cpin.setForeground(Color.WHITE);
        image.add(Cpin);

        pinholder = new JTextField();
        pinholder.setBounds(330, 350, 180, 30);
        pinholder.setFont(new Font("arial", Font.BOLD, 14));
        image.add(pinholder);

        JLabel Newpin = new JLabel(" Reinter New Pin :");
        Newpin.setFont(new Font("Raleway", Font.BOLD, 18));
        Newpin.setBounds(160, 390, 160, 30);
        Newpin.setForeground(Color.WHITE);
        image.add(Newpin);

        newpinholder = new JTextField();
        newpinholder.setBounds(330, 390, 180, 30);
        newpinholder.setFont(new Font("arial", Font.BOLD, 14));
        image.add(newpinholder);

        PinChange = new JButton("PinChange");
        PinChange.setBounds(355, 485, 150, 30);
        PinChange.setBackground(Color.BLACK);
        PinChange.setForeground(Color.white);
        PinChange.addActionListener(this);
        image.add(PinChange);

        cancel = new JButton("Back");
        cancel.setBounds(355, 520, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        image.add(cancel);

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
        ;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } else if (e.getSource() == PinChange) {
            String newpinn = pinholder.getText();
            String renewpin = newpinholder.getText();
            Date date = new Date();

            if (!newpinn.equals(renewpin)) {
                JOptionPane.showMessageDialog(null, "Pin not matched ");
                return;

            }
            if (newpinn.equals("")) {
                JOptionPane.showMessageDialog(null, "Cant update a null pin ");
                return;

            }
            if (renewpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Cant update a null pin ");
                return;
            }

            conn connection = new conn();
            String query1 = "update  bank  set pin ='" + renewpin + "' where pin='" + pin + "'";
            System.out.println(query1);
            String query2 = "update  LoginDetails  set pin ='" + renewpin + "' where pin='" + pin + "'";
            System.out.println(query2);
            String query3 = "update  signupthree  set PIN_NO  ='" + renewpin + "' where PIN_NO='" + pin + "'";
            System.out.println(query3);
            try {
                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);
                connection.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "The pin has been changed succesfully");
                setVisible(false);
                new Transactions(renewpin).setVisible(true);
            } catch (SQLException e1) {

                System.out.println(e1);
            }

        }

    }
}
