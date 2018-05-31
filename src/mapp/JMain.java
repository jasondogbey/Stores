
package mapp;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapp.jplHome;

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
        currentDate();
        displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts,mnuHome,mnuSearch)); 
        //displayForm(new jplHome(jplMain));
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
    public void currentDate(){
        
        //Dynamic
        Thread clock = new Thread(){
        public void run(){
            while(true){
        Calendar cal= new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        lbDate.setText(Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(year));
        
        //Time
//        int hour = cal.get(Calendar.HOUR);
//        int minute = cal.get(Calendar.MINUTE);
//        int second = cal.get(Calendar.SECOND);
//        lbTime.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second));
   
    Date date = new Date();
    SimpleDateFormat formatTime= new SimpleDateFormat("hh.mm.ss aa");
    String srtTime = formatTime.format(date);
    lbTime.setText(srtTime);
    
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        };
        clock.start();
        
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
        lbDate = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        mnuHome = new javax.swing.JMenuItem();
        mnuItems = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuDistribute = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuSearch = new javax.swing.JMenu();
        mnuDistribution = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnuSuppliers = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        mnuCollectors = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        mnuUsers = new javax.swing.JMenu();
        mnuChangePassword = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuSwitchUser = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnuAccounts = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/ksfl 100px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("KUMASI TECHNICAL UNIVERSITY");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("STORES SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Time:");

        lbDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        lbDate.setText("DD/MM/YYYY");

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("00:00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbTime))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lbDate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDate))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbTime))
                .addGap(32, 32, 32))
        );

        mnuFile.setText("File");
        mnuFile.add(jSeparator10);

        mnuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-home.png"))); // NOI18N
        mnuHome.setText("Home");
        mnuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHomeActionPerformed(evt);
            }
        });
        mnuFile.add(mnuHome);

        mnuItems.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
        mnuItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-Item-Bag-icon.png"))); // NOI18N
        mnuItems.setText("Items");
        mnuItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemsActionPerformed(evt);
            }
        });
        mnuFile.add(mnuItems);
        mnuFile.add(jSeparator1);

        mnuDistribute.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        mnuDistribute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-transaction chart-icon.png"))); // NOI18N
        mnuDistribute.setText("Requisite");
        mnuDistribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDistributeActionPerformed(evt);
            }
        });
        mnuFile.add(mnuDistribute);
        mnuFile.add(jSeparator2);
        mnuFile.add(jSeparator3);

        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-exit Windows-Turn-Off-icon.png"))); // NOI18N
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);
        mnuFile.add(jSeparator4);

        mnuBar.add(mnuFile);

        mnuSearch.setText("Search");

        mnuDistribution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-transaction chart-icon.png"))); // NOI18N
        mnuDistribution.setText("Requisitions");
        mnuDistribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDistributionActionPerformed(evt);
            }
        });
        mnuSearch.add(mnuDistribution);
        mnuSearch.add(jSeparator8);

        mnuSuppliers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        mnuSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-supplies-icon.png"))); // NOI18N
        mnuSuppliers.setText("Suppliers");
        mnuSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSuppliersActionPerformed(evt);
            }
        });
        mnuSearch.add(mnuSuppliers);
        mnuSearch.add(jSeparator9);

        mnuCollectors.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        mnuCollectors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-collector.png"))); // NOI18N
        mnuCollectors.setText("Collectors");
        mnuCollectors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCollectorsActionPerformed(evt);
            }
        });
        mnuSearch.add(mnuCollectors);
        mnuSearch.add(jSeparator11);

        mnuBar.add(mnuSearch);

        mnuUsers.setText("Users");

        mnuChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-change-password-icon.png"))); // NOI18N
        mnuChangePassword.setText("Change Password");
        mnuChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChangePasswordActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuChangePassword);
        mnuUsers.add(jSeparator6);

        mnuSwitchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-User-Group-icon.png"))); // NOI18N
        mnuSwitchUser.setText("Switch User");
        mnuSwitchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSwitchUserActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuSwitchUser);
        mnuUsers.add(jSeparator7);

        mnuAccounts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        mnuAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-User-Executive-Green-icon.png"))); // NOI18N
        mnuAccounts.setText("Register User");
        mnuAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAccountsActionPerformed(evt);
            }
        });
        mnuUsers.add(mnuAccounts);
        mnuUsers.add(jSeparator5);

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

    private void mnuDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDistributeActionPerformed
     if (closeOption()){
        displayForm(new jplRequisition(jplMain,mnuHome));
     }
    }//GEN-LAST:event_mnuDistributeActionPerformed

    private void mnuItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemsActionPerformed
        if (closeOption()){
        displayForm(new jplItems(jplMain,mnuHome));
        }
    }//GEN-LAST:event_mnuItemsActionPerformed


    private void mnuChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChangePasswordActionPerformed
        if (closeOption()){
            displayForm(new jplChangePassword(jplMain, mnuHome));
        }
    }//GEN-LAST:event_mnuChangePasswordActionPerformed

    private void mnuSwitchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSwitchUserActionPerformed
        if (closeOption()){
            displayForm(new jplLogin(jplMain,mnuBar,mnuAccounts,mnuHome,mnuSearch));      
        }
    }//GEN-LAST:event_mnuSwitchUserActionPerformed


    private void mnuSuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSuppliersActionPerformed
        if (closeOption()){
        displayForm(new jplSuppliers(jplMain,mnuHome));
        }
    }//GEN-LAST:event_mnuSuppliersActionPerformed

    private void mnuAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAccountsActionPerformed
        if (closeOption()){
        displayForm(new jplUsers(jplMain, mnuHome));
        }
    }//GEN-LAST:event_mnuAccountsActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        if (closeOption()){
        System.exit(0);
        }
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHomeActionPerformed
        if (closeOption()){

        displayForm(new jplHome(jplMain, mnuBar, mnuAccounts,mnuHome, mnuSearch));
        }
    }//GEN-LAST:event_mnuHomeActionPerformed

    private void mnuCollectorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCollectorsActionPerformed
       if (closeOption()){
        displayForm(new jplCollectors(jplMain,mnuHome));
        }
    }//GEN-LAST:event_mnuCollectorsActionPerformed

    private void mnuDistributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDistributionActionPerformed
        if (closeOption()){
        displayForm(new jplAllRequisitions(jplMain,mnuHome));
        }
    }//GEN-LAST:event_mnuDistributionActionPerformed


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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JPanel jplMain;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbTime;
    private javax.swing.JMenuItem mnuAccounts;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuChangePassword;
    private javax.swing.JMenuItem mnuCollectors;
    private javax.swing.JMenuItem mnuDistribute;
    private javax.swing.JMenuItem mnuDistribution;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuHome;
    private javax.swing.JMenuItem mnuItems;
    private javax.swing.JMenu mnuSearch;
    private javax.swing.JMenuItem mnuSuppliers;
    private javax.swing.JMenuItem mnuSwitchUser;
    private javax.swing.JMenu mnuUsers;
    // End of variables declaration//GEN-END:variables
}
