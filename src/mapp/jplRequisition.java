
package mapp;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.print.PrinterException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger; 
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import utility.DBconnection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Unknown
 */
public class jplRequisition extends JPanel {
    final int pWidth = 850;
    final int pHeight = 490;
    JMenuItem gohome;
    JPanel home;
    private static Connection conn;
    int ItemId;
    double newval,newval1;
    
    public jplRequisition(JPanel jplMain,JMenuItem gohome) {
        initComponents();
        
        this.setSize(pWidth, pHeight);
        int x = (jplMain.getWidth()-pWidth)/2;
        int y = (jplMain.getHeight()-pHeight)/2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.home=jplMain;
        this.gohome=gohome;
        initialization();
        initializeCollector();
        fillcombo();
    }

    public void initialization(){
        tfDistributionId.setText("");
        tfCollector.setText("");
        tfUnitPrice.setText("");
        tfQuantity.setText("");
        
        tfDistributionId.setEditable(false);
        tfDistributionDate.setEditable(false);
        tfUnitPrice.setEditable(false);
        tfUserCode1.setVisible(false);
        bnPrint.setVisible(false);   
    }
    public void initializeCollector(){
        tfCollectorId.setText("");
        tfCollector.setText("");
        tfAddress.setText("");
        tfCollectorId.setEditable(false);
        cbCollectorName.setEnabled(false);   
    }
    private void fillcombo(){
        String query="select Item_name from item";
        try{
           
            ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
            while(rs.next()){
            cbItem.addItem(rs.getString("Item_name"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    private void fillcomboCollector(){
        String query="select Collector_name from collector";
        try{
           
            ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
            while(rs.next()){
            cbCollectorName.addItem(rs.getString("Collector_name"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    private void retrieveCollectorDetails(){
        String query="select * from collector where Collector_name='"+cbCollectorName.getSelectedItem().toString().trim()+"'";
            
            try{
                ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
                while(rs.next()){
                    tfCollectorId.setText(rs.getString("Collector_id"));
                    tfCollector.setText(rs.getString("Collector_name"));
                    tfAddress.setText(rs.getString("Address"));
                    
                }
                tfCollectorId.setEditable(false);
                tfCollector.setEditable(false);
                tfAddress.setEditable(false);
                
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                cbCollectorName.removeAll();
                fillcomboCollector();
            }
    }
    public void displayForm(JPanel jp){
            home.removeAll();
            home.add(jp);
            home.validate();
            home.repaint();
        }
    public void DIDandDate(){
        //Date
        Calendar cal= new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        //Time
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        tfDistributionId.setText("DID"+Integer.toString(year)+Integer.toString(month+1)+Integer.toString(day)+Integer.toString(hour)+Integer.toString(minute)+Integer.toString(second));
        tfDistributionDate.setText(Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(year));
        
    }
    public void CollectorId(){
        String query="INSERT INTO `stores_db`.`collector` (`Collector_id`, `Collector_name`, `Address`, `Date`, `Requisition_id`) VALUES (NULL,'"+tfCollector.getText()+"','"+tfAddress.getText()+"','"+tfDistributionDate.getText()+"','"+tfDistributionId.getText()+"')";
        
        try{
           if(utility.DBconnection.getStatement().executeUpdate(query)>0){
               //JOptionPane.showMessageDialog(null, "Successfully saved Item");
                
           }else{
               JOptionPane.showMessageDialog(null, "Could not save Collector");
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void setCollectorId(){
        String query="select Collector_id from collector where Collector_name='"+tfCollector.getText().toString()+"'";
            
            try{
                ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
                while(rs.next()){
                    tfCollectorId.setText(rs.getString("Collector_id"));
                }
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
    }
    private void retrieveItemDetails(){
        String query="select * from item where Item_name='"+cbItem.getSelectedItem().toString().trim()+"'";
            
            try{
                ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
                while(rs.next()){
                    tfUnitPrice.setText(rs.getString("Unit_price"));
                    ItemId=Integer.parseInt(rs.getString("Item_id"));
                }  
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfDistributionId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfUnitPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bnSearch = new javax.swing.JButton();
        bnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        tfDistributionDate = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        cbItem = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReciept = new javax.swing.JTextArea();
        bnPrint = new javax.swing.JButton();
        bnNew = new javax.swing.JButton();
        bnDone = new javax.swing.JButton();
        tfUserCode1 = new javax.swing.JTextField();
        bnSearch1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfCollectorId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCollector = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        cbCollectorName = new javax.swing.JComboBox<>();
        rbCollector = new javax.swing.JRadioButton();
        bnClear = new javax.swing.JButton();
        bnViewAll = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Item:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Unit Price:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Requisition Date");

        bnSearch.setBackground(new java.awt.Color(255, 255, 255));
        bnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-search-icon.png"))); // NOI18N
        bnSearch.setText("Search");
        bnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSearchActionPerformed(evt);
            }
        });

        bnSave.setBackground(new java.awt.Color(255, 255, 255));
        bnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/Button-Add-icon.png"))); // NOI18N
        bnSave.setText("Add");
        bnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Requisition");

        bnClose.setBackground(new java.awt.Color(255, 255, 255));
        bnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-close blue-icon.png"))); // NOI18N
        bnClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnCloseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Requisition ID:");

        cbItem.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbItemPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txtReciept.setEditable(false);
        txtReciept.setColumns(20);
        txtReciept.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        txtReciept.setRows(5);
        txtReciept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jScrollPane2.setViewportView(txtReciept);

        bnPrint.setBackground(new java.awt.Color(255, 255, 255));
        bnPrint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-print-icon.png"))); // NOI18N
        bnPrint.setText("Print");
        bnPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnPrintActionPerformed(evt);
            }
        });

        bnNew.setBackground(new java.awt.Color(255, 255, 255));
        bnNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-Item-Bag-icon.png"))); // NOI18N
        bnNew.setText("New");
        bnNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnNewActionPerformed(evt);
            }
        });

        bnDone.setBackground(new java.awt.Color(255, 255, 255));
        bnDone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-confirm-security-icon.png"))); // NOI18N
        bnDone.setText("Save");
        bnDone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDoneActionPerformed(evt);
            }
        });

        tfUserCode1.setText("0");

        bnSearch1.setBackground(new java.awt.Color(255, 255, 255));
        bnSearch1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-transaction chart-icon.png"))); // NOI18N
        bnSearch1.setText("Requisitions");
        bnSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSearch1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Collector Details"));
        jPanel1.setName("Collector Details"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Collector Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Collector ID:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Address:");

        cbCollectorName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCollectorNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        rbCollector.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbCollector.setText("Select Existing");
        rbCollector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCollectorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(tfAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfCollector, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCollectorName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rbCollector)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(tfCollectorId))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCollectorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCollector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCollectorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCollector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bnClear.setBackground(new java.awt.Color(255, 255, 255));
        bnClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-clear.png"))); // NOI18N
        bnClear.setText("Clear");
        bnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnClearActionPerformed(evt);
            }
        });

        bnViewAll.setBackground(new java.awt.Color(255, 255, 255));
        bnViewAll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnViewAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-view.png"))); // NOI18N
        bnViewAll.setText("View All");
        bnViewAll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bnDone)
                        .addGap(18, 18, 18)
                        .addComponent(bnClear)
                        .addGap(18, 18, 18)
                        .addComponent(bnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDistributionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(40, 40, 40)
                            .addComponent(tfDistributionId))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(100, 100, 100)
                            .addComponent(cbItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(tfUnitPrice)))))
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bnSearch)
                        .addGap(47, 47, 47)
                        .addComponent(bnSearch1)
                        .addGap(50, 50, 50)
                        .addComponent(bnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(bnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bnClose)
                            .addComponent(bnViewAll)
                            .addComponent(bnSearch)
                            .addComponent(bnSearch1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfDistributionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDistributionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnNew)
                            .addComponent(bnDone)
                            .addComponent(bnSave)
                            .addComponent(bnClear)
                            .addComponent(bnPrint))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSaveActionPerformed
    if (tfCollector.getText().isEmpty() || tfAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Complete collector details");
            return;
        }
        DIDandDate();
        if (tfCollectorId.getText().isEmpty()){
           CollectorId();
           setCollectorId();
        }
        
        if (tfDistributionId.getText().isEmpty() || tfDistributionDate.getText().isEmpty()|| tfCollector.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Complete all fieds");
            return;
        }
        if (tfQuantity.getText().isEmpty()||tfUnitPrice.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Unit Cost and Quantity field cannot be empty");
            return;
        }
        String valu,ds;
                    double intvalue;
         try {
        Double.parseDouble(tfQuantity.getText());
        Double.parseDouble(tfUnitPrice.getText());
         } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Quantity must be an integer");
            tfQuantity.setText("");
            return;
        }
        String s,q,p;
        Double quantity,price,total;
        q=tfQuantity.getText();
        p=tfUnitPrice.getText();
        quantity=Double.parseDouble(q);
        price=Double.parseDouble(p);
        total=price * quantity;
        s=txtReciept.getText();
        Double initial;
        String initialString;
        initialString=tfUserCode1.getText();
        initial=Double.parseDouble(initialString);
        initial = initial + total;
        tfUserCode1.setText(initial.toString());
          
       
            txtReciept.append("\n"+cbItem.getSelectedItem().toString()+ "\t\t      "+ p+" X "+ q+"\t\t   ₵" + total);
       
        String query="insert into requisition(Requisition_id,Item_id,Collector_id,Quantity,Price,Username,Requisition_date) values ('"+tfDistributionId.getText()+"','"+ItemId+"','"+tfCollectorId.getText()+"', '"+tfQuantity.getText()+"','"+total+"','"+utility.Utility.username+"', '"+tfDistributionDate.getText()+"')";
        try{
           if(utility.DBconnection.getStatement().executeUpdate(query)>0){
              
                
                String query1 = "Select * from item where Item_name='"+cbItem.getSelectedItem().toString()+"'";
          
               ResultSet rs = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs.next()){
                   
                    valu=rs.getString("Quantity");
                    intvalue=Double.parseDouble(valu);
               ds=tfQuantity.getText();
                newval1=Double.parseDouble(ds);
               newval = intvalue - newval1;
                }
               if (newval >= 0){
                    String query2 = "update item set Quantity='"+newval+"' where Item_name='"+cbItem.getSelectedItem().toString()+"'";
                   if (utility.DBconnection.getStatement().executeUpdate(query2)>0){
                    JOptionPane.showMessageDialog(null, "Successfully added Requisition");
                    tfQuantity.setText("");
               
           }else{
               JOptionPane.showMessageDialog(null, "Could not add data");
           }
               }
                
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
               
    }//GEN-LAST:event_bnSaveActionPerformed

    private void bnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSearchActionPerformed
        tfDistributionId.setEnabled(true);
        tfDistributionId.setEditable(true);
              if (bnSearch.getText().equals("Search")){
            if (tfDistributionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Requisition ID");
                return;  
            }
            
            try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();
           
           String transactionId=tfDistributionId.getText();
           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     requisition.`Requisition_id` AS requisition_Requisition_id,\n" +
"     requisition.`Item_id` AS requisition_Item_id,\n" +
"     requisition.`Collector_id` AS requisition_Collector_id,\n" +
"     requisition.`Quantity` AS requisition_Quantity,\n" +
"     requisition.`Price` AS requisition_Price,\n" +
"     requisition.`Username` AS requisition_Username,\n" +
"     requisition.`Requisition_date` AS requisition_Requisition_date\n" +
"FROM\n" +
"     `requisition` requisition where Requisition_id='"+ transactionId + "'";
           JRDesignQuery newQuery =new JRDesignQuery();
           newQuery.setText(sql);
           jd.setQuery(newQuery);
           JasperReport jr = JasperCompileManager.compileReport(jd);
           JasperPrint jp = JasperFillManager.fillReport(jr,para,conn);
           JasperViewer.viewReport(jp, false);
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
        
        } 
      
    }//GEN-LAST:event_bnSearchActionPerformed

    private void bnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnCloseActionPerformed

        if (utility.Utility.universalCode == 1){
            int res=JOptionPane.showConfirmDialog(null, "Do you want to save changes?","Warning",JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION){
                if (bnSearch.getText().equals("Update")){
                    bnSearch.doClick();
                }else{
                    bnSave.doClick();
                }
            }else{
                this.gohome.doClick();
            }
        }else{
            this.gohome.doClick();
        }
    }//GEN-LAST:event_bnCloseActionPerformed

    private void bnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnPrintActionPerformed
