
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {
    public JFrame frame;
    public JButton login;
    public JButton welcome;
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;
    public JTextField uname;
    public JPasswordField pass;
    
    public Login()
    {
        initGUI();
    }
    
    public void initGUI()
    {
        frame = new JFrame("Login");
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        
        uname= new JTextField();
        pass= new JPasswordField();
        
        label2 = new JLabel("College ID ");
        label3 = new JLabel("Password ");
        label1 = new JLabel("Evernt Management System");
        
        
        label1.setBounds(100, 10, 300, 50);
        label1.setForeground(Color.red);
        label1.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
        
        
        label2.setForeground(Color.white);
        label2.setBounds(65, 80, 100, 50);
        
        
        uname.setBounds(160, 90, 220, 30);
        frame.add(uname);
        
        
        label3.setForeground(Color.white);
        label3.setBounds(65, 150, 100, 50);
        
        
        pass.setBounds(160, 160, 220, 30);
        frame.add(pass);
        
        
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        
        login= new JButton("Login");
        welcome= new JButton("Welcome");
       
         
        login.setBounds(260, 240, 100, 30);
        welcome.setBounds(120, 240, 100, 30);
       
        frame.add(login);
        frame.add(welcome);
        
        
        frame.setLocation(380, 100);
        frame.setSize(500, 350);
        
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
