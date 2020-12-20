
package Model;

public class Bookings {
    String eventTitle;
    String eventDesc;
    String eventDate;
    String eventTime;
    String user;
    String eventOrganization;
    String eventPlace;

    
    public Bookings()
    {
        eventTitle="";
        eventDesc="";
        eventDate="";
        eventTime="";
        user="";
        eventOrganization="";
        eventPlace="";
       
    }
    
    public Bookings(String et,String d,String ed,String t,String u,String o,String p)
    {
        eventTitle=et;
        eventDesc=d;
        eventDate=ed;
        eventTime=t;
        user=u;
        eventOrganization=o;
        eventPlace=p;
       
    }
    
    
    public String getEventTitle() {
        return eventTitle;
    }

  
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

 
    public String getEventDesc() {
        return eventDesc;
    }

  
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

 
    public String getEventDate() {
        return eventDate;
    }

 
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

 
    public String getEventTime() {
        return eventTime;
    }

  
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

 
    public String getUser() {
        return user;
    }

  
    public void setUser(String user) {
        this.user = user;
    }

  
    public String getEventOrganization() {
        return eventOrganization;
    }

   
    public void setEventOrganization(String eventOrganization) {
        this.eventOrganization = eventOrganization;
    }

 
    public String getEventPlace() {
        return eventPlace;
    }

  
    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }
    
    
    
}
