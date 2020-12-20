
package GUI;

import Config.Database;
import Controllers.Handler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class adminPanel {
    public JFrame frame;
    public JPanel panel;
    public JPanel panel1;
    public JTable table;
    public DefaultTableModel model;
    public JTextField text;
    public JLabel search;
    public Handler hnd;
    public JLabel l2;
    public JButton bookings;
    public JButton logout;
    public JButton user;
    public JButton Organizers;
    public Database db;
    public StudentEventView ev;
    public OrganizerOwnEventView ooev;
    public BookingView bv;
    public OrganizerMain omain;
    private TableRowSorter<TableModel> rowSorter;
    private JTextField jtFilter;
    public int eid;
    
    
    public void getHnd(Handler h, Database dbase,StudentEventView eev,BookingView bvv,OrganizerMain oma,OrganizerOwnEventView ooevv)
    {
        hnd=h;
        ooev=ooevv;
        db=dbase;
        omain=oma;
        ev=eev;
        bv=bvv;
    }
    
    public adminPanel()
    {
        initGUI();
    }
    
     public void setTable()
    {
        
        // table colomn names 
        String y[]={"id","Title","Description","Type","Organization/Location","Place/Url","Time","Date","Repetetion"}; 
        
         model= new DefaultTableModel(y,0);
        
         // init table 
        table=new JTable(model);  
          
          //setting colomn widths 
          TableColumnModel tcm = table.getColumnModel();
             
          
          table.removeColumn(table.getColumnModel().getColumn(0));
          table.removeColumn(table.getColumnModel().getColumn(1));
          table.removeColumn(table.getColumnModel().getColumn(2));
          table.removeColumn(table.getColumnModel().getColumn(2));
          table.removeColumn(table.getColumnModel().getColumn(2));
          table.removeColumn(table.getColumnModel().getColumn(3));
     
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        
        
          // setting row size 
          table.setRowHeight(50);
            
         // init popup menu 
         final JPopupMenu popupMenu = new JPopupMenu();
          JMenuItem view = new JMenuItem("   View Details           ");
          
          // adding action listner 
          view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                // getting the selected row 
                int selectedRow = table.getSelectedRow();
               
                //converting the row index
                selectedRow = table.convertRowIndexToModel(selectedRow);
                
                // getting values of the selected row 
                
                // getting values of the selected row 
                String id = (String)table.getModel().getValueAt(selectedRow, 0);
               
                String title = (String)table.getModel().getValueAt(selectedRow, 1);
                String desc = (String)table.getModel().getValueAt(selectedRow, 2);
                String type = (String)table.getModel().getValueAt(selectedRow, 3);
                String organ = (String)table.getModel().getValueAt(selectedRow, 4);
                String place = (String)table.getModel().getValueAt(selectedRow, 5);
                String time = (String)table.getModel().getValueAt(selectedRow, 6);
                String date = (String)table.getModel().getValueAt(selectedRow, 7);
                String rep = (String)table.getModel().getValueAt(selectedRow, 8);
                
                hnd.aev.dtitle.setText(title);
                hnd.aev.ddesc.setText(desc);
                hnd.aev.dtype.setText(type);
                hnd.aev.dorgan.setText(organ);
                hnd.aev.dplace.setText(place);
                hnd.aev.dtime.setText(time);
                hnd.aev.ddate.setText(date);
                hnd.aev.drep.setText(rep);
                
                frame.setVisible(false);
                hnd.aev.frame.setVisible(true);
              
            
                
            }

             
        });
          
           rowSorter = new TableRowSorter<>(table.getModel());
           jtFilter = new JTextField();
           JLabel l= new JLabel("Search: ");
           l.setBounds(500, 10, 140, 30);
           l.setFont(new Font("lucida handwriting",Font.PLAIN,14 ));
           l.setForeground(Color.red);
           jtFilter.setBounds(580, 10, 250, 30);
           panel1.add(l);
          
           table.setRowSorter(rowSorter);
          
           jtFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                }

        });
           
          
          ////////////////////////////////////////////////////////////////
          panel1.add(jtFilter);
          
          // init popup menu 
        
          JMenuItem cancelBook = new JMenuItem("   Delete Event                            ");
          
          // adding action listner 
          cancelBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
              
                try {
                    // getting the selected row
                    int selectedRow = table.getSelectedRow();
                    
                    //converting the row index
                    selectedRow = table.convertRowIndexToModel(selectedRow);
                    
                    // getting values of the selected row
                    String id = (String)table.getModel().getValueAt(selectedRow, 0);
                    
                    
                    
                    db.DeleteAdminEvent(id);
                    
                    db.DeleteEventsBooking(id);
                    
                  
                  
                    
                    model.removeRow(selectedRow);
                  
                    
                    JOptionPane.showMessageDialog(frame, "Event has Successfully Deleted");
                } catch (SQLException ex) {
                  
                }
             
                
            }

             
        });
       
          
     
        popupMenu.add(view);
        popupMenu.addSeparator();
        popupMenu.add(cancelBook);
       table.setComponentPopupMenu(popupMenu);
        
        JScrollPane tableContainer1 = new JScrollPane(table);
          // adding table container in allpanel 
          panel.add(tableContainer1, BorderLayout.CENTER);
           frame.add(panel);
           frame.add(panel1);
          
    }

    
    
    public void initGUI()
    {
         frame = new JFrame("Admin Panel");
       frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        
        
        
        panel = new JPanel();
        panel1 = new JPanel();
       
        l2= new JLabel("hello");
         l2.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
        l2.setForeground(Color.red);
        
        l2.setBounds(300, 10, 400, 30);
      
       
        panel.setLayout(new BorderLayout());
        panel1.setLayout(null);
        
        panel.setSize(840,350);
        panel1.setSize(840,40);
         panel1.setLocation(20,60);
        panel.setLocation(20,110);
       
        panel.setBackground(Color.WHITE);
        panel1.setBackground(Color.black);
       
        setTable();
       
       bookings = new JButton("Bookings");
        bookings.setBounds(160, 480, 140, 30);
        frame.add(bookings);
        
         user = new JButton("Users");
        user.setBounds(310, 480, 140, 30);
        frame.add(user);
        
        
          Organizers = new JButton("Organizers");
        Organizers.setBounds(460, 480, 140, 30);
        frame.add(Organizers);
        
        
         logout = new JButton("Logout Admin");
        logout.setBounds(610, 480, 140, 30);
        frame.add(logout);
        
       
        frame.add(l2);
       
       
        frame.setLocation(250, 100);
        frame.setSize(900, 570);
        
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
