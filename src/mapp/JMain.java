
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
        displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts,mnuPrint)); 
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
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuItems = new javax.swing.JMenuItem();
        mnuTransaction = new javax.swing.JMenuItem();
        mnuSuppliers = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuPrint = new javax.swing.JMenu();
        mnuPrintTransaction = new javax.swing.JMenuItem();
        mnuPrintUsers = new javax.swing.JMenuItem();
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
            .addGap(0, 636, Short.MAX_VALUE)
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

        mnuPrint.setText("Print");

        mnuPrintTransaction.setText("Transaction");
        mnuPrint.add(mnuPrintTransaction);

        mnuPrintUsers.setText("Users");
        mnuPrint.add(mnuPrintUsers);

        mnuBar.add(mnuPrint);

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts,mnuPrint));      
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jplMain;
    private javax.swing.JMenuItem mnuAccounts;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuChangePassword;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuItems;
    private javax.swing.JMenu mnuPrint;
    private javax.swing.JMenuItem mnuPrintTransaction;
    private javax.swing.JMenuItem mnuPrintUsers;
    private javax.swing.JMenuItem mnuSuppliers;
    private javax.swing.JMenuItem mnuSwitchUser;
    private javax.swing.JMenuItem mnuTransaction;
    private javax.swing.JMenu mnuUsers;
    // End of variables declaration//GEN-END:variables
}
