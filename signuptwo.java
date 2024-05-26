import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class signuptwo extends JFrame implements ActionListener {

    JTextField Efield, Addfield, Pfield, Brfield, Ofield, INfield;
    JButton signup;
    JRadioButton EA, feEA, married, unmarried;

    JComboBox Religion, Quotass, Income, ED;
    String formno;

    signuptwo(String formno) {
        this.formno = formno;

        setLayout(null);

        setSize(800, 850);
        setVisible(true);
        setLocation(350, 10);
        setTitle("Additional Details ");

        JLabel PerDet = new JLabel("Page 2 Additional  Details :");
        PerDet.setFont(new Font("Raleway", Font.BOLD, 22));
        PerDet.setBounds(200, 80, 600, 40);
        add(PerDet);

        JLabel Rg = new JLabel("Religion :");
        Rg.setFont(new Font("Raleway", Font.BOLD, 18));
        Rg.setBounds(150, 140, 600, 40);
        add(Rg);

        String rg[] = { "Hindu", "Muslim", "Christan", "Buddhist" };
        Religion = new JComboBox(rg);
        Religion.setBounds(310, 150, 350, 30);
        Religion.setFont(new Font("arial", Font.BOLD, 14));
        add(Religion);

        JLabel Quota = new JLabel("Quota :");
        Quota.setFont(new Font("Raleway", Font.BOLD, 18));
        Quota.setBounds(150, 180, 600, 40);
        add(Quota);

        String quotas[] = { "General", "Dalit", "Woman", "Muslim " };
        Quotass = new JComboBox(quotas);
        Quotass.setBounds(310, 180, 350, 30);
        Quotass.setFont(new Font("arial", Font.BOLD, 14));
        add(Quotass);

        JLabel DOB = new JLabel("Income:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        DOB.setBounds(150, 220, 600, 40);
        add(DOB);

        String inc[] = { "10,000", "20,000", "50,000", "80,000 ", "More than 80k" };
        Income = new JComboBox(inc);
        Income.setBounds(310, 220, 350, 30);
        add(Income);

        JLabel Education = new JLabel("Education  :");
        Education.setFont(new Font("Raleway", Font.BOLD, 18));
        Education.setBounds(150, 260, 600, 40);
        add(Education);

        String edu[] = { "SLC PASS", "+2 PASS", "BACHELORS", "MASTERS ", "PHD" };
        ED = new JComboBox(edu);
        ED.setBounds(310, 260, 350, 30);
        add(ED);

        JLabel Occ = new JLabel("Occupation :");
        Occ.setFont(new Font("Raleway", Font.BOLD, 18));
        Occ.setBounds(150, 300, 600, 40);
        add(Occ);

        Ofield = new JTextField();
        Ofield.setBounds(310, 300, 350, 30);
        Ofield.setFont(new Font("arial", Font.BOLD, 14));
        add(Ofield);

        JLabel SS = new JLabel("Senior Citizen :");
        SS.setFont(new Font("Raleway", Font.BOLD, 18));
        SS.setBounds(150, 340, 600, 40);
        add(SS);

        married = new JRadioButton("YES");
        married.setBounds(310, 340, 80, 30);
        add(married);

        unmarried = new JRadioButton("NO");
        unmarried.setBounds(390, 340, 120, 30);
        add(unmarried);

        ButtonGroup ms = new ButtonGroup();
        ms.add(married);
        ms.add(unmarried);

        JLabel IN = new JLabel("Identification NO :");
        IN.setFont(new Font("Raleway", Font.BOLD, 18));
        IN.setBounds(150, 380, 600, 40);
        add(IN);

        INfield = new JTextField();
        INfield.setBounds(310, 380, 350, 30);
        INfield.setFont(new Font("arial", Font.BOLD, 14));
        add(INfield);

        JLabel Phonenum = new JLabel("Phone Number :");
        Phonenum.setFont(new Font("Raleway", Font.BOLD, 18));
        Phonenum.setBounds(150, 420, 600, 40);
        add(Phonenum);

        Pfield = new JTextField();
        Pfield.setBounds(310, 420, 350, 30);
        Pfield.setFont(new Font("arial", Font.BOLD, 14));
        add(Pfield);

        JLabel Branch = new JLabel("Branch Name :");
        Branch.setFont(new Font("Raleway", Font.BOLD, 18));
        Branch.setBounds(150, 460, 600, 40);
        add(Branch);

        Brfield = new JTextField();
        Brfield.setBounds(310, 460, 350, 30);
        Brfield.setFont(new Font("arial", Font.BOLD, 14));
        add(Brfield);

        JLabel Existing = new JLabel("Existing Account :");
        Existing.setFont(new Font("Raleway", Font.BOLD, 18));
        Existing.setBounds(150, 500, 600, 40);
        add(Existing);

        EA = new JRadioButton("Yes");
        EA.setBounds(315, 510, 50, 30);
        add(EA);

        feEA = new JRadioButton("NO");
        feEA.setBounds(380, 510, 350, 30);
        add(feEA);

        ButtonGroup bg = new ButtonGroup();
        bg.add(feEA);
        bg.add(EA);

        signup = new JButton("Next ");
        signup.setBounds(560, 550, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        signup.setForeground(Color.white);

        add(signup);
    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) Religion.getSelectedItem();
        String quota = (String) Quotass.getSelectedItem();
        String income = (String) Income.getSelectedItem();
        String Education = (String) ED.getSelectedItem();
        String Occupation = Ofield.getText();

        String ms = null;
        if (married.isSelected()) {
            ms = "YES";
        } else if (unmarried.isSelected()) {
            ms = "NO";
        }
        String PhoneNo = Pfield.getText();
        String IdentifiNo = INfield.getText();
        String Branch = Brfield.getText();

        String account = null;
        if (EA.isSelected()) {
            account = "YES";

        } else if (feEA.isSelected()) {
            account = "NO";
        }

        try {
            if (IdentifiNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Identification NO is Required");

            } else {
                conn newconnection = new conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + quota + "','"
                        + income
                        + "','" + Education + "','" + Occupation + "','" + ms + "','" + PhoneNo + "','" + IdentifiNo
                        + "','" + Branch
                        + "','" + account + "')";
                newconnection.s.executeUpdate(query);
                setVisible(false);
                new signupthree(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        new signuptwo("");
    }

}
