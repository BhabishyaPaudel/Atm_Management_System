import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit, cancel;
    String pin;

    Deposit(String pin) {
        this.pin = pin;
        setVisible(true);
        setSize(900, 900);
        setLocation(300, 0);
        setTitle("Deposit Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 900, 900);

        JLabel text = new JLabel("Enter the amount to deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 400, 30);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170, 350, 320, 30);
        amount.setFont(new Font("arial", Font.BOLD, 14));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        image.add(deposit);

        cancel = new JButton("Back");
        cancel.setBounds(355, 520, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        image.add(cancel);

    }

    public static void main(String[] args) {
        new Deposit("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } else if (e.getSource() == deposit) {
            String paisa = amount.getText();
            Date date = new Date();
            if (paisa.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the amount to deposit ");
            } else {
                conn connection = new conn();
                String query = "insert into bank values('" + pin + "','" + date + "','Deposit','" + paisa + "')";
                try {
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "The amount " + paisa + "has been deposited succesfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch (SQLException e1) {

                    System.out.println(e1);
                }

            }

        }
    }

}