
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUp {
    
    public JFrame frame;
    public JButton signup;
    public JButton welcome;
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;
    public JLabel label4;
    public JLabel label5;
    public JTextField uname;
    public JTextField fname;
    public JTextField lname;
    public JPasswordField pass;
    
    public SignUp()
    {
        initGUI();
    }
    public void initGUI()
    {
        frame = new JFrame("Sign Up");
       frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        
        uname= new JTextField();
        fname= new JTextField();
        lname= new JTextField();
        pass= new JPasswordField();
        
        
        
        
        
        label4 = new JLabel("College ID ");
        label5 = new JLabel("Password ");
        label2 = new JLabel("First Name ");
        label3 = new JLabel("Last Name ");
        label1 = new JLabel("Evernt Management System");
        
        
        label1.setBounds(100, 10, 300, 50);
        label1.setForeground(Color.red);
        label1.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
        
        
        label2.setForeground(Color.white);
        label2.setBounds(65, 80, 100, 50);
        
        
        fname.setBounds(160, 90, 220, 30);
        frame.add(fname);
        
        
         label3.setForeground(Color.white);
        label3.setBounds(65, 150, 100, 50);
        
        
        lname.setBounds(160, 160, 220, 30);
        frame.add(lname);
        
        
         label4.setForeground(Color.white);
        label4.setBounds(65, 210, 100, 50);
        
        
        uname.setBounds(160, 220, 220, 30);
        frame.add(uname);
        
        
         label5.setForeground(Color.white);
        label5.setBounds(65, 270, 100, 50);
        
        
        pass.setBounds(160, 280, 220, 30);
        frame.add(pass);
        
        
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        
        signup= new JButton("Sign Up");
        welcome= new JButton("Back to Welcome");
       
         
      signup.setBounds(250, 350, 140, 30);
      welcome.setBounds(100, 350, 140, 30);
       
       frame.add(signup);
       frame.add(welcome);
        
        
        frame.setLocation(380, 100);
        frame.setSize(500, 470);
        
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
