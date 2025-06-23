package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.Conexao;
import codigo.SegurancaHelper;
import java.text.NumberFormat;
import java.util.Locale;
import codigo.Relogio;
import java.time.LocalTime;


public class TelaPrincipal extends javax.swing.JFrame {
     private Cliente cliente;
     NumberFormat formatoBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public TelaPrincipal(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
        Relogio.getInstancia().adicionarLabel(labelRelogio);
        //Relogio.getInstancia().setHoraManual(LocalTime.of(0, 30)); // muda o horario para 00:30
        setLocationRelativeTo(null);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        labelRelogio = new javax.swing.JLabel();
        Background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3 Bank - Menu");
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A3_bank_logo2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 180, 70));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Transferir");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Saldo");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 140, 30));

        jButton3.setBackground(new java.awt.Color(0, 102, 153));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Depositar");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 140, 30));

        jButton4.setBackground(new java.awt.Color(0, 102, 153));
        jButton4.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Denunciar PIX");
        jButton4.setActionCommand("Denuncias de Pix");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 140, 30));

        jButton5.setBackground(new java.awt.Color(0, 102, 153));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Histórico de denúncias");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 140, 30));

        jButton6.setBackground(new java.awt.Color(0, 102, 153));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Histórico de  transações");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 30));

        jButton7.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(242, 242, 242));
        jButton7.setText("Sair do App");
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        labelRelogio.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        labelRelogio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelRelogio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 40));

        Background2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        Background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.JPG"))); // NOI18N
        Background2.setText("jLabel1");
        getContentPane().add(Background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 628, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaTransferencia transferencia = new TelaTransferencia();
        transferencia.setClienteLogado(cliente);
        transferencia.setVisible(true);  
        this.dispose();     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TelaDeposito depositar = new TelaDeposito();
        depositar.setClienteLogado(cliente);
        depositar.setVisible(true);  
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TelaDenuncia denunciar = new TelaDenuncia();
        denunciar.setClienteLogado(cliente);
        denunciar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente clienteAtualizado = clienteDAO.buscarPorEmail(cliente.getEmail());
        
        if (clienteAtualizado != null) {
            double saldo = clienteAtualizado.getSaldo();
            String nome = clienteAtualizado.getNome();
            String email = clienteAtualizado.getEmail();
            String cpf = clienteAtualizado.getCpf();
            String telefone = clienteAtualizado.getTelefone();

            String texto = 
                
                "          SALDO ATUAL: " + formatoBR.format(saldo) + "\n" +
                    "\n" +
                " - Nome: " + nome + "\n" +
                " - E-mail: " + email + "\n" +
                " - CPF: " + cpf + "\n" +
                " - Telefone: " + telefone + "\n";
                

            javax.swing.JTextArea areaTexto = new javax.swing.JTextArea(texto);
            areaTexto.setEditable(false);
            areaTexto.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));
        
            javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(areaTexto);
            scroll.setPreferredSize(new java.awt.Dimension(350, 200));
        
            javax.swing.JOptionPane.showMessageDialog(this, scroll, "Resumo da Conta", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar informações da conta.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       ClienteDAO clienteDAO = new ClienteDAO();
       String textoDenuncias = clienteDAO.obterDenunciasComoTexto(cliente.getCpf());

       javax.swing.JOptionPane.showMessageDialog(this, textoDenuncias, "Histórico de Denúncias", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ClienteDAO clienteDAO = new ClienteDAO();
        String historico = clienteDAO.obterHistoricoTransacoesComoTexto(cliente.getCpf());

    javax.swing.JOptionPane.showMessageDialog(this, historico, "Histórico de Transações", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelRelogio;
    // End of variables declaration//GEN-END:variables
}
