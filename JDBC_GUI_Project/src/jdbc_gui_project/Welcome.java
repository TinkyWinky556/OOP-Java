/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_gui_project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author EDWARD
 */
public class Welcome extends JFrame implements ActionListener{
    JLabel Welcome_Title;
    JLabel Employee_Database_Title;
    JLabel Management_Application_Title;
    JButton Proceed_Button;
    JButton Quit_Button;
    
    public Welcome() { 
        // Title 1 :
        Welcome_Title = new JLabel();
        Welcome_Title.setText("WELCOME TO THE");
        Welcome_Title.setForeground(new Color(102, 255, 0));
        Welcome_Title.setFont(new Font("Times New Roman", PLAIN, 20));
        Welcome_Title.setBounds(100, 0, 300, 25);
        
        // Title 2 :
        Employee_Database_Title = new JLabel();
        Employee_Database_Title.setText("EMPLOYEE DATABASE");
        Employee_Database_Title.setForeground(new Color(102, 255, 0));
        Employee_Database_Title.setFont(new Font("Times New Roman", PLAIN, 20));
        Employee_Database_Title.setBounds(85, 20, 300, 25);
        
        // Title 3 :
        Management_Application_Title = new JLabel();
        Management_Application_Title.setText("MANAGEMENT APPLICATION");
        Management_Application_Title.setForeground(new Color(102, 255, 0));
        Management_Application_Title.setFont(new Font("Times New Roman", PLAIN, 20));
        Management_Application_Title.setBounds(60, 40, 300, 25);
        
        // Proceed Button :
        Proceed_Button = new JButton();
        Proceed_Button.setBounds(60, 175, 100, 90);
        Proceed_Button.addActionListener(this);
        Proceed_Button.setText("PROCEED");
        Proceed_Button.setFont(new Font("Times New Roman", PLAIN, 14));
        Proceed_Button.setFocusable(false);
        Proceed_Button.setForeground(Color.BLACK);
        Proceed_Button.setBackground(Color.GREEN);
        Proceed_Button.setBorder(BorderFactory.createEtchedBorder());
        Proceed_Button.setEnabled(true);
        
        // Quit_Buttton :
        Quit_Button = new JButton();
        Quit_Button.setBounds(240, 175, 100, 90);
        Quit_Button.addActionListener(this);
        Quit_Button.setText("QUIT");
        Quit_Button.setFont(new Font("Times New Roman", PLAIN, 14));
        Quit_Button.setFocusable(false);
        Quit_Button.setForeground(Color.BLACK);
        Quit_Button.setBackground(Color.RED);
        Quit_Button.setBorder(BorderFactory.createEtchedBorder());
        Quit_Button.setEnabled(true);
        
        // Main Window For Welcoming Interface. 
        ImageIcon Icon = new ImageIcon("C:\\Users\\EDWARD\\JAVA_Folder\\JDBC_GUI_Project\\src\\people_icon.png");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(420, 420);
        this.setTitle("Welcoming Interface");
        this.setResizable(false);
        this.setIconImage(Icon.getImage());
        this.getContentPane().setBackground(new Color(43, 42, 42));   // Dark
        this.add(Welcome_Title);
        this.add(Employee_Database_Title);
        this.add(Management_Application_Title);
        this.add(Proceed_Button);
        this.add(Quit_Button);
        
        // This Is Executed Last.
        this.setVisible(true);
    }
    
    // Button Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if(src == Proceed_Button) { 
            // Exit The Welcoming Interface & Enter The Application.
            this.dispose();
            Main_App Run_App = new Main_App();
        } 
        else if(src == Quit_Button) {
            System.exit(0);
        } 
        
    }
    
}