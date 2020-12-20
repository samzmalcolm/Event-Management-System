
package Model;

import Controllers.Controller;


public class EMS {
     public static void main(String[] args){
     
        Controller c = new Controller();
        c.setBindings();
        c.welcome.frame.setVisible(true);
       
    }
}
