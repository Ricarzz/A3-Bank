package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.Conexao;
import codigo.SegurancaHelper;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import codigo.Relogio;

public class TelaDenuncia extends javax.swing.JFrame {
    private ClienteDAO clienteDAO =  new ClienteDAO();
    private Cliente cliente;

    public TelaDenuncia() {
        initComponents();
        Relogio.getInstancia().adicionarLabel(labelRelogio);
        setLocationRelativeTo(null);
    }
    
    public void setClienteLogado(Cliente cliente) {
    this.cliente = cliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCentralDenuncia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelRelogio = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3 Bank - Denuncias");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCentralDenuncia.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        txtCentralDenuncia.setForeground(new java.awt.Color(242, 242, 242));
        txtCentralDenuncia.setText("Central de Denuncia");
        getContentPane().add(txtCentralDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 350, 20));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Qual seria a chave PIX suspeita?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 180, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Qual o motivo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 180, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Qual o tipo da transação:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 180, -1));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Qual o valor da transação:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 180, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("Denunciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 110, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("Voltar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 130, 20));

        labelRelogio.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        labelRelogio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelRelogio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/telaDenunciaimg.png"))); // NOI18N
        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(630, 331));
        background.setMinimumSize(new java.awt.Dimension(630, 331));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaPrincipal tela = new TelaPrincipal(cliente);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String chaveSuspeita = jTextField1.getText().trim();
        String motivo = jTextField2.getText().trim();
        String tipo = jTextField3.getText().trim();
        String valor = jTextField4.getText().trim();
        
        if(chaveSuspeita.isEmpty() || motivo.isEmpty() || tipo.isEmpty() || valor.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }
        
        double valorSuspeito;
        try {
            valorSuspeito = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido.");
            return;
        }
        
        Cliente destinatario = clienteDAO.buscarChave(chaveSuspeita);
        
        if (destinatario == null) {
            JOptionPane.showMessageDialog(this, "Chave PIX não encontrada.");
            return;
        }

        if (destinatario.getCpf().equals(cliente.getCpf())) {
            JOptionPane.showMessageDialog(this, "Você não pode digitar sua própria chave.");
            return;
            }
        
        clienteDAO.registrarDenuncia(cliente.getCpf(), chaveSuspeita, tipo, valorSuspeito, motivo);
        clienteDAO.addDenuncia(destinatario.getCpf());
        JOptionPane.showMessageDialog(this, "Denúncia registrada com sucesso! Nossa equipe já está analisando.");
        
        TelaPrincipal tela = new TelaPrincipal(cliente);
        tela.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDenuncia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JLabel txtCentralDenuncia;
    // End of variables declaration//GEN-END:variables
}
