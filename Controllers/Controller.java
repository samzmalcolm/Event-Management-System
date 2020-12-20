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



public class Controller {
    
    public Welcome welcome;
    public OrganizerMain omain;
    public StudentEventView EventView;
    public Database database;
    public SignUp signup;
    public OrganizerOwnEventView ooev;
    public Handler hnd;
    public Login login;
    public StudentGUI std;
    public Students student;
    public OwnBookings ownBook;
    public BookingView bv;
    public StudentOwnBooking sob;
    public StudentBookingView sbv;
    public OrganizerEventView oev;
    public OrganizerOwnEvents ooe;
    public OrganizerPostEvent ope;
    public OUpdateOwnEvent ouwe;
    public adminPanel ap;
    public AdminEventView aev;
    public AdminBookings ab;
    public AdminUser au;
    public AdminOrganizers ao;
    
    public Controller()
    {
        welcome = new Welcome();
        database= new Database();
        EventView= new StudentEventView();
        login= new Login();
        ownBook = new OwnBookings();
        omain=new OrganizerMain();
        signup= new SignUp();
        std= new StudentGUI();
        hnd= new Handler();
        student= new Students();
        bv= new BookingView();
        sob= new StudentOwnBooking();
        sbv= new StudentBookingView();
        oev= new OrganizerEventView();
        ooe= new OrganizerOwnEvents();
        ooev= new OrganizerOwnEventView();
        ope= new OrganizerPostEvent();
        ouwe= new OUpdateOwnEvent();
        ap=new adminPanel();
        aev = new AdminEventView();
        ab=new AdminBookings();
        au=new AdminUser();
        ao= new AdminOrganizers();
        
    }
    
    public void setBindings()
    {
        welcome.login.addActionListener(hnd);
        welcome.signup.addActionListener(hnd);
        signup.signup.addActionListener(hnd);
        login.login.addActionListener(hnd);
        EventView.ok.addActionListener(hnd);
        std.logout.addActionListener(hnd);
        login.welcome.addActionListener(hnd);
        signup.welcome.addActionListener(hnd);
        omain.ownBookings.addActionListener(hnd);
        omain.ownEvents.addActionListener(hnd);
        omain.post.addActionListener(hnd);
        omain.logout.addActionListener(hnd);
        ownBook.back.addActionListener(hnd);
        std.booking.addActionListener(hnd);
        bv.ok.addActionListener(hnd);
        sbv.ok.addActionListener(hnd);
        sob.back.addActionListener(hnd);
        ooe.back.addActionListener(hnd);
        omain.post.addActionListener(hnd);
        ope.post.addActionListener(hnd);
        ope.returns.addActionListener(hnd);
        oev.ok.addActionListener(hnd);
        ooev.ok.addActionListener(hnd);
        omain.logout.addActionListener(hnd);
        ouwe.post.addActionListener(hnd);
        ouwe.returns.addActionListener(hnd);
        aev.ok.addActionListener(hnd);
        ap.bookings.addActionListener(hnd);
        ap.user.addActionListener(hnd);
        ap.Organizers.addActionListener(hnd);
        ap.logout.addActionListener(hnd);
        ab.back.addActionListener(hnd);
        ab.back.addActionListener(hnd);
        au.back.addActionListener(hnd);
        ao.back.addActionListener(hnd);
        hnd.setRef(welcome,login,signup,database,std,student,EventView,omain,ownBook,bv,sob,sbv,oev,ooe,ooev,ope,ouwe,ap,aev,ab,au,ao);
        std.getHnd(hnd,database,EventView);
        au.getHnd(hnd, database, EventView, bv);
        omain.getHnd(hnd,database,EventView,oev);
        ab.getHnd(hnd, database, EventView, bv);
        ao.getHnd(hnd, database, EventView, bv);
        database.setRef(std,omain,ownBook,sob,hnd,ooe);
        ownBook.getHnd(hnd, database, EventView, bv);
        sob.getHnd(hnd, database, EventView, bv,sbv);
        ooe.getHnd(hnd, database, EventView, bv,omain,ooev);
        ap.getHnd(hnd, database, EventView, bv, omain, ooev);
       
    }
    
    
}
