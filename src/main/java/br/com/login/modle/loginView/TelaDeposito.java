package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.Conexao;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import codigo.Relogio;
import codigo.EnviarSMS;

public class TelaDeposito extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaDeposito.class.getName());
    
    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public TelaDeposito() {
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

        titleDeposito = new javax.swing.JLabel();
        valorDeposito = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buttonDepositar = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        labelRelogio = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3  Bank - Depósito");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleDeposito.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        titleDeposito.setForeground(new java.awt.Color(242, 242, 242));
        titleDeposito.setText("Depósito");
        getContentPane().add(titleDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        valorDeposito.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        valorDeposito.setForeground(new java.awt.Color(242, 242, 242));
        valorDeposito.setText("Valor do depósito:");
        getContentPane().add(valorDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 160, 20));

        buttonDepositar.setBackground(new java.awt.Color(0, 102, 153));
        buttonDepositar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        buttonDepositar.setForeground(new java.awt.Color(242, 242, 242));
        buttonDepositar.setText("Depositar");
        buttonDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDepositarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 120, 30));

        buttonVoltar.setBackground(new java.awt.Color(0, 102, 153));
        buttonVoltar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        buttonVoltar.setForeground(new java.awt.Color(242, 242, 242));
        buttonVoltar.setText("Voltar");
        buttonVoltar.setBorderPainted(false);
        buttonVoltar.setContentAreaFilled(false);
        buttonVoltar.setFocusPainted(false);
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 120, 20));

        labelRelogio.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        labelRelogio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelRelogio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/telaDepositoimg.png"))); // NOI18N
        background.setText("jLabel1");
        background.setMaximumSize(new java.awt.Dimension(630, 331));
        background.setMinimumSize(new java.awt.Dimension(630, 331));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        TelaPrincipal tela = new TelaPrincipal(cliente);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDepositarActionPerformed
        String valorTexto = jTextField1.getText().trim();

        if (valorTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um valor para depósito.");
            return;
        }
        try { 
            NumberFormat formatoBR = NumberFormat.getInstance(new Locale("pt", "BR"));
            Number numero = formatoBR.parse(valorTexto);
            double valorDeposito = numero.doubleValue();

            
            if(valorDeposito <= 0) { 
                JOptionPane.showMessageDialog(this, "Não é possivel depositar valor nulo ou negativo.");
            } else {
                int confirmacao = JOptionPane.showConfirmDialog(this,
                "Deseja realmente depositar R$" + valorTexto + "?",
                "Confirmar Depósito", JOptionPane.YES_NO_OPTION);

                if(confirmacao != JOptionPane.YES_OPTION) {
                    return;
                }

                double saldoAtual = cliente.getSaldo();
                double novoSaldo = saldoAtual + valorDeposito;
                cliente.setSaldo(novoSaldo);

                clienteDAO.atualizarSaldo(cliente.getCpf(), novoSaldo);
                clienteDAO.registrarTransacao(cliente.getCpf(), "Depósito", valorDeposito, null);

                String saldoFormatado = String.format("R$ %.2f", cliente.getSaldo());
                JOptionPane.showMessageDialog(this, "Depósito realizado com sucesso!\nNovo saldo: " + saldoFormatado);
                
                // SMS
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                String valorFormatadoSMS = formatoMoeda.format(valorDeposito);
                EnviarSMS.enviarSMS("+55" + cliente.getTelefone(), "A3Bank \nDepósito de R$ " + valorFormatadoSMS + " realizado com sucesso!");


                TelaPrincipal tela = new TelaPrincipal(cliente);
                tela.setVisible(true);
                this.dispose();
            }
            
        } catch(NumberFormatException | ParseException e){
            JOptionPane.showMessageDialog(this, "Valor inválido, use apenas números.EX:1.000,50");
        }
    }//GEN-LAST:event_buttonDepositarActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new TelaDeposito().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton buttonDepositar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JLabel titleDeposito;
    private javax.swing.JLabel valorDeposito;
    // End of variables declaration//GEN-END:variables
}
