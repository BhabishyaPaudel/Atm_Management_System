
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    JButton FCash, MSt, Withdrawl, Deposit, Pinchange, BalEn, Exit;
    private String pin;

    Transactions(String pin) {
        this.pin = pin;
        System.out.println(pin);

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

        JLabel info = new JLabel("Please Select Transactions");
        info.setFont(new Font("Raleway", Font.BOLD, 22));
        info.setBounds(220, 350, 300, 30);
        info.setForeground(Color.WHITE);
        image.add(info);

        Deposit = new JButton("Deposit ");
        Deposit.setBounds(170, 415, 150, 30);
        Deposit.setBackground(Color.BLACK);
        Deposit.setForeground(Color.white);
        Deposit.addActionListener(this);
        image.add(Deposit);

        Withdrawl = new JButton("Withdrawl");
        Withdrawl.setBounds(355, 415, 150, 30);
        Withdrawl.setBackground(Color.BLACK);
        Withdrawl.setForeground(Color.white);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);

        FCash = new JButton("Fast Cash");
        FCash.setBounds(170, 450, 150, 30);
        FCash.setBackground(Color.BLACK);
        FCash.setForeground(Color.white);
        FCash.addActionListener(this);
        image.add(FCash);

        MSt = new JButton("Mini Statement");
        MSt.setBounds(355, 450, 150, 30);
        MSt.setBackground(Color.BLACK);
        MSt.setForeground(Color.white);
        MSt.addActionListener(this);
        image.add(MSt);

        Pinchange = new JButton("Pinchange");
        Pinchange.setBounds(170, 485, 150, 30);
        Pinchange.setBackground(Color.BLACK);
        Pinchange.setForeground(Color.white);
        Pinchange.addActionListener(this);
        image.add(Pinchange);

        BalEn = new JButton("Balance Enquiry");
        BalEn.setBounds(355, 485, 150, 30);
        BalEn.setBackground(Color.BLACK);
        BalEn.setForeground(Color.white);
        BalEn.addActionListener(this);
        image.add(BalEn);

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
            System.exit(0);
        } else if (ae.getSource() == Deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);

        } else if (ae.getSource() == Withdrawl) {
            setVisible(false);
            new Withdraw(pin).setVisible(true);

        } else if (ae.getSource() == FCash) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
            System.out.println(pin);
        } else if (ae.getSource() == Pinchange) {
            setVisible(false);
            new PinChange(pin).setVisible(true);
            System.out.println(pin);
        } else if (ae.getSource() == BalEn) {
            setVisible(false);
            new BalanceEnq(pin).setVisible(true);
            System.out.println(pin);
        } else if (ae.getSource() == MSt) {
         
            new ministatement(pin).setVisible(true);
            System.out.println(pin);
        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }

}
