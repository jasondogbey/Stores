
package mapp;
import javax.swing.*;
import java.awt.*;

public class JMain extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    public JMain() {
        initComponents();
        this.setTitle("KsTU STORE");
        int x = (d.width-this.getWidth())/2;
        int y = (d.height-this.getHeight())/2;
        this.setLocation(x,y);
        utility.DBconnection.connection();
        displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts)); 
    }

    public void displayForm(JPanel jp){
        jplMain.removeAll();
        jplMain.add(jp);
        jplMain.validate();
        jplMain.repaint();
    }
    private boolean closeOption(){
        if (utility.Utility.universalCode==1){
            int res=JOptionPane.showConfirmDialog(null, "Do you want to save your work?","Warning",JOptionPane.YES_NO_OPTION);
            if (res==JOptionPane.YES_OPTION){
                return false;
            }else{
                utility.Utility.universalCode=0;
                return true;
            }
        }else{
            return true;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jplMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuItems = new javax.swing.JMenuItem();
        mnuTransaction = new javax.swing.JMenuItem();
        mnuSuppliers = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuUsers = new javax.swing.JMenu();
        mnuChangePassword = new javax.swing.JMenuItem();
        mnuSwitchUser = new javax.swing.JMenuItem();
        mnuAccounts = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jplMain.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jplMainLayout = new javax.swing.GroupLayout(jplMain);
        jplMain.setLayout(jplMainLayout);
        jplMainLayout.setHorizontalGroup(
            jplMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );
        jplMainLayout.setVerticalGroup(
            jplMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/ksfl 100px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("KUMASI TECHNICAL UNIVERSITY");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("STORES SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Time:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(32, 32, 32))
        );

        mnuFile.setText("File");

        mnuItems.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        mnuItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-Item-Bag-icon.png"))); // NOI18N
        mnuItems.setText("Items");
        mnuItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemsActionPerformed(evt);
            }
        });
        mnuFile.add(mnuItems);

        mnuTransaction.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        mnuTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-transaction chart-icon.png"))); // NOI18N
        mnuTransaction.setText("Transaction");
        mnuTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTransactionActionPerformed(evt);
            }
        });
        mnuFile.add(mnuTransaction);

        mnuSuppliers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        mnuSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-supplies-icon.png"))); // NOI18N
        mnuSuppliers.setText("Suppliers");
        mnuSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSuppliersActionPerformed(evt);
            }
        });
        mnuFile.add(mnuSuppliers);

        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-exit Windows-Turn-Off-icon.png"))); // NOI18N
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        mnuBar.add(mnuFile);

        mnuUsers.setText("Users");

        mnuChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-change-password-icon.png"))); // NOI18N
        mnuChangePassword.setText("Change Password");
        mnuChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChangePasswordActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuChangePassword);

        mnuSwitchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-User-Group-icon.png"))); // NOI18N
        mnuSwitchUser.setText("Switch User");
        mnuSwitchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSwitchUserActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuSwitchUser);

        mnuAccounts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        mnuAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-User-Executive-Green-icon.png"))); // NOI18N
        mnuAccounts.setText("Register User");
        mnuAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAccountsActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuAccounts);

        mnuBar.add(mnuUsers);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jplMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTransactionActionPerformed
     if (closeOption()){
        displayForm(new jplTransaction(jplMain));
     }
    }//GEN-LAST:event_mnuTransactionActionPerformed

    private void mnuItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemsActionPerformed
        if (closeOption()){
        displayForm(new jplItems(jplMain));
        }
    }//GEN-LAST:event_mnuItemsActionPerformed


    private void mnuChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChangePasswordActionPerformed
        if (closeOption()){
            displayForm(new jplChangePassword(jplMain));
        }
    }//GEN-LAST:event_mnuChangePasswordActionPerformed

    private void mnuSwitchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSwitchUserActionPerformed
        if (closeOption()){
            displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts));      
        }
    }//GEN-LAST:event_mnuSwitchUserActionPerformed


    private void mnuSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSuppliersActionPerformed
        if (closeOption()){
        displayForm(new jplSuppliers(jplMain));
        }
    }//GEN-LAST:event_mnuSuppliersActionPerformed

    private void mnuAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAccountsActionPerformed
        if (closeOption()){
        displayForm(new jplUsers(jplMain));
        }
    }//GEN-LAST:event_mnuAccountsActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        if (closeOption()){
        System.exit(0);
        }
    }//GEN-LAST:event_mnuExitActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jplMain;
    private javax.swing.JMenuItem mnuAccounts;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuChangePassword;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuItems;
    private javax.swing.JMenuItem mnuSuppliers;
    private javax.swing.JMenuItem mnuSwitchUser;
    private javax.swing.JMenuItem mnuTransaction;
    private javax.swing.JMenu mnuUsers;
    // End of variables declaration//GEN-END:variables
}
