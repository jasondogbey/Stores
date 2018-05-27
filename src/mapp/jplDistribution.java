/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp;
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
public class jplDistribution extends JPanel {
    final int pWidth = 850;
    final int pHeight = 490;
    JMenuItem gohome;
    JPanel home;
    private static Connection conn;
    /**
     * Creates new form jplTransaction
     */
    public jplDistribution(JPanel jplMain,JMenuItem gohome) {
        initComponents();
        
        this.setSize(pWidth, pHeight);
        int x = (jplMain.getWidth()-pWidth)/2;
        int y = (jplMain.getHeight()-pHeight)/2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.home=jplMain;
        this.gohome=gohome;
        //bnSearch.setText("Search");
        initialization();
        initializeCollector();
        fillcombo();
    }

    public void initialization(){
        tfDistributionId.setText("");
        tfCollector.setText("");
        tfUnitCost.setText("");
        tfQuantity.setText("");
        
        //bnDelete.setEnabled(false);
        tfDistributionId.setEditable(false);
        tfDistributionDate.setEditable(false);
        //tfUnitCost.setEditable(false);
        //tfQuantity.setEditable(false);
        //bnSearch.setText("Search");
        tfUserCode1.setVisible(false);
        //bnSearch.setVisible(false);
        
    }
    public void initializeCollector(){
        tfCollectorId.setText("");
        tfCollector.setText("");
        tfAddress.setText("");
        tfCollectorId.setEditable(false);
        cbCollectorName.setEnabled(false);
        bnRetrieve.setEnabled(false);
        
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
        String query="INSERT INTO `stores_db`.`collector` (`Collector_id`, `Collector_name`, `Address`, `Date`, `Distribution_id`) VALUES (NULL,'"+tfCollector.getText()+"','"+tfAddress.getText()+"','"+tfDistributionDate.getText()+"','"+tfDistributionId.getText()+"')";
        //    INSERT INTO `stores_db`.`collector` (`Collector_id`, `Collector_name`, `Address`, `Date`, `Distribution_id`) VALUES (NULL, 'STEPHEN', 'VOLTA REGION', '02/12/2016', 'T6');
    
        try{
           if(utility.DBconnection.getStatement().executeUpdate(query)>0){
               JOptionPane.showMessageDialog(null, "Successfully saved Item");
                
           }else{
               JOptionPane.showMessageDialog(null, "Could not save data");
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
        tfUnitCost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bnSearch = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
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
        bnViewAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfCollectorId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCollector = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        cbCollectorName = new javax.swing.JComboBox<>();
        rbCollector = new javax.swing.JRadioButton();
        bnRetrieve = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Item:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Unit Cost:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Distribution Date");

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

        bnDelete.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-trash-icon.png"))); // NOI18N
        bnDelete.setText("Delete");
        bnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });

        bnSave.setBackground(new java.awt.Color(255, 255, 255));
        bnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-Save-icon.png"))); // NOI18N
        bnSave.setText("Save");
        bnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSave.setEnabled(false);
        bnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Distribution");

        bnClose.setBackground(new java.awt.Color(255, 255, 255));
        bnClose.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-close blue-icon.png"))); // NOI18N
        bnClose.setText("Close");
        bnClose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnCloseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Distribution ID:");

        cbItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItemActionPerformed(evt);
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
        bnPrint.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnPrintActionPerformed(evt);
            }
        });

        bnNew.setBackground(new java.awt.Color(255, 255, 255));
        bnNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/Button-Add-icon.png"))); // NOI18N
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
        bnDone.setText("Done");
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
        bnSearch1.setText("Distributions");
        bnSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSearch1ActionPerformed(evt);
            }
        });

        bnViewAll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnViewAll.setText("View All");
        bnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnViewAllActionPerformed(evt);
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

        rbCollector.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbCollector.setText("Select Existing");
        rbCollector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCollectorMouseClicked(evt);
            }
        });

        bnRetrieve.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnRetrieve.setText("Retrieve");
        bnRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnRetrieveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(tfAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfCollector))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCollectorName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbCollector)
                        .addGap(18, 18, 18)
                        .addComponent(bnRetrieve))
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
                    .addComponent(rbCollector)
                    .addComponent(bnRetrieve))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bnSearch1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnClose))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(tfUnitCost)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDistributionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(100, 100, 100)
                            .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(40, 40, 40)
                            .addComponent(tfDistributionId))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bnViewAll)
                                .addGap(34, 34, 34)
                                .addComponent(bnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(bnDone)
                                .addGap(55, 55, 55)
                                .addComponent(bnPrint))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207)))
                        .addGap(22, 22, 22))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(tfUnitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDistributionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bnPrint)
                        .addComponent(bnDone)
                        .addComponent(bnViewAll))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bnDelete)
                        .addComponent(bnSave)
                        .addComponent(bnClose)
                        .addComponent(bnSearch1)
                        .addComponent(bnSearch))
                    .addComponent(bnNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSaveActionPerformed
        if (tfQuantity.getText().isEmpty()||tfUnitCost.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Unit Cost and Quantity field cannot be empty");
            return;
        }
        String valu,ds;
                    double intvalue;
            double newval,newval1;
        String s,q,p;
        Double quantity,price,total;
        q=tfQuantity.getText();
        p=tfUnitCost.getText();
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
       
        String query="insert into distribution(Distribution_id,Item_id,Collector_id,Quantity,Price,Username,Distribution_date) values ('"+tfDistributionId.getText()+"','"+cbItem.getSelectedItem().toString()+"','"+tfCollectorId.getText()+"', '"+tfQuantity.getText()+"','"+total+"','"+utility.Utility.username+"', '"+tfDistributionDate.getText()+"')";
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
               if (newval >= 0){
                    String query2 = "update item set Quantity='"+newval+"' where Item_name='"+cbItem.getSelectedItem().toString()+"'";
                   if (utility.DBconnection.getStatement().executeUpdate(query2)>0){
                    JOptionPane.showMessageDialog(null, "Successfully saved Distribution");
               
           }else{
               JOptionPane.showMessageDialog(null, "Could not save data");
           }
               }
                }
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
               
    }//GEN-LAST:event_bnSaveActionPerformed

    private void cbItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbItemActionPerformed

    private void bnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSearchActionPerformed
        tfDistributionId.setEnabled(true);
        tfDistributionId.setEditable(true);
              if (bnSearch.getText().equals("Search")){
            if (tfDistributionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Distribution ID");
                return;  
            }
            
            try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();
           
           String transactionId=tfDistributionId.getText();
           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     distribution.`Distribution_id` AS distribution_Distribution_id,\n" +
"     distribution.`Item_id` AS distribution_Item_id,\n" +
"     distribution.`Collector_id` AS distribution_Collector_id,\n" +
"     distribution.`Quantity` AS distribution_Quantity,\n" +
"     distribution.`Price` AS distribution_Price,\n" +
"     distribution.`Username` AS distribution_Username,\n" +
"     distribution.`Distribution_date` AS distribution_Distribution_date\n" +
"FROM\n" +
"     `distribution` distribution where Distribution_id='"+ transactionId + "'";
           JRDesignQuery newQuery =new JRDesignQuery();
           newQuery.setText(sql);
           jd.setQuery(newQuery);
           JasperReport jr = JasperCompileManager.compileReport(jd);
           JasperPrint jp = JasperFillManager.fillReport(jr,para,conn);
           JasperViewer.viewReport(jp);
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
        
        } //else if (bnSearch.getText().equals("Edit")){
