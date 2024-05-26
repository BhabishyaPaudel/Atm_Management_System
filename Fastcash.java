
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

public class Fastcash extends JFrame implements ActionListener {
    JButton thou, twothou, fivehun, hundred, fivethou, tenthou, Exit;
    String pin;

    Fastcash(String pin) {
        pin = this.pin;

        setSize(900, 900);
        setVisible(true);
        setLayout(null);
        setLocation(300, 0);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(0, 0, 900, 900);

        JLabel info = new JLabel("Please Select Fastcash");
        info.setFont(new Font("Raleway", Font.BOLD, 22));
        info.setBounds(220, 350, 300, 30);
        info.setForeground(Color.WHITE);
        image.add(info);

        hundred = new JButton("Rs 100 ");
        hundred.setBounds(170, 415, 150, 30);
        hundred.setBackground(Color.BLACK);
        hundred.setForeground(Color.white);
        hundred.addActionListener(this);
        image.add(hundred);

        fivehun = new JButton("Rs 500");
        fivehun.setBounds(355, 415, 150, 30);
        fivehun.setBackground(Color.BLACK);
        fivehun.setForeground(Color.white);
        fivehun.addActionListener(this);
        image.add(fivehun);

        thou = new JButton("Rs 1000");
        thou.setBounds(170, 450, 150, 30);
        thou.setBackground(Color.BLACK);
        thou.setForeground(Color.white);
        thou.addActionListener(this);
        image.add(thou);

        twothou = new JButton("Rs 2000");
        twothou.setBounds(355, 450, 150, 30);
        twothou.setBackground(Color.BLACK);
        twothou.setForeground(Color.white);
        twothou.addActionListener(this);
        image.add(twothou);

        fivethou = new JButton("Rs 5000");
        fivethou.setBounds(170, 485, 150, 30);
        fivethou.setBackground(Color.BLACK);
        fivethou.setForeground(Color.white);
        fivethou.addActionListener(this);
        image.add(fivethou);

        tenthou = new JButton("Rs 10000");
        tenthou.setBounds(355, 485, 150, 30);
        tenthou.setBackground(Color.BLACK);
        tenthou.setForeground(Color.white);
        tenthou.addActionListener(this);
        image.add(tenthou);

        Exit = new JButton("Exit");
        Exit.setBounds(355, 520, 150, 30);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.white);
        Exit.addActionListener(this);
        image.add(Exit);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Exit) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            String paisa = (((JButton) ae.getSource()).getText().substring(3));
            System.out.println(paisa);

            conn c = new conn();

            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pin + "'");
                int balance = 0;
                while (rs.next()) {

                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));

                    }

                }
                if (ae.getSource() != Exit && balance < Integer.parseInt(paisa)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                if (ae.getSource() == Exit) {
                    this.setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    Date date = new Date();
                    c.s.executeUpdate("INSERT INTO bank (pin, date, type, amount) VALUES ('" + pin + "', '" + date
                            + "', 'Withdrawl', '" + paisa + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + paisa + " Debited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                    // System.out.println("chalyo muji");
                    // Date date = new Date();
                    // String query1 = "INSERT INTO bank VALUES ('" + pin + "', '" + date+ "',
                    // 'Withdrawl', '" + paisa + "')";

                    // c.s.executeUpdate(query1);
                    // JOptionPane.showMessageDialog(null, "The paisa " + paisa + "has been
                    // debited succesfully");
                    // setVisible(false);
                    // new Transactions(pin).setVisible(true);

                }
            } catch (SQLException e1) {

                System.out.println(e1);
            }

        }

    }

    public static void main(String[] args) {
        new Fastcash("");
    }

}
