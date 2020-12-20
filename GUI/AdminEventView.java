/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class AdminEventView {
    
       
    public JFrame frame;
    public JPanel panel;  
    public  JButton ok;
 
    
    public JLabel title;
    public JLabel desc;
    public JLabel type;
    public JLabel organ;
    public JLabel place;
    public JLabel time;
    public JLabel date;
    public JLabel rep;
   
    public JLabel dtitle;
    public JTextArea ddesc;
    public JLabel dtype;
    public JLabel dorgan;
    public JLabel dplace;
    public JLabel dtime;
    public JLabel ddate;
    public JLabel drep;
    
    public AdminEventView()
    {
        initDetails();
    }
    
    public void initDetails()
    {
        frame = new JFrame();
        
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        
        title = new JLabel("Title: ");
        desc = new JLabel("Description: ");
        type = new JLabel("Type: ");
        organ = new JLabel("Organization: ");
        place = new JLabel("Place: ");
        time = new JLabel("Time: ");
        date = new JLabel("Date: ");
        rep = new JLabel("Repetetion: ");
        
        
        
        dtitle = new JLabel("name");
        ddesc = new JTextArea(5, 200);
        ddesc.setEditable(false);
        ddesc.setBackground(Color.gray);
        dtype = new JLabel("name");
        dorgan = new JLabel("name");
        dplace = new JLabel("name");
        dtime = new JLabel("name");
        ddate = new JLabel("name");
        drep = new JLabel("name");
       
       
       JLabel l1= new JLabel("Event Mangement System");
       l1.setFont(new Font("lucida handwriting",Font.PLAIN,14 ));
       l1.setForeground(Color.WHITE);
        
       l1.setBounds(60, 10, 200, 30);
       frame.add(l1);
        
        
        title.setBounds(30, 50, 100, 40);
        desc.setBounds(30, 100, 100, 40);
        type.setBounds(30, 180, 100, 40);
        organ.setBounds(30, 230, 100, 40);
        place.setBounds(30, 280, 100, 40);
        time.setBounds(30, 330, 100, 40);
        date.setBounds(30, 380, 100, 40);
        rep.setBounds(30, 430, 100, 40);
       
        
        dtitle.setBounds(120, 50, 200, 40);
        ddesc.setBounds(120, 110, 200, 80);
        dtype.setBounds(120, 180, 200, 40);
        dorgan.setBounds(120, 230, 200, 40);
        dplace.setBounds(120, 280, 200, 40);
        dtime.setBounds(120, 330, 200, 40);
        ddate.setBounds(120, 380, 200, 40);
        drep.setBounds(120, 430, 200, 40);
        
        
        frame.add(title);
        frame.add(desc);
        frame.add(type);
        frame.add(organ);
        frame.add(place);
        frame.add(time);
        frame.add(date);
        frame.add(rep);
        
        
        frame.add(dtitle);
        frame.add(ddesc);
        frame.add(dtype);
        frame.add(dorgan);
        frame.add(dplace);
        frame.add(dtime);
        frame.add(ddate);
        frame.add(drep);
        
        ok = new JButton("Back to Admin");
        ok.setBounds(125, 500, 80, 25);
        
        frame.add(ok);
        
        frame.setLocation(480, 60);
        frame.setSize(350, 600);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        
}
}