//            tfDistributionId.setEditable(false);
//            cbItem.setEditable(true);
//            tfCollector.setEditable(true);
//            tfAddress.setEditable(true);
//            tfUnitCost.setEditable(true);
//            tfQuantity.setEditable(true);
//            
//            bnSearch.setText("Update");
//        } else if (bnSearch.getText().equals("Update")){
//            String query = "update transaction set item='"+cbItem.getSelectedItem()+"', Collector='"+tfCollector.getText()+"', Unit_price='"+tfUnitCost.getText()+"', Quantity='"+tfQuantity.getText()+"', User_code='"+tfQuantity.getText()+"', Transaction_date='"+tfDistributionDate.getText()+"' where Transaction_id='"+tfDistributionId.getText()+"'";
//            try {
//                if (utility.DBconnection.getStatement().executeUpdate(query)>0){
//                    JOptionPane.showMessageDialog(null, "Update is Successful");
//                    tfDistributionId.setText("");
//                    cbItem.setSelectedItem("");
//                    tfCollector.setText("");
//                    tfUnitCost.setText("");
//                    tfQuantity.setText("");
//                    
//                    tfDistributionDate.setText("");
//                    //bnSearch.setText("Search");
//                    initialization();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Could not update data");
//                    tfDistributionId.setText("");
//                    cbItem.setSelectedItem("");
//                    tfCollector.setText("");
//                    tfUnitCost.setText("");
//                    tfQuantity.setText("");
//                    
//                    tfDistributionDate.setText("");
//                    //bnSearch.setText("Search");
//                    
//                    tfDistributionId.setEditable(true);
//                    cbItem.setEditable(true);
//                    tfCollector.setEditable(true);
//                    tfUnitCost.setEditable(true);
//                    tfQuantity.setEditable(true);
//                   
//                    tfDistributionDate.setEditable(true);
//                }
//            } catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
//            }
//        }
       
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
                //this.setVisible(false);
                this.gohome.doClick();
            }
        }else{
            //this.setVisible(false);
            this.gohome.doClick();
        }
    }//GEN-LAST:event_bnCloseActionPerformed

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
        if (tfDistributionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Distribution ID");
                return;  
            }        
        String query= "delete from distribution where Distribution_id='"+tfDistributionId.getText().trim()+"'";
            try{
                if(utility.DBconnection.getStatement().executeUpdate(query)>0){
                    JOptionPane.showMessageDialog(null, "Delete is Successful");
                    tfDistributionId.setText("");
                    cbItem.setSelectedItem("");
                    tfCollectorId.setText("");
                    tfCollector.setText("");
                    tfUnitCost.setText("");
                    tfQuantity.setText("");
                    tfAddress.setText("");
                    tfDistributionDate.setText("");
                    initialization();
                    
                    tfDistributionId.setEditable(false);
 
                }else{
                    JOptionPane.showMessageDialog(null, "Delete not Successful");
                }
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
             }
    }//GEN-LAST:event_bnDeleteActionPerformed

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
           Logger.getLogger(jplDistribution.class.getName()).log(Level.SEVERE, null ,ex);
       }
        
    }//GEN-LAST:event_bnPrintActionPerformed

    private void bnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnNewActionPerformed
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
        tfUnitCost.setEditable(true);
        tfQuantity.setEditable(true);
        txtReciept.setText(null);
        txtReciept.append("\n");
        txtReciept.append("\t     Store Management System\n\n" +
                
                "Receipt No:" + tfDistributionId.getText() +"\t\tDate:" + tfDistributionDate.getText()+"\n" +
                "Collector:"+tfCollector.getText() + "\n" +
                "+==================================================+\n" +
                "\t          RECEIPT VOUCHER\n" +
                "+==================================================+\n" +
                
                "Item Name\tItem Description\tSub Total" );
       
      bnSave.setEnabled(true);
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
                "\n\n\tThanks for shopping with us..." 
        );
        bnSave.setEnabled(false);
    }//GEN-LAST:event_bnDoneActionPerformed

    private void bnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSearch1ActionPerformed
        tfDistributionId.setEnabled(true);
        tfDistributionId.setEditable(true);
        if (tfDistributionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Distribution ID");
                return;  
            }
        try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();
          
           String distributionId=tfDistributionId.getText();
           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     distribution.`Distribution_id` AS distribution_Distribution_id,\n" +
