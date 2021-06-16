/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_gui_project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

// Abstract Window Toolkit For Styling & Handling Responses From User.
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// JDBC Package's Classes & Interfaces To Support Database Connectivity.
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;                                                      // For DQL Queries.
import java.sql.PreparedStatement;                                              // For DML Queries.
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.lang.String;
/**
 *
 * @author EDWARD
 */
public class Main_App extends JFrame implements ActionListener, ItemListener {
    JPanel Title_Panel;
    JLabel Employees_Title;
    JLabel Employee_ID_Label;
    JTextField Employee_ID_TextField;
    JLabel Full_Name_Label;
    JTextField Full_Name_TextField;
    JLabel Gender_Label;
    JComboBox Gender_Selection;
    JLabel Address_Label;
    JTextField Address_TextField;
    JLabel Mobile_Label;
    JTextField Mobile_TextField;
    JLabel Employment_Date_Label;
    JTextField Employment_Date_TextField;
    JLabel Designation_Label;
    JTextField Designation_TextField;
    JLabel Payment_Label;
    JTextField Payment_TextField;
    JLabel Monthly_Label;
    JLabel Title;
    JButton Insert_Btn;
    JButton Update_Btn;
    JButton Delete_Btn;
    JButton Clear_Btn;
    JButton Load_Btn;
    JButton Quit_Btn;
    JButton Clear_Entries;
    JTextArea Employee_TextArea;
    JScrollPane Employee_ScrollPane;
    
    // Gender ComboBox's Options :
    private final String[] Options = {"Female", "Male", "I Identify As LGBT", "Non - Binary", "No Answer"};
    // Initalize Gender ComboBox's Selected Option.
    private String Choice = "";
    
    // MySQL Server's Details.
    private final String URL = "jdbc:mysql://localhost:3306/COMPANY";
    private final String UserName = "root";
    private final String Password = "12345";
    
    private Connection My_Con = null;
    private Statement My_St = null;
    private PreparedStatement My_Prepared_St = null;
    private ResultSet My_Rs = null;
    
    // Attribute To Contain Each Row In The Table.
    private String userData = "";
    
