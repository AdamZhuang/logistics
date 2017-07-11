/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logisticsui;

/**
 *
 * @author 向光性
 */
public class AdminHomePage extends javax.swing.JFrame {

    /** Creates new form AdminMain */
    public AdminHomePage() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stuffManagement = new javax.swing.JButton();
        commodityManagement = new javax.swing.JButton();
        repositoryManagement = new javax.swing.JButton();
        pickPlan = new javax.swing.JButton();
        purchasePlan = new javax.swing.JButton();
        logQuery = new javax.swing.JButton();
        stuffManagePanel = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        update = new javax.swing.JButton();
        showDataPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        stuffManagement.setText("人员管理");
        stuffManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuffManagementActionPerformed(evt);
            }
        });

        commodityManagement.setText("货物管理");

        repositoryManagement.setText("仓库管理");

        pickPlan.setText("提货计划");

        purchasePlan.setText("采购计划");

        logQuery.setText("日志查询");

        stuffManagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        add.setText("添加");

        remove.setText("删除");

        update.setText("修改");

        showDataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        showDataPanel.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        showDataPanel.setViewportView(jPanel1);

        javax.swing.GroupLayout stuffManagePanelLayout = new javax.swing.GroupLayout(stuffManagePanel);
        stuffManagePanel.setLayout(stuffManagePanelLayout);
        stuffManagePanelLayout.setHorizontalGroup(
            stuffManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stuffManagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update)
                .addContainerGap())
            .addComponent(showDataPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        stuffManagePanelLayout.setVerticalGroup(
            stuffManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stuffManagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stuffManagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(remove)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDataPanel))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repositoryManagement)
                    .addComponent(stuffManagement)
                    .addComponent(commodityManagement)
                    .addComponent(pickPlan)
                    .addComponent(purchasePlan)
                    .addComponent(logQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuffManagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuffManagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stuffManagement)
                        .addGap(18, 18, 18)
                        .addComponent(commodityManagement)
                        .addGap(18, 18, 18)
                        .addComponent(repositoryManagement)
                        .addGap(18, 18, 18)
                        .addComponent(pickPlan)
                        .addGap(18, 18, 18)
                        .addComponent(purchasePlan)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(logQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stuffManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuffManagementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuffManagementActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton commodityManagement;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logQuery;
    private javax.swing.JButton pickPlan;
    private javax.swing.JButton purchasePlan;
    private javax.swing.JButton remove;
    private javax.swing.JButton repositoryManagement;
    private javax.swing.JScrollPane showDataPanel;
    private javax.swing.JPanel stuffManagePanel;
    private javax.swing.JButton stuffManagement;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}