"     distribution.`Item_id` AS distribution_Item_id,\n" +
"     distribution.`Collector_id` AS distribution_Collector_id,\n" +
"     distribution.`Quantity` AS distribution_Quantity,\n" +
"     distribution.`Price` AS distribution_Price,\n" +
"     distribution.`Username` AS distribution_Username,\n" +
"     distribution.`Distribution_date` AS distribution_Distribution_date\n" +
"FROM\n" +
"     `distribution` distribution";
           JRDesignQuery newQuery =new JRDesignQuery();
           newQuery.setText(sql);
           jd.setQuery(newQuery);
           JasperReport jr = JasperCompileManager.compileReport(jd);
           JasperPrint jp = JasperFillManager.fillReport(jr,para,conn);
           JasperViewer.viewReport(jp);
       
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
        
    }//GEN-LAST:event_bnSearch1ActionPerformed

    private void bnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnViewAllActionPerformed
        displayForm(new jplAllDistributions(this.home,this.gohome));
    }//GEN-LAST:event_bnViewAllActionPerformed

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
            bnRetrieve.setEnabled(true);
           
            
        } else{
            initializeCollector();
            tfCollector.setEditable(true);
            tfAddress.setEditable(true);
            
        }
    }//GEN-LAST:event_rbCollectorMouseClicked

    private void bnRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnRetrieveActionPerformed
        retrieveCollectorDetails();
    }//GEN-LAST:event_bnRetrieveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnClose;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnDone;
    private javax.swing.JButton bnNew;
    private javax.swing.JButton bnPrint;
    private javax.swing.JButton bnRetrieve;
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
    private javax.swing.JTextField tfUnitCost;
    private javax.swing.JTextField tfUserCode1;
    private javax.swing.JTextArea txtReciept;
    // End of variables declaration//GEN-END:variables
}
