import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

//1350931338507980 4266
public class Login extends JFrame implements ActionListener {
    JButton sign, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);
        setTitle("ATM SIMULATOR");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        label.setBounds(70, 10, 100, 100);

        JLabel text = new JLabel("Welcome to Future ATMS");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 40);
        add(text);

        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Railway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 500, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway", Font.BOLD, 28));
        pin.setBounds(120, 220, 500, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("arial", Font.BOLD, 14));
        add(pinTextField);

        sign = new JButton("Sign IN");
        sign.setBounds(330, 290, 80, 30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);

        clear = new JButton("Clear");
        clear.setBounds(430, 290, 80, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign UP");
        signup.setBounds(300, 330, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == sign) {
            conn connection = new conn();
            String cardnumber = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from LoginDetails where cardnumber='" + cardnumber + "' and pin='" + pin + "'";

            try {
                ResultSet rs = connection.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                    System.out.println(pin);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup1().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Login();
    }

}