import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener {
    long ran;
    JTextField FNfield, LNfield, Efield, Addfield, Cfield, stfield, PINfield;
    JButton signup;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser datec;

    Signup1() {

        setLayout(null);
        // Creating random obj
        Random ran = new Random();
        setSize(800, 850);
        setVisible(true);
        setLocation(350, 10);
        setTitle("Sign Up Form ");
        JLabel formno = new JLabel("Application Form No :" + " " + Math.abs(ran.nextLong() % 9000L + 1000L));
        formno.setFont(new Font("Raleway", Font.BOLD, 32));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel PerDet = new JLabel("Page 1 Personal Details :");
        PerDet.setFont(new Font("Raleway", Font.BOLD, 22));
        PerDet.setBounds(200, 80, 600, 40);
        add(PerDet);

        JLabel FirstName = new JLabel(" Name :");
        FirstName.setFont(new Font("Raleway", Font.BOLD, 18));
        FirstName.setBounds(150, 140, 600, 40);
        add(FirstName);

        FNfield = new JTextField();
        FNfield.setBounds(310, 150, 350, 30);
        FNfield.setFont(new Font("arial", Font.BOLD, 14));
        add(FNfield);

        JLabel LastName = new JLabel("Father's Name :");
        LastName.setFont(new Font("Raleway", Font.BOLD, 18));
        LastName.setBounds(150, 180, 600, 40);
        add(LastName);

        LNfield = new JTextField();
        LNfield.setBounds(310, 180, 350, 30);
        LNfield.setFont(new Font("arial", Font.BOLD, 14));
        add(LNfield);

        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        DOB.setBounds(150, 220, 600, 40);
        add(DOB);

        datec = new JDateChooser();
        datec.setBounds(310, 220, 350, 30);
        add(datec);

        JLabel Gender = new JLabel("Gender :");
        Gender.setFont(new Font("Raleway", Font.BOLD, 18));
        Gender.setBounds(150, 260, 600, 40);
        add(Gender);

        male = new JRadioButton("Male");
        male.setBounds(310, 260, 60, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380, 260, 120, 30);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(female);
        bg.add(male);

        JLabel Email = new JLabel("Email Address:");
        Email.setFont(new Font("Raleway", Font.BOLD, 18));
        Email.setBounds(150, 300, 600, 40);
        add(Email);

        Efield = new JTextField();
        Efield.setBounds(310, 300, 350, 30);
        Efield.setFont(new Font("arial", Font.BOLD, 14));
        add(Efield);

        JLabel MS = new JLabel("Marital Status :");
        MS.setFont(new Font("Raleway", Font.BOLD, 18));
        MS.setBounds(150, 340, 600, 40);
        add(MS);

        married = new JRadioButton("Married");
        married.setBounds(310, 340, 80, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(390, 340, 120, 30);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(510, 340, 120, 30);
        add(others);

        ButtonGroup ms = new ButtonGroup();
        ms.add(married);
        ms.add(unmarried);
        ms.add(others);
        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Raleway", Font.BOLD, 18));
        Address.setBounds(150, 380, 600, 40);
        add(Address);

        Addfield = new JTextField();
        Addfield.setBounds(310, 380, 350, 30);
        Addfield.setFont(new Font("arial", Font.BOLD, 14));
        add(Addfield);

        JLabel City = new JLabel("City :");
        City.setFont(new Font("Raleway", Font.BOLD, 18));
        City.setBounds(150, 420, 600, 40);
        add(City);

        Cfield = new JTextField();
        Cfield.setBounds(310, 420, 350, 30);
        Cfield.setFont(new Font("arial", Font.BOLD, 14));
        add(Cfield);

        JLabel State = new JLabel("State :");
        State.setFont(new Font("Raleway", Font.BOLD, 18));
        State.setBounds(150, 460, 600, 40);
        add(State);

        stfield = new JTextField();
        stfield.setBounds(310, 460, 350, 30);
        stfield.setFont(new Font("arial", Font.BOLD, 14));
        add(stfield);

        JLabel PinCode = new JLabel("PinCode :");
        PinCode.setFont(new Font("Raleway", Font.BOLD, 18));
        PinCode.setBounds(150, 500, 600, 40);
        add(PinCode);

        PINfield = new JTextField();
        PINfield.setBounds(310, 500, 350, 30);
        PINfield.setFont(new Font("arial", Font.BOLD, 14));
        add(PINfield);

        signup = new JButton("Next ");
        signup.setBounds(560, 550, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        signup.setForeground(Color.white);

        add(signup);
    }

    public void actionPerformed(ActionEvent ae) {

        String formno = "" + ran;
        String name = FNfield.getText();
        String fname = LNfield.getText();
        String date = ((JTextField) datec.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = Efield.getText();
        String ms = null;
        if (married.isSelected()) {
            ms = "Married";
        } else if (unmarried.isSelected()) {
            ms = "Unmarried";
        } else if (others.isSelected()) {
            ms = "Other";
        }
        String city = Cfield.getText();
        String pin = PINfield.getText();
        String state = stfield.getText();
        String address = Addfield.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");

            } else {
                conn newconnection = new conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + date
                        + "','" + gender + "','" + email + "','" + ms + "','" + address + "','" + city + "','" + state
                        + "','" + pin + "')";
                newconnection.s.executeUpdate(query);
                new signuptwo(formno).setVisible(true);
                setVisible(false);

            }

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Signup1();
    }

}
