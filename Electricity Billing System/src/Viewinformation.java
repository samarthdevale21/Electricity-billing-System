import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Viewinformation extends JFrame implements ActionListener {

    JButton cancle;

    Viewinformation(String meter){
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.ITALIC,20));
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(70,80,100,20);
        add(lblname);

        JLabel name=new JLabel("");
        name.setBounds(250,80,100,20);
        add(name);

        JLabel lblmeternumber=new JLabel("Meter Number ");
        lblmeternumber.setBounds(70,140,100,20);
        add(lblmeternumber);

        JLabel meternumber=new JLabel("");
        meternumber.setBounds(250,140,100,20);
        add(meternumber);

        JLabel lbladdress=new JLabel("Adderss");
        lbladdress.setBounds(70,200,100,20);
        add(lbladdress);

        JLabel address=new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);

        JLabel lblcity=new JLabel("City");
        lblcity.setBounds(70,260,100,20);
        add(lblcity);

        JLabel city=new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);

        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(500,80,100,20);
        add(lblstate);

        JLabel state=new JLabel("");
        state.setBounds(650,80,100,20);
        add(state);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(500,130,100,20);
        add(lblemail);

        JLabel email=new JLabel("");
        email.setBounds(650,130,100,20);
        add(email);

        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(500,180,100,20);
        add(lblphone);

        JLabel phone=new JLabel("");
        phone.setBounds(650,180,100,20);
        add(phone);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from customer where meter_no='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }

            
        } catch (Exception e) {
           e.printStackTrace();
            
        }


        cancle=new JButton("Cancle");
        cancle.setBackground(Color.red);
        cancle.setForeground(Color.WHITE);
        cancle.setBounds(350,340,100,25);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/view3.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new Viewinformation("");
    }
    
}
