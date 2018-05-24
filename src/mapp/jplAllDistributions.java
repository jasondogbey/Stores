/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp;
import java.sql.ResultSet;
import javax.swing.*;
import com.sun.glass.events.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author unknown
 */
public class jplAllDistributions extends JPanel {
    final int pWidth = 830;
    final int pHeight = 430;
    
    JMenuItem gohome;
    int ItemId, CollectorId;
    String Item, Collector;
     
    /**
     * Creates new form jplAllDistributions
     */
    public jplAllDistributions(JPanel jplMain,JMenuItem gohome) {
        initComponents();
        this.setSize(pWidth, pHeight);
        int x = (jplMain.getWidth()-pWidth)/2;
        int y = (jplMain.getHeight()-pHeight)/2;
        this.setLocation(x, y);
        this.setVisible(true);
        this.gohome=gohome;
        //bnSearch.setText("Search");
        initialization();
        filltable();
    }
    public void initialization(){
        tfDistributionId.setText("");
        tfItemId.setText("");
        tfCollectorId.setText("");
        tfQuantity.setText("");
        tfPrice.setText("");
        tfUsername.setText("");
        tfDate.setText("");
        bnDelete.setEnabled(false);
        
    }
    
    private void filltable(){
        String query="select * from distribution";
        try{
            ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
            jtDistribution.setModel(DbUtils.resultSetToTableModel(rs));
            
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
        jLabel4 = new javax.swing.JLabel();
        bnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfItemId = new javax.swing.JTextField();
        bnClose = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDistribution = new javax.swing.JTable();
        tfPrice = new javax.swing.JTextField();
        tfCollectorId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tfDistributionId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        tfSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Item ID:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quantity:");
        jLabel4.setToolTipText("");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-supplies-icon.png"))); // NOI18N
        jLabel1.setText("Distribution");

        tfItemId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfItemIdFocusLost(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Price:");
        jLabel6.setToolTipText("");

        jtDistribution.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtDistribution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDistributionMouseClicked(evt);
            }
        });
        jtDistribution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDistributionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtDistribution);

        tfCollectorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCollectorIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Collector ID:");
        jLabel5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Distribution ID:");

        tfDistributionId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDistributionIdFocusLost(evt);
            }
        });
        tfDistributionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDistributionIdActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Username:");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Date:");
        jLabel9.setToolTipText("");

        tfSearch.setText("Search...");
        tfSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfSearchMouseEntered(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(bnDelete)
                        .addGap(150, 150, 150)
                        .addComponent(bnClose)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfDistributionId, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel4)))
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrice)
                                    .addComponent(tfCollectorId)
                                    .addComponent(tfQuantity)
                                    .addComponent(tfItemId)
                                    .addComponent(tfUsername)
                                    .addComponent(tfDate))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfDistributionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tfCollectorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnDelete)
                            .addComponent(bnClose))
                        .addGap(39, 39, 39))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
        String query= "delete from distribution where Distribution_id='"+tfDistributionId.getText().trim()+"'";
        try{
            if(utility.DBconnection.getStatement().executeUpdate(query)>0){
                JOptionPane.showMessageDialog(null, "Delete is Successful");
                tfDistributionId.setText("");
                tfItemId.setText("");
                tfCollectorId.setText("");
                tfQuantity.setText("");
                tfPrice.setText("");
                tfUsername.setText("");
                tfDate.setText("");
                initialization();
                filltable();

                tfDistributionId.setEditable(true);
                tfItemId.setEditable(true);
                tfCollectorId.setEditable(true);
                tfQuantity.setEditable(true);
                tfPrice.setEditable(true);
                tfUsername.setEditable(true);
                tfDate.setEditable(true);

            }else{
                JOptionPane.showMessageDialog(null, "Delete not Successful");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }//GEN-LAST:event_bnDeleteActionPerformed

    private void tfItemIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfItemIdFocusLost

    }//GEN-LAST:event_tfItemIdFocusLost

    private void bnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnCloseActionPerformed

        this.gohome.doClick();
    }//GEN-LAST:event_bnCloseActionPerformed

    private void jtDistributionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDistributionMouseClicked
        try{
            int row=jtDistribution.getSelectedRow();
            String TableClick=jtDistribution.getModel().getValueAt(row, 0).toString();
            String query="select * from distribution where Distribution_id='"+TableClick+"'";

            ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
            while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
            
                tfDistributionId.setEditable(false);
                tfItemId.setEditable(false);
                tfCollectorId.setEditable(false);
                tfQuantity.setEditable(false);
                tfPrice.setEditable(false);
                tfUsername.setEditable(false);
                tfDate.setEditable(false);
                
                bnDelete.setEnabled(true);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }//GEN-LAST:event_jtDistributionMouseClicked

    private void jtDistributionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDistributionKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN||evt.getKeyCode() == KeyEvent.VK_UP){
            try{
            int row=jtDistribution.getSelectedRow();
            String TableClick=jtDistribution.getModel().getValueAt(row, 0).toString();
            String query="select * from distribution where Distribution_id='"+TableClick+"'";

            ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
            while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
            
                tfDistributionId.setEditable(false);
                tfItemId.setEditable(false);
                tfCollectorId.setEditable(false);
                tfQuantity.setEditable(false);
                tfPrice.setEditable(false);
                tfUsername.setEditable(false);
                tfDate.setEditable(false);
                
                bnDelete.setEnabled(true);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        }
    }//GEN-LAST:event_jtDistributionKeyReleased

    private void tfDistributionIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDistributionIdFocusLost
        tfDistributionId.setText(tfDistributionId.getText().toUpperCase());
    }//GEN-LAST:event_tfDistributionIdFocusLost

    private void tfDistributionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDistributionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDistributionIdActionPerformed

    private void tfCollectorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCollectorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCollectorIdActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        try{
            String query = "select * from distribution where Distribution_id LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Item_id LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Collector_id LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Quantity LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Price LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Username LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        try{
            String query = "select * from distribution where Distribution_date LIKE '%"+tfSearch.getText()+"%'";
             ResultSet rs = utility.DBconnection.getStatement().executeQuery(query);
           
             while(rs.next()){
                tfDistributionId.setText(rs.getString("Distribution_id"));
                //tfItemId.setText(rs.getString("Item_id"));
                ItemId=Integer.parseInt(rs.getString("Item_id"));
                //tfCollectorId.setText(rs.getString("Collector_id"));
                CollectorId=Integer.parseInt(rs.getString("Collector_id"));
                tfQuantity.setText(rs.getString("Quantity"));
                tfPrice.setText(rs.getString("Price"));
                tfUsername.setText(rs.getString("Username"));
                tfDate.setText(rs.getString("Distribution_date"));
            }
            String query1 = "Select Item_name from item where Item_id='"+ItemId+"'";
                ResultSet rs1 = utility.DBconnection.getStatement().executeQuery(query1);
                while(rs1.next()){
                    tfItemId.setText(rs1.getString("Item_name"));
                    Item=tfItemId.getText().toString().trim();
                }
            String query2 = "Select Collector_name from collector where Collector_id='"+CollectorId+"'";
                ResultSet rs2 = utility.DBconnection.getStatement().executeQuery(query2);
                while(rs2.next()){
                    tfCollectorId.setText(rs2.getString("Collector_name"));
                    Collector=tfCollectorId.getText().toString().trim();
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }//GEN-LAST:event_tfSearchKeyReleased

    private void tfSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseEntered
        
    }//GEN-LAST:event_tfSearchMouseEntered

    private void tfSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSearchMouseClicked
        tfSearch.setText("");
    }//GEN-LAST:event_tfSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnClose;
    private javax.swing.JButton bnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtDistribution;
    private javax.swing.JTextField tfCollectorId;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDistributionId;
    private javax.swing.JTextField tfItemId;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
