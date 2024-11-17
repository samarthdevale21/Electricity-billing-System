import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;

    signup() {
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(51,51,51), 3), "Create-Account",
                       TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51,51,51)));
        panel.setBackground(new Color(255,255,255));
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(280, 50, 150, 20);
        panel.add(accountType);

        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.BLACK);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.BLACK);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        meter.addFocusListener(new FocusListener() {
            @Override

            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no='" + meter.getText() + "'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.BLACK);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);

                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);

                }
            }
        });

        create = new JButton("Create");
        create.setBackground(Color.GREEN);
        create.setForeground(Color.BLACK);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(280, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup2,jpg.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 30, 220, 220);
        panel.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String Atype = accountType.getSelectedItem();
            String Ausername = username.getText();
            String Aname = name.getText();
            String Apassword = password.getText();
            String Ameter = meter.getText();

            try {
                Conn c = new Conn();
                String query = null;
                if (Atype.equals("Admin")) {

                    query = "insert into login values('" + Ameter + "','" + Ausername + "','" + Aname + "','"
                            + Apassword + "','" + Atype + "')";
                } else {
                    query = "update login set username='" + Ausername + "',password= '" + Apassword + "',user='" + Atype
                            + "'where meter_no='" + Ameter + "'";

                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfullf");

                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();

            }

        } else if (ae.getSource() == back) {
            setVisible(false);

            new Login();
        }
    }

    public static void main(String[] args) {
        new signup();
    }

}
