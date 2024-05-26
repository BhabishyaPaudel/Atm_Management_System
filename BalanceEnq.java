import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.print.DocFlavor.STRING;
import javax.swing.*;

public class BalanceEnq extends JFrame implements ActionListener {
    JButton cancel;
    String pin;

    BalanceEnq(String pin) {
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

        cancel = new JButton("Back");
        cancel.setBounds(355, 520, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        image.add(cancel);

        conn c = new conn();
        int balance = 0;

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pin + "'");

            while (rs.next()) {

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current account balance is" + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setBounds(170, 300, 400, 30);
        image.add(text);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnq("");
    }
}