    public Main_App(){
        // App Title :
        Title = new JLabel("Employee Database Management System");
        Title.setForeground(new Color(21, 0, 255));                                      // Dark Blue As Foreground Color.
        Title.setFont(new Font("Times New Roman", PLAIN, 48));
        Title.setBounds(0, 75, 900, 50);
        
        // Insert Button
        // X_Coor.-Interval For Buttons = 170.0
        Insert_Btn = new JButton();
        Insert_Btn.setBounds(15, 515, 150, 115);
        Insert_Btn.addActionListener(this);
        Insert_Btn.setText("INSERT");
        Insert_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Insert_Btn.setFocusable(false);
        Insert_Btn.setForeground(new Color(51, 255, 51));                               // Cyan
        Insert_Btn.setBackground(new Color(30, 34, 255));                               // Dark Blue
        Insert_Btn.setBorder(BorderFactory.createEtchedBorder());
        Insert_Btn.setEnabled(true);
       
        // Update Button
        Update_Btn = new JButton();
        Update_Btn.setBounds(185, 515, 150, 115);
        Update_Btn.addActionListener(this);
        Update_Btn.setText("UPDATE BY ID");
        Update_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Update_Btn.setFocusable(false);
        Update_Btn.setForeground(new Color(51, 255, 51));
        Update_Btn.setBackground(new Color(30, 34, 255));
        Update_Btn.setBorder(BorderFactory.createEtchedBorder());
        Update_Btn.setEnabled(true);
        
        // Delete Button
        Delete_Btn = new JButton();
        Delete_Btn.setBounds(355, 515, 150, 115);
        Delete_Btn.addActionListener(this);
        Delete_Btn.setText("DELETE BY ID");
        Delete_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Delete_Btn.setFocusable(false);
        Delete_Btn.setForeground(new Color(51, 255, 51));
        Delete_Btn.setBackground(new Color(30, 34, 255));
        Delete_Btn.setBorder(BorderFactory.createEtchedBorder());
        Delete_Btn.setEnabled(true);
        
        // Clear Button
        Clear_Btn = new JButton();
        Clear_Btn.setBounds(525, 515, 150, 115);
        Clear_Btn.addActionListener(this);
        Clear_Btn.setText("CLEAR ALL");
        Clear_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Clear_Btn.setFocusable(false);
        Clear_Btn.setForeground(new Color(51, 255, 51));
        Clear_Btn.setBackground(new Color(30, 34, 255));
        Clear_Btn.setBorder(BorderFactory.createEtchedBorder());
        Clear_Btn.setEnabled(true);
        
        // Load Button
        Load_Btn = new JButton();
        Load_Btn.setBounds(695, 515, 150, 115);
        Load_Btn.addActionListener(this);
        Load_Btn.setText("LOAD");
        Load_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Load_Btn.setFocusable(false);
        Load_Btn.setForeground(new Color(51, 255, 51));
        Load_Btn.setBackground(new Color(30, 34, 255));
        Load_Btn.setBorder(BorderFactory.createEtchedBorder());
        Load_Btn.setEnabled(true);
        
        // Quit Button
        Quit_Btn = new JButton();
        Quit_Btn.setBounds(908, 515, 75, 115);
        Quit_Btn.addActionListener(this);
        Quit_Btn.setText("QUIT");
        Quit_Btn.setFont(new Font("Times New Roman", PLAIN, 20));
        Quit_Btn.setFocusable(false);
        Quit_Btn.setForeground(new Color(51, 255, 51));
        Quit_Btn.setBackground(new Color(30, 34, 255));
        Quit_Btn.setBorder(BorderFactory.createEtchedBorder());
        Quit_Btn.setEnabled(true);
        
        // Clear All TextFields
        Clear_Entries = new JButton();
        Clear_Entries.setBounds(124, 477, 200, 30);
        Clear_Entries.addActionListener(this);
        Clear_Entries.setText("RESET TEXTFIELDS");
        Clear_Entries.setFont(new Font("Times New Roman", PLAIN, 20));
        Clear_Entries.setFocusable(false);
        Clear_Entries.setForeground(new Color(51, 255, 51));
        Clear_Entries.setBackground(new Color(30, 34, 255));
        Clear_Entries.setBorder(BorderFactory.createEtchedBorder());
        Clear_Entries.setEnabled(true);
        
        // Title For Employee Attributes :
        Employees_Title = new JLabel("EMPLOYEE DETAILS");
        Employees_Title.setForeground(Color.red);
        Employees_Title.setBackground(Color.GREEN);
        Employees_Title.setFont(new Font("Times New Roman", PLAIN, 25));
        Employees_Title.setBounds(43, 60, 250, 80);
        
        // Employee ID Label :
        // Label Y-Coor. Interval = 45.0
        Employee_ID_Label = new JLabel("Employee-ID = ");
        Employee_ID_Label.setForeground(new Color(232, 120, 0));                         // Orange
        Employee_ID_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Employee_ID_Label.setBounds(10, 100, 117, 75);
        
        // Employee ID TextField:
        // TextField Y-Coor. Interval = 45.0
        Employee_ID_TextField = new JTextField();
        Employee_ID_TextField.setBounds(125, 115, 197, 40);
        Employee_ID_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Employee_ID_TextField.setForeground(Color.BLACK);
        Employee_ID_TextField.setBackground(Color.GREEN);
        Employee_ID_TextField.setCaretColor(Color.BLACK);
        Employee_ID_TextField.setEditable(true);
        
        // Full Name Label :
        Full_Name_Label = new JLabel("Full Name = ");
        Full_Name_Label.setForeground(new Color(232, 120, 0));
        Full_Name_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Full_Name_Label.setBounds(30, 145, 117, 75);
        
        // Full Name TextField :
        Full_Name_TextField = new JTextField();
        Full_Name_TextField.setBounds(125, 160, 197, 40);
        Full_Name_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Full_Name_TextField.setForeground(Color.BLACK);
        Full_Name_TextField.setBackground(Color.GREEN);
        Full_Name_TextField.setCaretColor(Color.BLACK);
        Full_Name_TextField.setEditable(true);
        
        // Gender Label :
        Gender_Label = new JLabel("Gender = ");
        Gender_Label.setForeground(new Color(232, 120, 0));
        Gender_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Gender_Label.setBounds(53, 190, 117, 75);
        
        // Gender Selection(ComboBox) :
        Gender_Selection = new JComboBox(Options);
        Gender_Selection.setSelectedIndex(0);
        Gender_Selection.addItemListener(this);
        Gender_Selection.setForeground(Color.BLACK);
        Gender_Selection.setBackground(Color.GREEN);
        Gender_Selection.setBounds(125, 205, 197, 40);
        
        // Address Label :
        Address_Label = new JLabel("Address = ");
        Address_Label.setForeground(new Color(232, 120, 0));
        Address_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Address_Label.setBounds(48, 235, 117, 75);
        
        // Address TextField :
        Address_TextField = new JTextField();
        Address_TextField.setBounds(125, 250, 197, 40);
        Address_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Address_TextField.setForeground(Color.BLACK);
        Address_TextField.setBackground(Color.GREEN);
        Address_TextField.setCaretColor(Color.BLACK);
        Address_TextField.setEditable(true);
        
        // Mobile Label :
        Mobile_Label = new JLabel("Mobile Num. = ");
        Mobile_Label.setForeground(new Color(232, 120, 0));
        Mobile_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Mobile_Label.setBounds(10, 280, 117, 75);
        
        // Mobile TextField :
        Mobile_TextField = new JTextField();
        Mobile_TextField.setBounds(125, 295, 197, 40);
        Mobile_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Mobile_TextField.setForeground(Color.BLACK);
        Mobile_TextField.setBackground(Color.GREEN);
        Mobile_TextField.setCaretColor(Color.BLACK);
        Mobile_TextField.setEditable(true);
        
        // Employment Date Label :
        Employment_Date_Label = new JLabel("Date Employed");
        Employment_Date_Label.setForeground(new Color(232, 120, 0));
        Employment_Date_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Employment_Date_Label.setBounds(10, 325, 117, 75);
        
        // Employment Date TextField :
        Employment_Date_TextField = new JTextField();
        Employment_Date_TextField.setBounds(125, 340, 197, 40);
        Employment_Date_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Employment_Date_TextField.setForeground(Color.BLACK);
        Employment_Date_TextField.setBackground(Color.GREEN);
        Employment_Date_TextField.setCaretColor(Color.BLACK);
        Employment_Date_TextField.setEditable(true);
        
        // Designation Label :
        Designation_Label = new JLabel("Designation = ");
        Designation_Label.setForeground(new Color(232, 120, 0));
        Designation_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Designation_Label.setBounds(22, 370, 117, 75);
        
        // Designation TextField :
        Designation_TextField = new JTextField();
        Designation_TextField.setBounds(125, 387, 197, 40);
        Designation_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Designation_TextField.setForeground(Color.BLACK);
        Designation_TextField.setBackground(Color.GREEN);
        Designation_TextField.setCaretColor(Color.BLACK);
        Designation_TextField.setEditable(true);
        
        // Monthly Payment Rate Label :
        Payment_Label = new JLabel("Payment Rate =");
        Payment_Label.setForeground(new Color(232, 120, 0));
        Payment_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Payment_Label.setBounds(8, 415, 117, 75);
        
        Monthly_Label = new JLabel("(Monthly)");
        Monthly_Label.setForeground(new Color(232, 120, 0));
        Monthly_Label.setFont(new Font("Times New Roman", PLAIN, 18));
        Monthly_Label.setBounds(23, 435, 117, 75);
        
        // Monthly Payment Rate TextField :
        Payment_TextField = new JTextField();
        Payment_TextField.setBounds(125, 432, 197, 40);
        Payment_TextField.setFont(new Font("Times New Roman", PLAIN, 18));
        Payment_TextField.setForeground(Color.BLACK);
        Payment_TextField.setBackground(Color.GREEN);
        Payment_TextField.setCaretColor(Color.BLACK);
        Payment_TextField.setEditable(true);
        
        // Added JTextArea :
        // Force Vertical ScrollPane To Appear:
        Employee_TextArea = new JTextArea("NONE");
        Employee_TextArea.setFont(new Font("Times New Roman", PLAIN, 12));
        Employee_TextArea.setBackground(Color.BLACK);
        Employee_TextArea.setForeground(Color.WHITE);
        Employee_TextArea.setCaretColor(Color.WHITE);
        
        // User Won't Edit The TextArea Manually.
        Employee_TextArea.setEditable(false);
        
        Employee_ScrollPane = new JScrollPane(Employee_TextArea);
        Employee_ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Employee_ScrollPane.setBounds(355, 92, 630, 415);
        
        // Panel For Title :
        Title_Panel = new JPanel();
        Title_Panel.setBackground(new Color(238, 255, 0));                               // Yellow
        Title_Panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 5));    // Black As Color & Thickness
        Title_Panel.setBounds(0, 0, 985, 85);                                            // (X, Y, Width, Height)
        Title_Panel.add(Title);
        
        /*
        Setup Of The Main Window(JFrame) For The Main Application.
        */
        // ImageIcon For JFrame :
        ImageIcon People = new ImageIcon("C:\\Users\\EDWARD\\JAVA_Folder\\JDBC_GUI_Project\\src\\people_icon.png");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 680);
        this.setTitle("Employee Database Manager");
        this.setResizable(false);
        this.setIconImage(People.getImage());
        this.getContentPane().setBackground(Color.GRAY);
        this.add(Title_Panel);
        this.add(Insert_Btn);
        this.add(Update_Btn);
        this.add(Delete_Btn);
        this.add(Clear_Btn);
        this.add(Load_Btn);
        this.add(Quit_Btn);
        this.add(Clear_Entries);
        this.add(Employees_Title);
        this.add(Employee_ID_Label);
        this.add(Employee_ID_TextField);
        this.add(Full_Name_Label);
        this.add(Full_Name_TextField);
        this.add(Gender_Label);
        this.add(Gender_Selection);
        this.add(Address_Label);
        this.add(Address_TextField);
        this.add(Mobile_Label);
        this.add(Mobile_TextField);
        this.add(Employment_Date_Label);
        this.add(Employment_Date_TextField);
        this.add(Designation_Label);
        this.add(Designation_TextField);
        this.add(Payment_Label);
        this.add(Monthly_Label);
        this.add(Payment_TextField);
        this.add(Employee_ScrollPane);
        
        // The Method To Display JFrame Is Always Executed Last.
        this.setVisible(true);
    }
    
    // Button Actions.
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Retrive The Source When A Click Happens.
        Object src = e.getSource();
        
        if(src == Insert_Btn){
            // Insert Into SQL Table.
            try { 
                // Load Driver Class And Execute Static Block.
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create Connection.
                My_Con = DriverManager.getConnection(URL, UserName, Password);
                
                // Create Prepared Statement.
                My_Prepared_St = My_Con.prepareStatement("insert into employee values (?, ?, ?, ?, ?, ?, ?, ?)");
                
                // Set Values For Insertion.
                My_Prepared_St.setString(1, (String)Employee_ID_TextField.getText());
                My_Prepared_St.setString(2, (String)Full_Name_TextField.getText());
                My_Prepared_St.setString(3, (String)Gender_Selection.getSelectedItem());
                My_Prepared_St.setString(4, (String)Address_TextField.getText());
                My_Prepared_St.setString(5, (String)Mobile_TextField.getText());
                My_Prepared_St.setString(6, (String)Employment_Date_TextField.getText());
                My_Prepared_St.setString(7, (String)Designation_TextField.getText());
                My_Prepared_St.setString(8, (String)Payment_TextField.getText());
                
                // Notify User The Number Of Affected Rows In The Table.
                int count = My_Prepared_St.executeUpdate();
                JOptionPane.showMessageDialog(null, count + " Row/s Affected.", "Inserted Successfully", JOptionPane.INFORMATION_MESSAGE);
                
                // Close The Connection.
                My_Prepared_St.close();
                My_Con.close();
                
            } 
            catch(SQLException Err) { 
                JOptionPane.showMessageDialog(null, "An Error Appeared In Your JDBC Operation !", "JDBC Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(ClassNotFoundException E) { 
                JOptionPane.showMessageDialog(null, "Your MySQL Driver Is Not Running !", "MySQL Driver Not Found Error", JOptionPane.ERROR_MESSAGE);
            } 
            
        }
        
        /*
            Both UPDATE And DELETE Works By Referring To An Employee's ID.
        */
        else if(src == Update_Btn){
            // Update SQL Table By Referring To Employee_ID.
            /*
                '''
                Do NOT build SQL statements by concatenating strings. 
                The Developers thought they had been over this a long time ago. 
                It is a very bad practice and a very good way to create errors 
                and let huge security holes into applications. 
                Creating SQL statements by concatenating strings is a recipe for disaster 
                and a bad habit that needs to be killed off before it takes hold.
                Not to mention that JDBC is the most widely used tool which makes SQL-Injection possible.
                '''
            */
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                My_Con = DriverManager.getConnection(URL, UserName, Password);
                
                My_Prepared_St = My_Con.prepareStatement("update employee set name = ?, gender = ?, address = ?, mobile = ?, date_employed = ?, designation = ?, monthly_payment_rate = ? where employee_id = ?");
                My_Prepared_St.setString(1, (String)Full_Name_TextField.getText());
                My_Prepared_St.setString(2, (String)Gender_Selection.getSelectedItem());
                My_Prepared_St.setString(3, (String)Address_TextField.getText());
                My_Prepared_St.setString(4, (String)Mobile_TextField.getText());
                My_Prepared_St.setString(5, (String)Employment_Date_TextField.getText());
                My_Prepared_St.setString(6, (String)Designation_TextField.getText());
                My_Prepared_St.setString(7, (String)Payment_TextField.getText());
                My_Prepared_St.setString(8, (String)Employee_ID_TextField.getText());
                
                int new_now = My_Prepared_St.executeUpdate();
                JOptionPane.showMessageDialog(null, new_now + " Row/s Affected.", "Updated Successfully", JOptionPane.INFORMATION_MESSAGE);
                
                My_Prepared_St.close();
                My_Con.close();
                
            } 
            // If ID Is Invalid, No Row Is Affected(0 Row/s Is/Are Affected).
            catch(SQLException Err) {
                JOptionPane.showMessageDialog(null, "An Error Appeared In Your JDBC Operation !", "JDBC Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(ClassNotFoundException E) {
                JOptionPane.showMessageDialog(null, "Your MySQL Driver Is Not Running !", "MySQL Driver Not Found Error", JOptionPane.ERROR_MESSAGE);
            } 
            
        }
        
        else if(src == Delete_Btn){
            // Delete From SQL Table By Referring To Employee_ID.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                My_Con = DriverManager.getConnection(URL, UserName, Password);
                
                My_Prepared_St = My_Con.prepareStatement("delete from employee where employee_id=?");
                My_Prepared_St.setString(1, (String)Employee_ID_TextField.getText());
                
                int gone = My_Prepared_St.executeUpdate();
                JOptionPane.showMessageDialog(null, gone + " Row/s Affected !", "Deleted Successfully", JOptionPane.INFORMATION_MESSAGE);
                
                My_Prepared_St.close();
                My_Con.close();
                
            }
            // If ID Is Invalid, No Row Is Affected(0 Row/s Is/Are Affected).
            catch(SQLException Err) {
                JOptionPane.showMessageDialog(null, "An Error Appeared In Your JDBC Operation !", "JDBC Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(ClassNotFoundException E) {
                JOptionPane.showMessageDialog(null, "Your MySQL Driver Is Not Running !", "MySQL Driver Not Found Error", JOptionPane.ERROR_MESSAGE);
            } 
            
        }
        
        else if(src == Clear_Btn){
            // Reset The JTextArea.
            Employee_TextArea.setText("");
        }
        
        else if(src == Load_Btn){
            // Execute Query To Print MySQL Database Into JTextArea.
            Employee_TextArea.append("Syntax | Order :\nEmployee_ID = Value\nName = Value\nGender = Value\nAddress = Value\nMobile_Phone_Number = Value\nDate_Employed = Value\nDesignation = Value\nMonthly_Salary = Value\n=====================================================================================================================");
            
            try {
                // Load Driver.
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create Connection.
                My_Con = DriverManager.getConnection(URL, UserName, Password);
                
                // Create Statement.
                My_St = My_Con.createStatement();
                
                // Execute Selection Query.
                My_Rs = My_St.executeQuery("select * from employee");
                
                // Fetch The Table Using ResultSet As Pointer(Row Traversal).
                while(My_Rs.next()) {
                    userData = "Employee_ID = " + My_Rs.getString(1) + "\n" + "Full Name = " + My_Rs.getString(2) + "\n" + "Gender = " + My_Rs.getString(3) + "\n" + "Address = " + My_Rs.getString(4) + "\n" + "Mobile Number = " + My_Rs.getString(5) + "\n" + "Date Employed = " + My_Rs.getString(6) + "\n" + "Designation(Job Title) = " + My_Rs.getString(7) + "\n" + "Monthly Salary(Payment Rate) = " + My_Rs.getString(8) + "\n" + "=====================================================================================================================";
                    Employee_TextArea.append("\n" + userData);
                }
                
                // Close Connection.
                My_St.close();
                My_Con.close();
                
            } 
            catch(SQLException Err){ 
                JOptionPane.showMessageDialog(null, "An Error Appeared In Your JDBC Operation !", "JDBC Error", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(ClassNotFoundException Ex) {
                JOptionPane.showMessageDialog(null, "Your MySQL Driver Is Not Running !", "MySQL Driver Not Found Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        else if(src == Clear_Entries){
            // Clear All TextFields.
            Employee_ID_TextField.setText("");
            Full_Name_TextField.setText("");
            Gender_Selection.setSelectedIndex(0);
            Address_TextField.setText("");
            Mobile_TextField.setText("");
            Employment_Date_TextField.setText("");
            Designation_TextField.setText("");
            Payment_TextField.setText("");
        }
        
        else if(src == Quit_Btn){
            // Quit.
            System.exit(0);
        }
        
    }
    
    // Method For The Gender ComboBox.
    @Override
    public void itemStateChanged(ItemEvent evt) {
        if(evt.getSource() == Gender_Selection){
            // Option Is Selected & Stored In String Attribute "Choice".
            Choice = (String)Gender_Selection.getSelectedItem();
        }
                
    }
    
}