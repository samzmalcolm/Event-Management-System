
package GUI;

import Config.Database;
import Controllers.Handler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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


public class StudentOwnBooking {
    
    public JFrame frame;
    public JPanel panel;
    public JPanel panel1;
    public JTable table;
    public DefaultTableModel model;
    public JTextField text;
    public JLabel search;
    public Handler hnd;
    public JLabel l2;
    public JButton back;
    public Database db;
    public StudentEventView ev;
    public StudentBookingView sbv;
    public BookingView bv;
    private TableRowSorter<TableModel> rowSorter;
    private JTextField jtFilter;
   
    
    public void getHnd(Handler h, Database dbase,StudentEventView eev,BookingView bvv,StudentBookingView sbvv)
    {
        hnd=h;
        db=dbase;
        ev=eev;
        bv=bvv;
        sbv=sbvv;
    }
    
    public StudentOwnBooking()
    {
        initGUI();
    }
    
     public void setTable()
    {
        
           // table colomn names 
            String y[]={"id","Title","Description","Time","Date","Organization/Location","Place"}; 
        
         model= new DefaultTableModel(y,0);
        
         // init table 
        table=new JTable(model);  
          
          //setting colomn widths 
          TableColumnModel tcm = table.getColumnModel();
             
          
          table.removeColumn(table.getColumnModel().getColumn(0));
          table.removeColumn(table.getColumnModel().getColumn(1));
          table.removeColumn(table.getColumnModel().getColumn(3));
          table.removeColumn(table.getColumnModel().getColumn(3));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        
        
          // setting row size 
          table.setRowHeight(35);
          
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
                String id = (String)table.getModel().getValueAt(selectedRow, 0);
                String title = (String)table.getModel().getValueAt(selectedRow, 1);
                String desc = (String)table.getModel().getValueAt(selectedRow, 2);
                String time = (String)table.getModel().getValueAt(selectedRow, 3);
                String date = (String)table.getModel().getValueAt(selectedRow, 4);
                String organ = (String)table.getModel().getValueAt(selectedRow, 5);
                String place = (String)table.getModel().getValueAt(selectedRow, 6);
               
             
                sbv.dtitle.setText(title);
                sbv.ddesc.setText(desc);
              
                sbv.dorgan.setText(organ);
                sbv.dplace.setText(place);
                sbv.dtime.setText(time);
                sbv.ddate.setText(date);
               
                
                frame.setVisible(false);
                sbv.frame.setVisible(true);
                
               
               
                
            }

             
        });
          
          
          
           rowSorter = new TableRowSorter<>(table.getModel());
           jtFilter = new JTextField();
           JLabel l= new JLabel("Search Booking: ");
           l.setBounds(430, 10, 140, 30);
             l.setFont(new Font("lucida handwriting",Font.PLAIN,14 ));
        l.setForeground(Color.red);
           jtFilter.setBounds(580, 10, 250, 30);
          panel1.add(l);
          
           table.setRowSorter(rowSorter);
          ///////////////////////////////////////////////////////////////
          
          
          
           
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
          
          popupMenu.add(view);
       
          table.setComponentPopupMenu(popupMenu);
         
         JScrollPane tableContainer1 = new JScrollPane(table);
          // adding table container in allpanel 
          panel.add(tableContainer1, BorderLayout.CENTER);
          frame.add(panel);
          frame.add(panel1);
          
    }

    public void initGUI()
    {
         frame = new JFrame("Student Panel");
         frame.getContentPane().setBackground(Color.black);
         frame.setLayout(null);
        
        panel = new JPanel();
        panel1 = new JPanel();
       
        JLabel l1= new JLabel("Your Bookings ");
        l1.setFont(new Font("lucida handwriting",Font.PLAIN,18 ));
        l1.setForeground(Color.red);
        
        l1.setBounds(350, 10, 200, 30);
      
        panel.setLayout(new BorderLayout());
        panel1.setLayout(null);
        
        panel.setSize(840,350);
        panel1.setSize(840,40);
        panel1.setLocation(20,60);
        panel.setLocation(20,110);
       
        panel.setBackground(Color.WHITE);
        panel1.setBackground(Color.black);
       
        setTable();
       
        back = new JButton("Student Panel");
        back.setBounds(380, 480, 140, 30);
        frame.add(back);
        
        frame.add(l1);
       
        frame.setLocation(250, 100);
        frame.setSize(900, 570);
        
           
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
