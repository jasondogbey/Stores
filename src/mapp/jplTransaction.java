/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.print.PrinterException;
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

/**
 *
 * @author Unknown
 */
public class jplTransaction extends JPanel {
    final int pWidth = 850;
    final int pHeight = 450;
    private static Connection conn;
    /**
     * Creates new form jplTransaction
     */
    public jplTransaction(JPanel jplMain) {
        initComponents();
        
        this.setSize(pWidth, pHeight);
        int x = (jplMain.getWidth()-pWidth)/2;
        int y = (jplMain.getHeight()-pHeight)/2;
        this.setLocation(x, y);
        this.setVisible(true);
        //bnSearch.setText("Search");
        initialization();
        fillcombo();
    }
    public void initialization(){
        tfTransactionId.setText("");
        tfCollector.setText("");
        tfUnitCost.setText("");
        tfQuantity.setText("");
        tfUserCode.setText("");
        //bnDelete.setEnabled(false);
        bnSearch.setText("Search");
        tfUserCode1.setVisible(false);
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tfTransactionId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfUnitCost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfUserCode = new javax.swing.JTextField();
        bnSearch = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        bnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        tfTransactionDate = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        cbItem = new javax.swing.JComboBox<>();
        tfCollector = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReciept = new javax.swing.JTextArea();
        bnDelete1 = new javax.swing.JButton();
        bnDelete2 = new javax.swing.JButton();
        bnDelete3 = new javax.swing.JButton();
        tfUserCode1 = new javax.swing.JTextField();
        bnSearch1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Collector");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Item");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Unit Cost");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity");

        tfUnitCost.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Transaction Date");

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
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("Transaction");

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
        jLabel2.setText("Transaction ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("User Code");

        tfQuantity.setEditable(false);

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

        bnDelete1.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-print-icon.png"))); // NOI18N
        bnDelete1.setText("Print");
        bnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDelete1ActionPerformed(evt);
            }
        });

        bnDelete2.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/Button-Add-icon.png"))); // NOI18N
        bnDelete2.setText("New");
        bnDelete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDelete2ActionPerformed(evt);
            }
        });

        bnDelete3.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnDelete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-confirm-security-icon.png"))); // NOI18N
        bnDelete3.setText("Done");
        bnDelete3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDelete3ActionPerformed(evt);
            }
        });

        tfUserCode1.setText("0");

        bnSearch1.setBackground(new java.awt.Color(255, 255, 255));
        bnSearch1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-transaction chart-icon.png"))); // NOI18N
        bnSearch1.setText("Transactions");
        bnSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25)
                                .addComponent(tfTransactionDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfTransactionId)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(bnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(bnSearch)
                                        .addGap(18, 18, 18)
                                        .addComponent(bnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bnDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(bnClose)
                                        .addGap(97, 97, 97))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(tfCollector))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(tfUserCode))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfQuantity)
                                            .addComponent(tfUnitCost))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(bnDelete3)
                        .addGap(55, 55, 55)
                        .addComponent(bnDelete1)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(581, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnDelete1)
                            .addComponent(bnDelete2)
                            .addComponent(bnDelete3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(tfUserCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfTransactionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTransactionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfCollector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfUserCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfUnitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnDelete)
                            .addComponent(bnSave)
                            .addComponent(bnClose)
                            .addComponent(bnSearch)
                            .addComponent(bnSearch1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSaveActionPerformed
        if (tfQuantity.getText().isEmpty()||tfUnitCost.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Unit Cost fiels or Price field cannot be empty");
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
       
        String query="insert into transaction(Transaction_id,item,Collector,Unit_price,Quantity,User_code,Transaction_date) values ('"+tfTransactionId.getText()+"','"+cbItem.getSelectedItem().toString()+"','"+tfCollector.getText()+"', '"+tfUnitCost.getText()+"', '"+tfQuantity.getText()+"','"+tfUserCode.getText()+"','"+tfTransactionDate.getText()+"')";
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
                    JOptionPane.showMessageDialog(null, "Successfully saved Transaction");
               
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
 
        
              if (bnSearch.getText().equals("Search")){
            if (tfTransactionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Item ID");
                return;  
            }
            
            try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();
           
           String transactionId=tfTransactionId.getText();
           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     transaction.`Transaction_Id` AS transaction_Transaction_Id,\n" +
"     transaction.`item` AS transaction_item,\n" +
"     transaction.`Collector` AS transaction_Collector,\n" +
"     transaction.`Unit_price` AS transaction_Unit_price,\n" +
"     transaction.`Quantity` AS transaction_Quantity,\n" +
"     transaction.`User_code` AS transaction_User_code,\n" +
"     transaction.`Transaction_date` AS transaction_Transaction_date\n" +
"FROM\n" +
"     `transaction` transaction where Transaction_Id='"+ transactionId + "'";
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
        
        } else if (bnSearch.getText().equals("Edit")){
            tfTransactionId.setEditable(false);
            cbItem.setEditable(true);
            tfCollector.setEditable(true);
            tfUnitCost.setEditable(true);
            tfQuantity.setEditable(true);
            tfUserCode.setEditable(true);
            tfTransactionDate.setEditable(true);
            bnSearch.setText("Update");
        } else if (bnSearch.getText().equals("Update")){
            String query = "update transaction set item='"+cbItem.getSelectedItem()+"', Collector='"+tfCollector.getText()+"', Unit_price='"+tfUnitCost.getText()+"', Quantity='"+tfQuantity.getText()+"', User_code='"+tfUserCode.getText()+"', Transaction_date='"+tfTransactionDate.getText()+"' where Transaction_id='"+tfTransactionId.getText()+"'";
            try {
                if (utility.DBconnection.getStatement().executeUpdate(query)>0){
                    JOptionPane.showMessageDialog(null, "Update is Successful");
                    tfTransactionId.setText("");
                    cbItem.setSelectedItem("");
                    tfCollector.setText("");
                    tfUnitCost.setText("");
                    tfQuantity.setText("");
                    tfUserCode.setText("");
                    tfTransactionDate.setText("");
                    //bnSearch.setText("Search");
                    initialization();
                } else {
                    JOptionPane.showMessageDialog(null, "Could not update data");
                    tfTransactionId.setText("");
                    cbItem.setSelectedItem("");
                    tfCollector.setText("");
                    tfUnitCost.setText("");
                    tfQuantity.setText("");
                    tfUserCode.setText("");
                    tfTransactionDate.setText("");
                    //bnSearch.setText("Search");
                    
                    tfTransactionId.setEditable(true);
                    cbItem.setEditable(true);
                    tfCollector.setEditable(true);
                    tfUnitCost.setEditable(true);
                    tfQuantity.setEditable(true);
                    tfUserCode.setEditable(true);
                    tfTransactionDate.setEditable(true);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
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
                this.setVisible(false);
            }
        }else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_bnCloseActionPerformed

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
 if (tfTransactionId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Item ID");
                return;  
            }        
        String query= "delete from transaction where Transaction_id='"+tfTransactionId.getText().trim()+"'";
            try{
                if(utility.DBconnection.getStatement().executeUpdate(query)>0){
                    JOptionPane.showMessageDialog(null, "Delete is Successful");
                    tfTransactionId.setText("");
                    cbItem.setSelectedItem("");
                    tfCollector.setText("");
                    tfUnitCost.setText("");
                    tfQuantity.setText("");
                    tfUserCode.setText("");
                    tfTransactionDate.setText("");
                    initialization();
                    
                    tfTransactionId.setEditable(true);
                    cbItem.setEditable(true);
                    tfCollector.setEditable(true);
                    tfUnitCost.setEditable(true);
                    tfQuantity.setEditable(true);
                    tfUserCode.setEditable(true);
                    tfTransactionDate.setEditable(true);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Delete not Successful");
                }
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
             }
    }//GEN-LAST:event_bnDeleteActionPerformed

    private void bnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDelete1ActionPerformed
if (txtReciept.getText().isEmpty())
{
    return;
}       
            try{
                 txtReciept.print();
            }
       catch(PrinterException ex)
       {
           Logger.getLogger(jplTransaction.class.getName()).log(Level.SEVERE, null ,ex);
       }
        
    }//GEN-LAST:event_bnDelete1ActionPerformed

    private void bnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDelete2ActionPerformed
        if (tfUserCode.getText().isEmpty() || tfTransactionId.getText().isEmpty() || tfTransactionDate.getText().isEmpty()|| tfCollector.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Complete all fieds");
            return;
        }
        tfUnitCost.setEditable(true);
        tfQuantity.setEditable(true);
        txtReciept.setText(null);
        txtReciept.append("\n");
        txtReciept.append("\t     Store Management System\n\n" +
                
                "Receipt No:" + tfTransactionId.getText() +"\t\tDate:" + tfTransactionDate.getText()+"\n" +
                "Collector:"+tfCollector.getText() + "\n" +
                "+==================================================+\n" +
                "\t          RECEIPT VOUCHER\n" +
                "+==================================================+\n" +
                
                "Item Name\tItem Description\tSub Total" );
       
      bnSave.setEnabled(true);
    }//GEN-LAST:event_bnDelete2ActionPerformed

    private void bnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDelete3ActionPerformed
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
    }//GEN-LAST:event_bnDelete3ActionPerformed

    private void bnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnSearch1ActionPerformed
       try
       {
           HashMap para = new HashMap();
           conn=DBconnection.getConnection();
          
           String transactionId=tfTransactionId.getText();
           JasperDesign jd = JRXmlLoader.load("C:\\Users\\unknown\\Documents\\NetBeansProjects\\Stores5\\src\\mapp\\report1.jrxml");
           String sql ="SELECT\n" +
"     transaction.`Transaction_Id` AS transaction_Transaction_Id,\n" +
"     transaction.`item` AS transaction_item,\n" +
"     transaction.`Collector` AS transaction_Collector,\n" +
"     transaction.`Unit_price` AS transaction_Unit_price,\n" +
"     transaction.`Quantity` AS transaction_Quantity,\n" +
"     transaction.`User_code` AS transaction_User_code,\n" +
"     transaction.`Transaction_date` AS transaction_Transaction_date\n" +
"FROM\n" +
"     `transaction` transaction";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnClose;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnDelete1;
    private javax.swing.JButton bnDelete2;
    private javax.swing.JButton bnDelete3;
    private javax.swing.JButton bnSave;
    private javax.swing.JButton bnSearch;
    private javax.swing.JButton bnSearch1;
    private javax.swing.JComboBox<String> cbItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tfCollector;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfTransactionDate;
    private javax.swing.JTextField tfTransactionId;
    private javax.swing.JTextField tfUnitCost;
    private javax.swing.JTextField tfUserCode;
    private javax.swing.JTextField tfUserCode1;
    private javax.swing.JTextArea txtReciept;
    // End of variables declaration//GEN-END:variables
}
