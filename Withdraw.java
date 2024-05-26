
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton Withdraw, cancel;
    String pin;

    Withdraw(String pin) {
        this.pin=pin;
        setVisible(true);
        setSize(900, 900);
        setLocation(300, 0);
        setTitle("Withdraw Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 900, 900);

        JLabel text = new JLabel("Enter the amount to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 400, 30);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 320, 30);
        amount.setFont(new Font("arial", Font.BOLD, 14));
        image.add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355, 485, 150, 30);
        Withdraw.setBackground(Color.BLACK);
        Withdraw.setForeground(Color.white);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        cancel = new JButton("Back");
        cancel.setBounds(355, 520, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        image.add(cancel);

    }

    public static void main(String[] args) {
        new Withdraw("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } else if (e.getSource() == Withdraw) {
            String paisa = amount.getText();
            Date date = new Date();
            if (paisa.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the amount to Withdraw ");
            } else {
                conn connection = new conn();
                String query = "insert into bank values('" + pin + "','" + date + "','Withdraw','" + paisa + "')";
                try {
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "The amount " + paisa + "has been Withdraw succesfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (SQLException e1) {

                    System.out.println(e1);
                }

            }

        }
    }

}