if (txtReciept.getText().isEmpty())
{
    return;
}       
            try{
                 txtReciept.print();
            }
       catch(PrinterException ex)
       {
           Logger.getLogger(jplRequisition.class.getName()).log(Level.SEVERE, null ,ex);
       }
        
    }//GEN-LAST:event_bnPrintActionPerformed

    private void bnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnNewActionPerformed
        retrieveItemDetails();
        tfQuantity.setEditable(true);
        txtReciept.setText(null);
        txtReciept.append("\n");
        txtReciept.append("\t     Store Management System\n\n" +
                
                "Receipt No:" + tfDistributionId.getText() +"\t\tDate:" + tfDistributionDate.getText()+"\n" +
                "Collector:"+tfCollector.getText() + "\n" +
                "+==================================================+\n" +
                "\t          RECEIPT VOUCHER\n" +
                "+==================================================+\n" +
                
                "Item Name\tUnit Price x Quantity\tSub Total" );
       
      bnSave.setEnabled(true);
      bnPrint.setVisible(false);
    }//GEN-LAST:event_bnNewActionPerformed

    private void bnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDoneActionPerformed
if (txtReciept.getText().isEmpty())
{
    return;
}
        String tot;
        tot= tfUserCode1.getText();
        txtReciept.append("\n");
        txtReciept.append("\n" +
          
                "+==================================================+\n" +
                
                "\t\tTotal:\t\t\t  ₵"+ tot +
                "\n\n\tThanks for working with us..." 
        );
        bnSave.setEnabled(false);
        bnPrint.setVisible(true);
    }//GEN-LAST:event_bnDoneActionPerformed

    private void bnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSearch1ActionPerformed

        try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();

           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     requisition.`Requisition_id` AS requisition_Requisition_id,\n" +
