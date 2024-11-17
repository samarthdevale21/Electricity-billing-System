import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {

    String Atype, meter;

    Dashboard(String Atype, String meter) {
        this.Atype = Atype;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1580, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(new Color(0,0,128));

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.addActionListener(this);
        master.add(newcustomer);

        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.addActionListener(this);
        master.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.addActionListener(this);
        master.add(depositdetails);

        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.addActionListener(this);
        master.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setForeground(new Color(0,0,128));

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image5));
        viewinfo.addActionListener(this);
        info.add(viewinfo);

        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image6));
        updateinfo.addActionListener(this);
        info.add(updateinfo);

        JMenu user = new JMenu("User");
        user.setForeground(new Color(0,0,128));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.addActionListener(this);
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.addActionListener(this);
        user.add(billdetails);

        JMenu report = new JMenu("Report");
        report.setForeground(new Color(0,0,128));

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.addActionListener(this);
        report.add(generatebill);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(new Color(0,0,128));

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image10));
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem Browser = new JMenuItem("Browser");
        Browser.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        Browser.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        Browser.addActionListener(this);

        utility.add(Browser);

        JMenuItem youtube = new JMenuItem("Youtube");
        youtube.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        youtube.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        youtube.setIcon(new ImageIcon(image12));
        youtube.addActionListener(this);
        utility.add(youtube);

        JMenu mexist = new JMenu("Logout");
        mexist.setForeground(new Color(51,51,153));

        JMenuItem exit = new JMenuItem("Logout");
        exit.setFont(new Font("PIZZERIA", Font.ITALIC, 12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icons/icon13.png"));
        Image image13 = icon13.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image13));
        exit.addActionListener(this);
        mexist.add(exit);

        if (Atype.equals("Admin")) {
            mb.add(master);

        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
            
        }

        mb.add(utility);
        mb.add(mexist);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new newCustomer();

        } else if (msg.equals("Customer Details")) {
            new CustomerDetails();

        } else if (msg.equals("Deposit Details")) {
            new DepositDetails();

        } else if (msg.equals("Calculate Bill")) {
            new CalculateBill();

        } else if (msg.equals("View Information")) {
            new Viewinformation(meter);
        } else if (msg.equals("Update Information")) {
            new UpdateCustomer(meter);
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meter);
        }else if(msg.equals("Calculator")){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill")){
            new PayBill(meter);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
    }

    public static void main(String[] args) {
        new Dashboard("", "");

    }
}
