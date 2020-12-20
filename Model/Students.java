
package Model;

public class Students {
    
    String id;
    String fname;
    String lname;
    String designation;
    String password;

    public Students()
    {
        id="";
        fname="";
        lname="";
        designation="";
        password="";
    } 
    
    public Students(String i,String f,String l,String d,String p)
    {
        id=i;
        fname=f;
        lname=l;
        designation=d;
        password=p;
    } 
    
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

 
    public String getFname() {
        return fname;
    }

 
    public void setFname(String fname) {
        this.fname = fname;
    }

  
    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getDesignation() {
        return designation;
    }

   
    public void setDesignation(String designation) {
        this.designation = designation;
    }

  
    public String getPassword() {
        return password;
    }

  
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