"     requisition.`Item_id` AS requisition_Item_id,\n" +
"     requisition.`Collector_id` AS requisition_Collector_id,\n" +
"     requisition.`Quantity` AS requisition_Quantity,\n" +
"     requisition.`Price` AS requisition_Price,\n" +
"     requisition.`Username` AS requisition_Username,\n" +
"     requisition.`Requisition_date` AS requisition_Requisition_date\n" +
"FROM\n" +
"     `requisition` requisition";
           JRDesignQuery newQuery =new JRDesignQuery();
           newQuery.setText(sql);
           jd.setQuery(newQuery);
           JasperReport jr = JasperCompileManager.compileReport(jd);
           JasperPrint jp = JasperFillManager.fillReport(jr,para,conn);
           JasperViewer.viewReport(jp,false);
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
        
    }//GEN-LAST:event_bnSearch1ActionPerformed

    private void rbCollectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCollectorMouseClicked
        if (rbCollector.isSelected()){
            fillcomboCollector();
            cbCollectorName.setEnabled(true);
            tfCollectorId.setText("");
            tfCollector.setText("");
            tfAddress.setText("");
            tfCollectorId.setEditable(false);
            tfCollector.setEditable(false);
            tfAddress.setEditable(false);
            retrieveCollectorDetails();
            
        } else{
            initializeCollector();
            tfCollector.setEditable(true);
            tfAddress.setEditable(true);
            
        }
    }//GEN-LAST:event_rbCollectorMouseClicked

    private void bnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnClearActionPerformed
        initialization();
        initializeCollector();
        tfDistributionDate.setText("");
    }//GEN-LAST:event_bnClearActionPerformed

    private void bnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnViewAllActionPerformed
        displayForm(new jplAllRequisitions(this.home,this.gohome));
    }//GEN-LAST:event_bnViewAllActionPerformed

    private void cbCollectorNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCollectorNamePopupMenuWillBecomeInvisible
        retrieveCollectorDetails();
    }//GEN-LAST:event_cbCollectorNamePopupMenuWillBecomeInvisible

    private void cbItemPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbItemPopupMenuWillBecomeInvisible
        retrieveItemDetails();
    }//GEN-LAST:event_cbItemPopupMenuWillBecomeInvisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnClear;
    private javax.swing.JButton bnClose;
    private javax.swing.JButton bnDone;
    private javax.swing.JButton bnNew;
    private javax.swing.JButton bnPrint;
    private javax.swing.JButton bnSave;
    private javax.swing.JButton bnSearch;
    private javax.swing.JButton bnSearch1;
    private javax.swing.JButton bnViewAll;
    private javax.swing.JComboBox<String> cbCollectorName;
    private javax.swing.JComboBox<String> cbItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rbCollector;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCollector;
    private javax.swing.JTextField tfCollectorId;
    private javax.swing.JTextField tfDistributionDate;
    private javax.swing.JTextField tfDistributionId;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfUnitPrice;
    private javax.swing.JTextField tfUserCode1;
    private javax.swing.JTextArea txtReciept;
    // End of variables declaration//GEN-END:variables
}
