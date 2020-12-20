/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Config.Database;
import GUI.AdminBookings;
import GUI.AdminEventView;
import GUI.AdminOrganizers;
import GUI.AdminUser;
import GUI.BookingView;
import GUI.StudentEventView;
import GUI.Login;
import GUI.OUpdateOwnEvent;
import GUI.OrganizerEventView;
import GUI.OrganizerMain;
import GUI.OrganizerOwnEventView;
import GUI.OrganizerOwnEvents;
import GUI.OrganizerPostEvent;
import GUI.OwnBookings;
import GUI.SignUp;
import GUI.StudentBookingView;
import GUI.StudentGUI;
import GUI.StudentOwnBooking;
import GUI.Welcome;
import GUI.adminPanel;
import Model.Students;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Handler implements ActionListener{

    public Database d;
    public StudentEventView ev;
    public Welcome w;
    public OrganizerMain omain;
    public Login l;
    public SignUp s;
    public StudentGUI sg;
    public OwnBookings ownbook;
    public Students std;
    public BookingView bv;
    public StudentOwnBooking sob;
    public StudentBookingView sbv;
    public OrganizerEventView oev;
    public OrganizerOwnEvents ooe;
    public OrganizerOwnEventView ooev;
    public OrganizerPostEvent ope;
    public OUpdateOwnEvent ouwe;
    public adminPanel ap;
    public AdminEventView aev;
    public AdminBookings ab;
    public AdminUser au;
    public AdminOrganizers ao;
    
     public Handler() {
        
    }
    
    public void setRef(Welcome ww, Login ll, SignUp ss, Database dd, StudentGUI stt,Students stdd,StudentEventView eev,OrganizerMain om, OwnBookings ob,BookingView bbv,StudentOwnBooking sobb,StudentBookingView sbvv,OrganizerEventView oevv,OrganizerOwnEvents ooee,OrganizerOwnEventView ooevv,OrganizerPostEvent opee,OUpdateOwnEvent ouwee,adminPanel app,AdminEventView aevc,AdminBookings abb,AdminUser auu,AdminOrganizers aoo)
    {
        ao=aoo;
        au=auu;
        ab=abb;
        aev=aevc;
        ap=app;
        bv=bbv;
        ope=opee;
        ouwe=ouwee;
        w = ww;
        ooev=ooevv;
        oev=oevv;
        sbv=sbvv;
        ooe=ooee;
        l= ll;
        d=dd;
        omain=om;
        s=ss;
        ev=eev;
        sg= stt;
        std=stdd;
        ownbook=ob;
        sob=sobb;
       
    }
      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
      if(e.getActionCommand().equalsIgnoreCase("User Login"))
      {
         w.frame.setVisible(false);
         l.frame.setVisible(true);
          
      }
      
     if(e.getActionCommand().equalsIgnoreCase("Users"))
      {
          try {
              ap.frame.setVisible(false);
              d.SettingAdminUsers();
              au.frame.setVisible(true);
          } catch (SQLException ex) {
            
          }
          
      }
      
        
        if(e.getActionCommand().equalsIgnoreCase("Organizers"))
      {
          try {
              ap.frame.setVisible(false);
              d.SettingAdminOrganizers();
              ao.frame.setVisible(true);
          } catch (SQLException ex) {
            
          }
          
      }
       
      if(e.getActionCommand().equalsIgnoreCase("Back to Admin"))
      {
        
              au.frame.setVisible(false);
              ap.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Return to Admin"))
      {
      
             ao.frame.setVisible(false);
             ap.frame.setVisible(true);
          
      }
     
      if(e.getActionCommand().equalsIgnoreCase("Student Bookings"))
      {
         sbv.frame.setVisible(false);
         sob.frame.setVisible(true);
          
      }
       
      if(e.getActionCommand().equalsIgnoreCase("Admin panel"))
      {
         ab.frame.setVisible(false);
         ap.frame.setVisible(true);
          
      }
      
      if(e.getActionCommand().equalsIgnoreCase("Bookings"))
      {
         ap.frame.setVisible(false);
          try {
              d.SettingAdminBookingTable();
          } catch (SQLException ex) {
             
          }
          
          ab.frame.setVisible(true);
      }
       if(e.getActionCommand().equalsIgnoreCase("return Back"))
      {
         ouwe.frame.setVisible(false);
         ooe.frame.setVisible(true);
          
      }
         
      if(e.getActionCommand().equalsIgnoreCase("Back to Admin"))
      {
         aev.frame.setVisible(false);
         ap.frame.setVisible(true);
          
      }
       
      if(e.getActionCommand().equalsIgnoreCase("Post Event"))
      {
         omain.frame.setVisible(false);
         ope.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Return"))
      {
          
           ope.frame.setVisible(false);
           ope.title.setText("");
           ope.desc.setText("");
           ope.organ.setText("");
           ope.place.setText("");
           ope.time.setText("");
           ope.date.setText("");
           ope.rep.setText("");
           omain.frame.setVisible(true);
          
      }
         
      if(e.getActionCommand().equalsIgnoreCase("Post"))
      {
         
          String title=ope.title.getText();
          String desc=ope.desc.getText();
          String type=ope.types[ope.type.getSelectedIndex()];
          String organ=ope.organ.getText();
          String place=ope.place.getText();
          String time=ope.time.getText();
          String date=ope.date.getText();
          String rep=ope.rep.getText();

          if("".equals(title)||"".equals(desc)||"".equals(organ)||"".equals(place)||"".equals(time)||"".equals(date)||"".equals(rep))
          {
               JOptionPane.showMessageDialog(ope.frame, "Emty fields");
          }else{
              
             
              try {
                  d.postEvent(title, desc, type, organ, place, time, date, rep, std.getId());
                  
                  ope.title.setText("");
                  ope.desc.setText("");
                  ope.organ.setText("");
                  ope.place.setText("");
                  ope.time.setText("");
                  ope.date.setText("");
                  ope.rep.setText("");
                
                  int x=omain.model.getRowCount();
                  for(int i=0;i<x;i++)
                  {
                      omain.model.removeRow(0);
                  }
                  d.SettingOrganizerGuiTable();
                  ope.frame.setVisible(false);
                  omain.frame.setVisible(true);
              } catch (SQLException ex) {
                 
              }
                     }
    }
    if(e.getActionCommand().equalsIgnoreCase("Update"))
      {
       
          String title=ouwe.title.getText();
          String desc=ouwe.desc.getText();
          String type=ouwe.types[ope.type.getSelectedIndex()];
          String organ=ouwe.organ.getText();
          String place=ouwe.place.getText();
          String time=ouwe.time.getText();
          String date=ouwe.date.getText();
          String rep=ouwe.rep.getText();
         
          if("".equals(title)||"".equals(desc)||"".equals(organ)||"".equals(place)||"".equals(time)||"".equals(date)||"".equals(rep))
          {
               JOptionPane.showMessageDialog(ope.frame, "Emty fields");
          }else{
              
             
              try {
                 d.UpdateEvent(title, desc, type, organ, place, time, date, rep, ooe.eid);
                  
                  ope.title.setText("");
                  ope.desc.setText("");
                  ope.organ.setText("");
                  ope.place.setText("");
                  ope.time.setText("");
                  ope.date.setText("");
                  ope.rep.setText("");
                  
                  int x=omain.model.getRowCount();
                  for(int i=0;i<x;i++)
                  {
                      omain.model.removeRow(0);
                  }
                  d.SettingOrganizerGuiTable();
                  ouwe.frame.setVisible(false);
                  omain.frame.setVisible(true);
              } catch (SQLException ex) {
                 
              }
                     }
   
      }
     
    if(e.getActionCommand().equalsIgnoreCase("Back to Organizer Panel"))
      {
         ooe.frame.setVisible(false);
         omain.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Logout Organizer"))
      {
         omain.frame.setVisible(false);
         int x=omain.model.getRowCount();
          for(int i=0;i<x;i++)
              {
                  omain.model.removeRow(0);
              }
          
           int y=ownbook.model.getRowCount();
          for(int i=0;i<y;i++)
              {
                  ownbook.model.removeRow(0);
              }
           int z=ooe.model.getRowCount();
          for(int i=0;i<z;i++)
              {
                  ooe.model.removeRow(0);
              }
          l.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Back Own Events"))
      {
         ooev.frame.setVisible(false);
         ooe.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Own Events"))
      {
          try {
              omain.frame.setVisible(false);
              
              int x= ooe.model.getRowCount();
               for(int i=0;i<x;i++)
              {
                  ooe.model.removeRow(0);
              }
              
              d.SettingOrganizerOwnEvents();
              ooe.frame.setVisible(true);
          } catch (SQLException ex) {
            
          }
          
      }
      if(e.getActionCommand().equalsIgnoreCase("organizer Booking"))
      {
         bv.frame.setVisible(false);
         ownbook.frame.setVisible(true);
          
      }
         if(e.getActionCommand().equalsIgnoreCase("organizers panel"))
      {
         oev.frame.setVisible(false);
         omain.frame.setVisible(true);
          
      }
        
       
        if(e.getActionCommand().equalsIgnoreCase("Student Panel"))
      {
         sob.frame.setVisible(false);
         sg.frame.setVisible(true);
          
      }
       if(e.getActionCommand().equalsIgnoreCase("Own Booking"))
      {
          try {
              sg.frame.setVisible(false);
              int x= sob.model.getRowCount();
              for(int i=0;i<x;i++)
              {
                  sob.model.removeRow(0);
              }
              d.SettingStudentBookingTable(std.getId());
              sob.frame.setVisible(true);
          } catch (SQLException ex) {
            
          }
          
      }
      
       if(e.getActionCommand().equalsIgnoreCase("Own Bookings"))
      {
          try {
              omain.frame.setVisible(false);
              d.SettingOrganizerBookingTable(std.getId());
              ownbook.frame.setVisible(true);
          } catch (SQLException ex) {
             
          }
          
      }
      
      if(e.getActionCommand().equalsIgnoreCase("OKAY"))
      {
         bv.frame.setVisible(false);
         ownbook.frame.setVisible(true);
          
      }
      
      if(e.getActionCommand().equalsIgnoreCase("User Sign Up"))
      {
         w.frame.setVisible(false);
         s.frame.setVisible(true);
          
      }
       if(e.getActionCommand().equalsIgnoreCase("OK"))
      {
         ev.frame.setVisible(false);
         sg.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Logout user"))
      {
           sg.frame.setVisible(false);
         int x = sg.model.getRowCount();
         for(int i=0;i<x;i++)
         {
             sg.model.removeRow(0);
         }
         
         w.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Logout Admin"))
      {
           ap.frame.setVisible(false);
         int x = ap.model.getRowCount();
         for(int i=0;i<x;i++)
         {
             ap.model.removeRow(0);
         }
          w.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Welcome"))
      {
         l.uname.setText("");
         l.pass.setText("");
         l.frame.setVisible(false);
          w.frame.setVisible(true);
      }
         
      if(e.getActionCommand().equalsIgnoreCase("Organizer Panel"))
      {
         
          ownbook.frame.setVisible(false);
          omain.frame.setVisible(true);
          
      }
      if(e.getActionCommand().equalsIgnoreCase("Back to Welcome"))
      {
         s.fname.setText("");
         s.lname.setText("");
         s.uname.setText("");
         s.pass.setText("");
        
         s.frame.setVisible(false);
          w.frame.setVisible(true);
      }
      if(e.getActionCommand().equalsIgnoreCase("login"))
      {
         String u = l.uname.getText();
         String p = l.pass.getText();
         
         l.uname.setText("");
         l.pass.setText("");
         
          if("".equals(u)||"".equals(p))
          {
              JOptionPane.showMessageDialog(l.frame, "Empty Inputs");
          }else{
             try {
                 
                 boolean check = d.loginCheck(u, p);
                 if(check == true)
                 {
                     d.userInfo(u);
                   String des= std.getDesignation();
                     if("student".equals(des))
                     {
                     d.SettingStudentGuiTable();
                     String name=std.getFname();
                     name= name+" "+std.getLname();
                     sg.l2.setText(name);
                     l.frame.setVisible(false);
                     sg.frame.setVisible(true);   
                     }
                     
                      if("organizer".equals(des))
                     {
                     d.SettingOrganizerGuiTable();
                     String name=std.getFname();
                     name= name+" "+std.getLname();
                     omain.l2.setText(name);
                     l.frame.setVisible(false);
                     omain.frame.setVisible(true);   
                     }
                   
                     if("admin".equals(des))
                     {
                     d.SettingAdminGuiTable();
                    
                     String name= "Welcome, ";
                     name= name+std.getFname();
                     name= name+" ";
                     name= name+" "+std.getLname();
                     ap.l2.setText(name);
                     l.frame.setVisible(false);
                     ap.frame.setVisible(true);   
                     }
                    
                 }else{
                     JOptionPane.showMessageDialog(l.frame, "Invalid Id or Password");
                 }
                 
             } catch (SQLException ex) {}
          }
          
      }
       if(e.getActionCommand().equalsIgnoreCase("Sign Up"))
      {
          String f = s.fname.getText();
          String ln = s.lname.getText();
          String i = s.uname.getText();
          String de = "student";
          String p = s.pass.getText();
          
       if("".equals(f)||"".equals(ln)||"".equals(i)||"".equals(p))
          {
              JOptionPane.showMessageDialog(s.frame, "Empty Inputs");
          }else{
          
             
              try {
                  boolean check= d.userCheck(i);
                  if(check == true)
                  {
                      JOptionPane.showMessageDialog(s.frame, "User with this College Id Already Exists");
                      
                  }else{
                      s.fname.setText("");
                      s.lname.setText("");
                      s.uname.setText("");
                      s.pass.setText("");
                      
                          d.addUser(i,f,ln,de,p);
                          s.frame.setVisible(false);
                          l.frame.setVisible(true);
                     
                  }
                  
              } catch (SQLException ex) {
                  
              }
          }
          
          
         
      }
    
    }
    
}
