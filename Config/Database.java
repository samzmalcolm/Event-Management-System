
package Config;

import Controllers.Handler;
import GUI.OrganizerMain;
import GUI.OrganizerOwnEvents;
import GUI.OwnBookings;
import GUI.StudentGUI;
import GUI.StudentOwnBooking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
 
        private static String DB_URL;
	private static String DB_User;
	private static String DB_PWD;
	public static Connection con;
	public StudentGUI sg;
	public OrganizerMain omain;
	public OwnBookings obook;
        public StudentOwnBooking sob;
        public Handler hnd;
        public OrganizerOwnEvents ooe;
                
	public Database()
	{
		DB_URL="jdbc:mysql://localhost:3306/ems";
		DB_User="root";
		DB_PWD="";
	}
        
        public void setRef(StudentGUI ssg,OrganizerMain om, OwnBookings ob,StudentOwnBooking sobb,Handler hh,OrganizerOwnEvents ooee)
        {
            ooe=ooee;
            sg=ssg;
            hnd=hh;
            omain=om;
            sob=sobb;
            obook=ob;
        }
        
	
        // open connection to database
	public void openConnection()
	{
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_User, DB_PWD);
		} catch (SQLException | ClassNotFoundException e) {
		}
	}
        
        // login check 
        public boolean loginCheck(String uname, String pwd) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
		String query1="select * from user where id = ? and password = ?";
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		ps1.setString(1, uname);
		ps1.setString(2, pwd);
		ResultSet s=null;
		
		boolean a = false;
		
		s=ps1.executeQuery();
		
		while(s.next())
		{
			a = true;
		}
		if(con!=null)
		{
			con.close();
		}
		return a;   
        }
        
         // user check
         
        public boolean userCheck(String uname) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
		String query1="select * from user where id = ?";
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		ps1.setString(1, uname);
		
		ResultSet s=null;
		
		boolean a = false;
		
		s=ps1.executeQuery();
		
		while(s.next())
		{
			a = true;
		}
		if(con!=null)
		{
			con.close();
		}
		return a;   
        }
        
          // designation check
          
        public String designationCheck(String uname) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
		String query1="select * from user where id = ?";
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		ps1.setString(1, uname);
		
		ResultSet s=null;
		
		String a = "";
		
		s=ps1.executeQuery();
		
		while(s.next())
		{
			a= s.getString("designation");
		}
		if(con!=null)
		{
			con.close();
		}
		return a;   
        }
         
         // add new user
           
        public void addUser(String i,String f,String l,String d,String p) throws SQLException
        {
            
            
         openConnection();
         
         
         PreparedStatement stmt;
         stmt=con.prepareStatement("INSERT INTO user (id,fname,lname,designation,password) VALUES ('"+i+"','"+f+"','"+l+"','"+d+"','"+p+"')");
         stmt.executeUpdate();
         
        }
         
           
           // get user information
        public void userInfo(String uname) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
		String query1="select * from user where id = ?";
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		ps1.setString(1, uname);
		
		ResultSet s=null;
		
		
		
		s=ps1.executeQuery();
		
		while(s.next())
		{
			hnd.std.setId(s.getString("id"));
                        hnd.std.setFname(s.getString("fname"));
                        hnd.std.setLname(s.getString("lname"));
                        hnd.std.setDesignation(s.getString("designation"));
		}
		if(con!=null)
		{
			con.close();
		}
		  
        }
        
           // get events info into student table  
        public void SettingStudentGuiTable() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from events";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		ResultSet s=null;
		s=ps1.executeQuery();
		
                String [] arr= new String[9];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("title"); 
                       arr[2]=s.getString("description"); 
                       arr[3]=s.getString("type"); 
                       arr[4]=s.getString("organization"); 
                       arr[5]=s.getString("place"); 
                       arr[6]=s.getString("time"); 
                       arr[7]=s.getString("date"); 
                       arr[8]=s.getString("repetetion"); 
                       
                       sg.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
         
        // add booking
         public void addBooking(String et,String edesc,String etime,String edate,String uid,String eorgan,String eplace, String id) throws SQLException
        {
             openConnection();
          
             int x= Integer.valueOf(id);
             
              
              PreparedStatement stmt;
              stmt=con.prepareStatement("INSERT INTO booking(etitle, edescription, etime, edate, uid,"
                      + " eorganization, eplace,eid) VALUES ('"+et+"','"+edesc+"','"+etime+"','"+edate+"','"+uid+"','"+eorgan+"','"+eplace+"','"+x+"')");
              stmt.executeUpdate();
         
         
        }
        
         public void SettingOrganizerGuiTable() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from events";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		
		
		ResultSet s=null;
		
		
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[9];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("title"); 
                       arr[2]=s.getString("description"); 
                       arr[3]=s.getString("type"); 
                       arr[4]=s.getString("organization"); 
                       arr[5]=s.getString("place"); 
                       arr[6]=s.getString("time"); 
                       arr[7]=s.getString("date"); 
                       arr[8]=s.getString("repetetion"); 
                       
                       omain.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
        public void SettingOrganizerBookingTable(String x) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from booking where uid=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
		
		ps1.setString(1, x);
		ResultSet s=null;
		
		int c=obook.model.getRowCount();
                for(int i=0;i<c;i++)
                {
                    obook.model.removeRow(0);
                }
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[8];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("etitle"); 
                       arr[2]=s.getString("edescription"); 
                       arr[3]=s.getString("etime"); 
                       arr[4]=s.getString("edate"); 
                       arr[5]=s.getString("eorganization"); 
                       arr[6]=s.getString("eplace"); 
                       arr[7]=s.getString("eid"); 
                      
                       
                       obook.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
        
        
         public void DeleteBooking(String x) throws SQLException
        {
            
         openConnection();
		PreparedStatement ps1=null;

		String query1="DELETE FROM booking WHERE id = ?";
                
    
            ps1 = con.prepareStatement(query1);
      
		int y = Integer.valueOf(x);
		ps1.setInt(1, y);
		
		int row=ps1.executeUpdate();
		
               
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
         
          public void SettingStudentBookingTable(String x) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from booking where uid=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
         
        }
		
		ps1.setString(1, x);
		ResultSet s=null;
		
		int c=obook.model.getRowCount();
                for(int i=0;i<c;i++)
                {
                    sob.model.removeRow(0);
                }
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[7];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("etitle"); 
                       arr[2]=s.getString("edescription"); 
                       arr[3]=s.getString("etime"); 
                       arr[4]=s.getString("edate"); 
                       arr[5]=s.getString("eorganization"); 
                       arr[6]=s.getString("eplace"); 
                      
                       
                       sob.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
        public void DeleteOwnEvent(String x) throws SQLException
        {
            
         openConnection();
		PreparedStatement ps1=null;

		String query1="DELETE FROM events WHERE id = ?";
                
    
            ps1 = con.prepareStatement(query1);
      
		int y = Integer.valueOf(x);
		ps1.setInt(1, y);
		 
		
		
		
		int row=ps1.executeUpdate();
		
               
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
        public void SettingOrganizerOwnEvents() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from events where uid=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		
		
		ResultSet s=null;
		
		ps1.setString(1, hnd.std.getId());
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[9];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("title"); 
                       arr[2]=s.getString("description"); 
                       arr[3]=s.getString("type"); 
                       arr[4]=s.getString("organization"); 
                       arr[5]=s.getString("place"); 
                       arr[6]=s.getString("time"); 
                       arr[7]=s.getString("date"); 
                       arr[8]=s.getString("repetetion"); 
                       
                       ooe.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
       
             public void DeleteEventsBooking(String x) throws SQLException
        {
            
         openConnection();
		PreparedStatement ps1=null;

		String query1="DELETE FROM booking WHERE eid = ?";
                
    
            ps1 = con.prepareStatement(query1);
      
		int y = Integer.valueOf(x);
		ps1.setInt(1, y);
		 
		int row=ps1.executeUpdate();
		
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
        public void postEvent(String et,String edesc,String etype,String eorgan,String eplace,String etime,String edate, String erep,String uid) throws SQLException
        {
             openConnection();
            int x=0;
           
              PreparedStatement stmt;
              stmt=con.prepareStatement("INSERT INTO events (title, description, type, "
                      + "organization, place, time, date, repetetion,participants,elimit,uid) "
                      + "VALUES ('"+et+"','"+edesc+"','"+etype+"','"+eorgan+"','"+eplace+"','"+etime+"'"
                              + ",'"+edate+"','"+erep+"','"+x+"','30','"+uid+"')");
              stmt.executeUpdate();
         
        }
         
        public void UpdateEvent(String et,String edesc,String etype,String eorgan,String eplace,String etime,String edate, String erep, int x) throws SQLException
        {
             openConnection();
            
              PreparedStatement stmt;
              stmt=con.prepareStatement("UPDATE events SET title='"+et+"',description='"+edesc+"',type='"+etype+"',organization='"+eorgan+"',place='"+eplace+"',time='"+etime+"',date='"+edate+"',repetetion='"+erep+"' WHERE id='"+x+"'");
              stmt.executeUpdate();
         
         
        }
          
        public boolean CheckParticipants( int x) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select participants from events where id=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		boolean a=false;
		
		ResultSet s=null;
		
		ps1.setInt(1,x);
              
		
		s=ps1.executeQuery();
		int check=0;
               
              
		while(s.next())
		{
                      check=s.getInt("participants");
		}
                
                if(check<30)
                {
                    a=true;
                }
                
		if(con!=null)
		{
			con.close();
		}
                return a;
              
        }
          
        public boolean CheckIfBookin( int x,String uname) throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from booking where uid=? and eid=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		boolean a=false;
		
		ResultSet s=null;
		
		ps1.setString(1,uname);
		ps1.setInt(2,x);
              
		
		s=ps1.executeQuery();
		
               
              
		while(s.next())
		{
                     a=true;
		}
                
               
                
		if(con!=null)
		{
			con.close();
		}
                return a;
              
        }
      
        public int getParticipants(int x) throws SQLException
        {
           
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from events where id=?";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		
		
		ResultSet s=null;
		
		ps1.setInt(1,x);
              
		
		s=ps1.executeQuery();
		int check=0;
               
              
		while(s.next())
		{
                      check=s.getInt("participants");
		}
                
                
		if(con!=null)
		{
			con.close();
		}
               return check;
              
        }
       
        public void UpdatePaticipants(int x, int p) throws SQLException
        {
             openConnection();
            
              PreparedStatement stmt;
              stmt=con.prepareStatement("UPDATE events SET participants='"+p+"' WHERE id='"+x+"'");
              stmt.executeUpdate();
         
        }
       
         public void SettingAdminGuiTable() throws SQLException
        {
           openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from events";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
           
        }
	     ResultSet s=null;
		
		s=ps1.executeQuery();
		
                String [] arr= new String[9];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("title"); 
                       arr[2]=s.getString("description"); 
                       arr[3]=s.getString("type"); 
                       arr[4]=s.getString("organization"); 
                       arr[5]=s.getString("place"); 
                       arr[6]=s.getString("time"); 
                       arr[7]=s.getString("date"); 
                       arr[8]=s.getString("repetetion"); 
                       
                       hnd.ap.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
        public void DeleteAdminEvent(String x) throws SQLException
        {
            
         openConnection();
		PreparedStatement ps1=null;

		String query1="DELETE FROM events WHERE id = ?";
                
    
            ps1 = con.prepareStatement(query1);
             int y= Integer.valueOf(x);       
		ps1.setInt(1, y);
		 
		
		int row=ps1.executeUpdate();
		
		if(con!=null)
		{
			con.close();
		}
                
              
        }
    
        public void SettingAdminBookingTable() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from booking";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
          
        }
		
		ResultSet s=null;
		
		int c=hnd.ab.model.getRowCount();
                for(int i=0;i<c;i++)
                {
                    hnd.ab.model.removeRow(0);
                }
              
		s=ps1.executeQuery();
		
                String [] arr= new String[9];
              
		while(s.next())
		{
                       arr[0]=Integer.toString(s.getInt("id")); 
                       arr[1]=s.getString("etitle"); 
                       arr[2]=s.getString("edescription"); 
                       arr[3]=s.getString("etime"); 
                       arr[4]=s.getString("edate"); 
                       arr[5]=s.getString("uid"); 
                       arr[6]=s.getString("eorganization"); 
                       arr[7]=s.getString("eplace"); 
                       arr[8]=s.getString("eid"); 
                      
                       
                       hnd.ab.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
       
        public void SettingAdminUsers() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from user where designation = 'student'";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
            
        }
		

		ResultSet s=null;
		
		int c=hnd.au.model.getRowCount();
                for(int i=0;i<c;i++)
                {
                    hnd.au.model.removeRow(0);
                }
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[3];
              
		while(s.next())
		{
                       
                       arr[2]=s.getString("id"); 
                       arr[0]=s.getString("fname"); 
                       arr[1]=s.getString("lname"); 
                      
                      
                       
                       hnd.au.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
             
        }
       public void MakeOrganizer(String x) throws SQLException
        {
             openConnection();
              String y= "organizer";
              PreparedStatement stmt;
              stmt=con.prepareStatement("UPDATE user SET designation='"+y+"' WHERE id='"+x+"'");
              stmt.executeUpdate();
         
         
        }
       
            
                public void SettingAdminOrganizers() throws SQLException
        {
         openConnection();
		PreparedStatement ps1=null;
                
		String query1="select * from user where designation = 'organizer'";
                
        try {
            ps1 = con.prepareStatement(query1);
        } catch (SQLException ex) {
            
        }
		

		ResultSet s=null;
		
		int c=hnd.ao.model.getRowCount();
                for(int i=0;i<c;i++)
                {
                    hnd.ao.model.removeRow(0);
                }
              
		
		s=ps1.executeQuery();
		
                String [] arr= new String[3];
              
		while(s.next())
		{
                       
                       arr[2]=s.getString("id"); 
                       arr[0]=s.getString("fname"); 
                       arr[1]=s.getString("lname"); 
                      
                      
                       
                       hnd.ao.model.addRow(arr);
                        
		}
                
                
		if(con!=null)
		{
			con.close();
		}
                
              
        }
         
        public void DemoteOrganizer(String x) throws SQLException
        {
             openConnection();
              String y= "student";
              PreparedStatement stmt;
              stmt=con.prepareStatement("UPDATE user SET designation='"+y+"' WHERE id='"+x+"'");
              stmt.executeUpdate();
         
         
        }
       
                
}
