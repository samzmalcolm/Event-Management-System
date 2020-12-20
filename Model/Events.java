
package Model;


public class Events {
    int id;
    String title;
    String description;
    String type;
    String organization;
    String place;
    String time;
    String date;
    String repetetion;
    int participants;
    int limit;

    public Events()
    {
        id=0;
        title="";
        description="";
        type="";
        organization="";
        place="";
        time="";
        date="";
        participants=0;
        limit=0;
        
    }
    
     public Events(int iid,String t,String d,String ty,String o,String p,String ti,String da,int pa,int l)
    {
        id=iid;
        title=t;
        description=d;
        type=ty;
        organization=o;
        place=p;
        time=ti;
        date=da;
        participants=pa;
        limit=l;
        
    }
     
     
      public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

     
     
    public String getTitle() {
        return title;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }

    
     public String getRepetetion() {
        return repetetion;
    }

  
    public void setRepetetion(String repetetion) {
        this.repetetion = repetetion;
    }
    
   
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

   
    public String getType() {
        return type;
    }

   
    public void setType(String type) {
        this.type = type;
    }

   
    public String getOrganization() {
        return organization;
    }

   
    public void setOrganization(String organization) {
        this.organization = organization;
    }

  
    public String getPlace() {
        return place;
    }

  
    public void setPlace(String place) {
        this.place = place;
    }

   
    public String getTime() {
        return time;
    }

   
    public void setTime(String time) {
        this.time = time;
    }

   
    public String getDate() {
        return date;
    }

   
    public void setDate(String date) {
        this.date = date;
    }

   
    public int getParticipants() {
        return participants;
    }

   
    public void setParticipants(int participants) {
        this.participants = participants;
    }

   
    public int getLimit() {
        return limit;
    }

  
    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    
}
