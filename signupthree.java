import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupthree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7, c8;
    JButton submit, cancel;
    String formno;

    signupthree(String formno) {
        // Creating random obj
        this.formno = formno;

        setLayout(null);
        setSize(800, 680);
        setVisible(true);
        setLocation(350, 10);
        setTitle("ACCOUNT DETAILS ");
        JLabel pagedata = new JLabel("PAGE 3 : ACCOUNT DETAILS ");
        pagedata.setFont(new Font("Raleway", Font.BOLD, 32));
        pagedata.setBounds(180, 20, 600, 40);
        add(pagedata);

        JLabel AccType = new JLabel(" ACCOUNT TYPE :");
        AccType.setFont(new Font("Raleway", Font.BOLD, 18));
        AccType.setBounds(130, 100, 200, 40);
        add(AccType);

        r1 = new JRadioButton("Savings ");
        r1.setBounds(330, 100, 100, 30);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r1);

        r2 = new JRadioButton("Current ");
        r2.setBounds(430, 100, 100, 30);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r2);

        r3 = new JRadioButton("Fixed");
        r3.setBounds(530, 100, 100, 30);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r3);

        r4 = new JRadioButton("Minor");
        r4.setBounds(630, 100, 100, 30);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        add(r4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JLabel Cardno = new JLabel("CARD NO: ");
        Cardno.setFont(new Font("Raleway", Font.BOLD, 18));
        Cardno.setBounds(180, 150, 200, 40);
        add(Cardno);

        JLabel CardnoS = new JLabel("Ex: XXXX-XXXX-XXXX-3125 ");
        CardnoS.setFont(new Font("Raleway", Font.BOLD, 18));
        CardnoS.setBounds(350, 150, 500, 40);
        add(CardnoS);

        JLabel PIN = new JLabel("PIN NO: ");
        PIN.setFont(new Font("Raleway", Font.BOLD, 18));
        PIN.setBounds(190, 200, 200, 40);
        add(PIN);

        JLabel PINNO = new JLabel("Ex: XXXX");
        PINNO.setFont(new Font("Raleway", Font.BOLD, 18));
        PINNO.setBounds(350, 200, 500, 40);
        add(PINNO);

        JLabel services = new JLabel(" Services:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(190, 250, 150, 40);
        add(services);

        c1 = new JCheckBox("Atm");
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(350, 250, 100, 40);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 18));
        c2.setBounds(500, 250, 300, 40);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 18));
        c3.setBounds(350, 300, 170, 40);
        add(c3);

        c4 = new JCheckBox("Cheque");
        c4.setFont(new Font("Raleway", Font.BOLD, 18));
        c4.setBounds(520, 300, 200, 40);
        add(c4);

        c5 = new JCheckBox("E-statement");
        c5.setFont(new Font("Raleway", Font.BOLD, 18));
        c5.setBounds(350, 350, 150, 40);
        add(c5);

        c6 = new JCheckBox("Dollar Card");
        c6.setFont(new Font("Raleway", Font.BOLD, 18));
        c6.setBounds(520, 350, 200, 40);
        add(c6);

        c7 = new JCheckBox("I hereby declare that all the informations are correct ");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(180, 450, 1200, 20);
        add(c7);

        c8 = new JCheckBox("I agree Terms & Conditions");
        c8.setFont(new Font("Raleway", Font.BOLD, 12));
        c8.setBounds(180, 470, 1200, 40);
        add(c8);

        submit = new JButton("Submit ");
        submit.setBounds(450, 550, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel ");
        cancel.setBounds(600, 550, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            Random ran = new Random();
            String Account = "";
            if (r1.isSelected()) {
                Account = "Savings";
            } else if (r2.isSelected()) {
                Account = "Current";
            } else if (r3.isSelected()) {
                Account = "Fixed";
            } else if (r4.isSelected()) {
                Account = "Minor";
            }

            String cardnum = "" + Math.abs(ran.nextLong() % 90000000L + 1350931250000000L);
            String pinno = "" + Math.abs(ran.nextLong() % 9999);

            String Services = "";
            if (c1.isSelected()) {
                Services = Services + "ATM";
            } else if (c2.isSelected()) {
                Services = Services + "Internet Banking";
            } else if (c3.isSelected()) {
                Services = Services + "Mobile Banking";
            } else if (c4.isSelected()) {
                Services = Services + "Checque";
            } else if (c5.isSelected()) {
                Services = Services + "E-Statement";
            }

            else if (c6.isSelected()) {
                Services = Services + "Dollar Card";
            }

            try {
                if (Account.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type should be selected");
                } else if (Services.equals("")) {
                    JOptionPane.showMessageDialog(null, "Select atleast one service");

                } else if (c7.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Please Agree to the conditions");

                } else if (c8.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Please Agree to the conditions");

                }

                else {
                    conn con = new conn();
                    String query = "insert into signupthree values('" + formno + "','" + Account + "','" + cardnum
                            + "','"
                            + pinno + "','"
                            + Services
                            + "')";
                    String query2 = "insert into LoginDetails values('" + formno + "','" + cardnum + "','" + pinno
                            + "')";
                    con.s.executeUpdate(query);
                    con.s.executeUpdate(query2);
                    new signupthree(formno).setVisible(true);

                    JOptionPane.showMessageDialog(null,
                            "Your Card Number is :" + cardnum + "\n" + "Your Pin is :" + pinno);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                    ;

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new signupthree("");

    }

}
