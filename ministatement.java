import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;

public class ministatement extends JFrame {
    JTextField amount;
    JButton cardtatement, cancel;
    String pin;

    ministatement(String pin) {
        this.pin = pin;
        setVisible(true);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setTitle("ministatement Frame");
        setLayout(null);

        JLabel text = new JLabel("Future Bank");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(150, 20, 100, 20);

        add(text);

        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.BOLD, 16));
        card.setBounds(20, 80, 300, 20);
        add(card);
        JLabel mini = new JLabel();
        mini.setFont(new Font("System", Font.BOLD, 12));
        mini.setBounds(20, 140, 400, 200);

        add(mini);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from LoginDetails where pin = '" + pin + "'");
            System.out.println(pin);
            //
            while (rs.next()) {
                card.setText("Card Number:" + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {

            conn cn = new conn();
            ResultSet rs = cn.s.executeQuery("select * from bank where pin ='" + pin + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>"+rs.getString("date") + "      " +
                        rs.getString("type") + "      " +
                        rs.getString("amount")+ "<br>");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new ministatement(" ").setVisible(true);
    }
}