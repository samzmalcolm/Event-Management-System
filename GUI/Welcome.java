
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Welcome {
    public JFrame frame;
    public JButton login;
    public JButton signup;
    public JLabel label1;
    public  JLabel label2;
    
    
    
    public Welcome()
    {
        initGUI();
    }
    
    public void initGUI()
    {
        try {
            frame = new JFrame("Welcome");
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);
            
            label1 = new JLabel("Welcome to");
            label2 = new JLabel("Event Management System");
            
            JPanel pp = new JPanel();
            pp.setLayout(new BorderLayout());
            BufferedImage myPicture = ImageIO.read(new File("1.JPG"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            pp.add(picLabel);
            
            pp.setSize(200, 100);
            pp.setLocation(95, 100);
            frame.add(pp);
            
            
            label1.setBounds(130, 10, 100, 50);
            label1.setForeground(Color.white);
            label1.setFont(new Font("lucida handwriting",Font.PLAIN,14 ));
            label2.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
            label2.setForeground(Color.red);
            label2.setBounds(55, 40, 300, 50);
            
            frame.add(label1);
            frame.add(label2);
            
            login= new JButton("User Login");
            signup= new JButton("User Sign Up");
            
            login.setBounds(120, 260, 140, 40);
            signup.setBounds(120, 330, 140, 40);
            frame.add(signup);
            frame.add(login);
            
            
            frame.setLocation(450, 100);
            frame.setSize(400, 500);
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
