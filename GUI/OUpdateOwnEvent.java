
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class OUpdateOwnEvent {
           
    public JFrame frame;
    public JButton post;
    public JButton returns;
    public JLabel ltitle;
    public JLabel ldesc;
    public JLabel ltype;
    public JLabel lorgan;
    public JLabel lplace;
    public JLabel ltime;
    public JLabel ldate;
    public JLabel lrep;
    public String[] types;
    public JTextField title;
    public JTextField desc;
   

    public JComboBox type;
    
    public JTextField organ;
    public JTextField place;
    public JTextField time;
    public JTextField date;
    public JTextField rep;
  
    
    public OUpdateOwnEvent()
    {
        initGUI();
    }
    public void initGUI()
    {
        frame = new JFrame("Update Event");
       frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        
        title= new JTextField();
        desc= new JTextField();
       
        
        types = new String []{ "Internal", "External", "Online"};
        type = new JComboBox(types);
        type.setSelectedIndex(0);
      
        organ= new JTextField();
        place= new JTextField();
        time= new JTextField();
        date= new JTextField();
        rep= new JTextField();
               
        
        
        
        
        
        ltitle = new JLabel("Title: ");
        ldesc = new JLabel("Description: ");
        ltype = new JLabel("Type: ");
        lorgan = new JLabel("Organization: ");
        lplace = new JLabel("Place: ");
        ltime = new JLabel("Time: ");
        ldate = new JLabel("Date (dd/mm/yyyy)");
        lrep = new JLabel("Repetetion");
       
        
        JLabel l1= new JLabel("Event Management System");
        l1.setBounds(100, 10, 300, 50);
        l1.setForeground(Color.red);
        l1.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
        
        
        ltitle.setForeground(Color.white);
        ltitle.setBounds(60, 60, 100, 30);
        
        
        title.setBounds(175, 60, 220, 30);
        frame.add(title);
        
        
         ldesc.setForeground(Color.white);
        ldesc.setBounds(60, 100, 100, 30);
        
        
        desc.setBounds(175, 100, 220, 30);
        frame.add(desc);
        
        
        ltype.setForeground(Color.white);
        ltype.setBounds(60, 140, 100, 30);
        
        
        type.setBounds(175, 140, 220, 30);
        frame.add(type);
        
        
         lorgan.setForeground(Color.white);
        lorgan.setBounds(60, 180, 100, 30);
        
        
        organ.setBounds(175, 180, 220, 30);
        frame.add(organ);
        
         lplace.setForeground(Color.white);
        lplace.setBounds(60, 240, 100, 30);
        
        
        place.setBounds(175, 240, 220, 30);
        frame.add(place);
        
        
         lplace.setForeground(Color.white);
        lplace.setBounds(60, 240, 100, 30);
        
        
        place.setBounds(175, 240, 220, 30);
        frame.add(place);
        
        
          ltime.setForeground(Color.white);
        ltime.setBounds(60, 280, 100, 30);
        
        
        time.setBounds(175, 280, 220, 30);
        frame.add(time);
        
        
         ldate.setForeground(Color.white);
        ldate.setBounds(60, 320, 140, 30);
        
        
        date.setBounds(175, 320, 220, 30);
        frame.add(date);
        
        
         lrep.setForeground(Color.white);
        lrep.setBounds(60, 360, 100, 30);
        
        
        rep.setBounds(175, 360, 220, 30);
        frame.add(rep);
       
        
        
        frame.add(ltitle);
        frame.add(l1);
        frame.add(ldesc);
        frame.add(ltype);
        frame.add(lorgan);
        frame.add(lplace);
        frame.add(ltime);
        frame.add(ldate);
        frame.add(lrep);
        
        
        post= new JButton("Update");
        returns= new JButton("Return Back");
       
         
      post.setBounds(250, 420, 140, 30);
      returns.setBounds(100, 420, 140, 30);
       
       frame.add(post);
       frame.add(returns);
        
        
        frame.setLocation(380, 100);
        frame.setSize(500, 550);
        
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
