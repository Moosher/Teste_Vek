package testevek;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

/**
 *
 * @author fernando
 */
public class MainJFrame extends JFrame {    
    
    private String pagamento;
    Object[] tipoPagamento = {"Cr�dito","Parcelado","Cr�dito Parcelado","D�bito"};
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        init();
    }
    
    private void init(){
        setTitle("Vek");
        setVisible(true);        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonProdutoA = new javax.swing.JButton();
        jButtonProdutoB = new javax.swing.JButton();
        jButtonProdutoC = new javax.swing.JButton();
        Tittle = new javax.swing.JLabel();
        jButtonProdutoDesabilitado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonProdutoA.setText("4409");
        jButtonProdutoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoAActionPerformed(evt);
            }
        });

        jButtonProdutoB.setText("4628");
        jButtonProdutoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoBActionPerformed(evt);
            }
        });

        jButtonProdutoC.setText("4430");
        jButtonProdutoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoCActionPerformed(evt);
            }
        });

        Tittle.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Tittle.setText("Selecione um produto da lista abaixo, basta clicar!");

        jButtonProdutoDesabilitado.setText("1318");
        jButtonProdutoDesabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutoDesabilitadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(Tittle)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonProdutoA, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jButtonProdutoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonProdutoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonProdutoDesabilitado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProdutoA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProdutoB, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProdutoC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProdutoDesabilitado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProdutoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoAActionPerformed
        pagamento = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de pagamento", "Pagamento", JOptionPane.PLAIN_MESSAGE, null, tipoPagamento, null);                
        JOptionPane.showMessageDialog(null, "Opera��o conclu�da", pagamento, JOptionPane.PLAIN_MESSAGE);     
    }//GEN-LAST:event_jButtonProdutoAActionPerformed

    private void jButtonProdutoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoBActionPerformed
        pagamento = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de pagamento", "Pagamento", JOptionPane.PLAIN_MESSAGE, null, tipoPagamento, null);
        Processador.CheckPagamento(pagamento);
    }//GEN-LAST:event_jButtonProdutoBActionPerformed

    private void jButtonProdutoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoCActionPerformed
        JFormattedTextField taxaAmex = new JFormattedTextField();
        Processador.maskOnlyInt(taxaAmex); 
        
        Object[] campos = { 
            "Taxa Amex Cr�dito em % (Obrigat�rio)", taxaAmex
        };        
        
        JOptionPane.showMessageDialog(null, campos, "Pagamento", JOptionPane.PLAIN_MESSAGE);
        
        String amex = taxaAmex.getText(); 
        amex = amex.replace(" ", ""); 
        Processador.id = "C"; // define o id para o produto C (4430)
        Processador.verificaVazio(amex, pagamento);        
    }//GEN-LAST:event_jButtonProdutoCActionPerformed

    private void jButtonProdutoDesabilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutoDesabilitadoActionPerformed
        JOptionPane.showMessageDialog(null, "Este produto encontra-se desabilitado no sistema.", "Produto Desabilitado", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButtonProdutoDesabilitadoActionPerformed
    
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tittle;
    private javax.swing.JButton jButtonProdutoA;
    private javax.swing.JButton jButtonProdutoB;
    private javax.swing.JButton jButtonProdutoC;
    private javax.swing.JButton jButtonProdutoDesabilitado;
    // End of variables declaration//GEN-END:variables
}