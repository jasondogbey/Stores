
package mapp;
import javax.swing.*;


/**
 *
 * @author Winfred Gyan
 */
public class jplChangePassword extends JPanel {
    
    final int pWidth = 450;
    final int pHeight = 250;

    JMenuItem gohome;
    /**
     * Creates new form jplChangePassword
     */
    public jplChangePassword(JPanel jplMain,JMenuItem gohome) {
        initComponents();
        this.setSize(pWidth,pHeight);
        int x = (jplMain.getWidth()-pWidth)/2;
        int y = (jplMain.getHeight()-pHeight)/2;
        this.setLocation(x,y);
        this.setVisible(true);
        this.gohome=gohome;
        initialization();
        
        
    }
    
    private void initialization(){
        pfOldPassword.setText("");
        pfNewPassword.setText("");
        pfConfirmPassword.setText("");
        
        }
    private boolean validation(){
        if(pfOldPassword.getText().isEmpty() || pfNewPassword.getText().isEmpty() || pfConfirmPassword.getText().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bnConfirm = new javax.swing.JButton();
        bnCancel = new javax.swing.JButton();
        pfOldPassword = new javax.swing.JPasswordField();
        pfNewPassword = new javax.swing.JPasswordField();
        pfConfirmPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("BubbleGum", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-change-password-icon.png"))); // NOI18N
        jLabel1.setText("Change User Password");

        jLabel2.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
        jLabel2.setText("Cureent Password:");

        jLabel3.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
        jLabel3.setText("New Password:");

        jLabel4.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
        jLabel4.setText("Confirm Password:");

        bnConfirm.setBackground(new java.awt.Color(255, 255, 255));
        bnConfirm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-confirm-security-icon.png"))); // NOI18N
        bnConfirm.setText("Confirm");
        bnConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnConfirmActionPerformed(evt);
            }
        });

        bnCancel.setBackground(new java.awt.Color(255, 255, 255));
        bnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapp/button-close blue-icon.png"))); // NOI18N
        bnCancel.setText("Cancel");
        bnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnCancelActionPerformed(evt);
            }
        });

        pfNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfNewPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfConfirmPassword)
                            .addComponent(pfNewPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(bnConfirm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(bnCancel)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(pfOldPassword)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnConfirm)
                    .addComponent(bnCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnCancelActionPerformed
        this.gohome.doClick();
    }//GEN-LAST:event_bnCancelActionPerformed

    private void bnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnConfirmActionPerformed
        if (pfOldPassword.getText().isEmpty() || pfNewPassword.getText().isEmpty() || pfConfirmPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Complete all fieds");
            return;
        }
        if(!(pfNewPassword.getText().equals(pfConfirmPassword.getText()))){
           JOptionPane.showMessageDialog(null,"Password should match!"); 
           return;
        }
        
       
         String s = "update account set password='"+pfNewPassword.getText()+"' where password='"+pfOldPassword.getText()+"'";
        if(!validation()){
              JOptionPane.showMessageDialog(null,"Complete all fieds");
              initialization();
              return;
         }
        
        
         try{
               if (utility.DBconnection.getStatement().executeUpdate(s)>0){
             
               JOptionPane.showMessageDialog(null, "Password Change Succesful");
               pfOldPassword.setText("");
               pfNewPassword.setText("");
               pfConfirmPassword.setText("");
              
       }else {
           JOptionPane.showMessageDialog(null, " Password Change Not Successful");
           initialization();
       }
         
         }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
              initialization();
         }
         
    }//GEN-LAST:event_bnConfirmActionPerformed

    private void pfNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfNewPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnCancel;
    private javax.swing.JButton bnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfNewPassword;
    private javax.swing.JPasswordField pfOldPassword;
    // End of variables declaration//GEN-END:variables
}
