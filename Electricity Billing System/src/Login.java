import java.awt.*;
import java.awt.event.*;

import javax. swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel,signup;
    JTextField username,password;
    Choice logginin;

    Login(){
        super("Login Profile");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(300,20,100,20);
        add(lblusername);

        username =new JTextField();
        username.setBounds(400,20,150,20);
        add(username);

        JLabel lblpassword =new JLabel("Password");
        lblpassword.setBounds(300,60,100,20);
        add(lblpassword);

        password =new JTextField();
        password.setBounds(400,60,150,20);
        add(password);

        JLabel logginas=new JLabel("Loggin in as");
        logginas.setBounds(300,100,100,20);
        add(logginas);

        logginin =new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400,100,150,20);
        add(logginin);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 =i1.getImage().getScaledInstance(17, 17,Image.SCALE_DEFAULT);
        login =new JButton("Login",new ImageIcon(i2));
        login.setBounds(330,160,100,20);
        login.setBackground(Color.green);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);      
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image i4 =i3.getImage().getScaledInstance(17, 17,Image.SCALE_DEFAULT);
        cancel=new JButton("Cancel",new ImageIcon(i4));
        cancel.setBounds(450,160,100,20);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image i6 =i5.getImage().getScaledInstance(17, 17,Image.SCALE_DEFAULT);
        signup =new JButton("Singup",new ImageIcon(i6));
        signup.setBounds(380,200,100,20);
        signup.setBackground(Color.blue);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image i8 =i7.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);

        setSize(640,300);
        setLocation(400,200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String suername=username.getText();
            String spassword=password.getText();
            String user=logginin.getSelectedItem();

            try {
                Conn c=new Conn();
                String query= "Select * from login where username='"+suername+"'and password='"+spassword+"'and user='"+user+"'";

                ResultSet rs=c.s.executeQuery(query);

                if(rs.next()){
                    String meter=rs.getString("meter_no");
                    setVisible(false);
                    new Dashboard(user,meter);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                    
                }

            } catch (Exception e) {
               e.printStackTrace();
            }

        }else if(ae.getSource()==cancel){
            setVisible(false);

        }else if(ae.getSource()==signup){
            setVisible(false);

            new signup();

        }

    }
    public static void main(String[] args) {
        new Login();
    }
    
}
