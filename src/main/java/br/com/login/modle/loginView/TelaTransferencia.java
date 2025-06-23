package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.Conexao;
import codigo.SegurancaHelper;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalTime;
import codigo.Relogio;
import codigo.EnviarSMS;


public class TelaTransferencia extends javax.swing.JFrame {
    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private double converterValorBR(String valorStr) throws Exception {
    NumberFormat formatoBR = NumberFormat.getInstance(new Locale("pt", "BR"));
    Number numero = formatoBR.parse(valorStr);
    return numero.doubleValue();
    }

    
    public TelaTransferencia() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        labelRelogio = new javax.swing.JLabel();
        background4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3 Bank - Transferência");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Transferência");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Valor da transferência:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 190, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Chave do destinatário:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 190, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 130, 40));

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Voltar");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 70, 20));

        labelRelogio.setFont(new java.awt.Font("Microsoft Himalaya", 0, 24)); // NOI18N
        labelRelogio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelRelogio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 50, 40));

        background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background1.png"))); // NOI18N
        background4.setText("jLabel1");
        getContentPane().add(background4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    try {
        String valorStr = jTextField1.getText().trim();
        
        if (valorStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o valor da transferência.");
            return;
        }
        
        double valor = converterValorBR(valorStr);
        String chave = jTextField2.getText().trim();
        
        if (!cliente.verificarTransferencia(valor)) {
            if(valor <= 0)JOptionPane.showMessageDialog(this, "Impossivel com valor nulo ou negativo.");
            else {
             JOptionPane.showMessageDialog(this, "Saldo insuficiente, transferência cancelada.");   
            }
            jTextField1.setText("");
            jTextField2.setText("");
            return;
        }
        
        // Evitar múltiplas transferencias em pouco tempo 
        double totalRecentes = clienteDAO.buscarTotalTransferenciasRecentes(cliente.getCpf(), 10);
        
        if ((totalRecentes + valor) > 2000) {
        JOptionPane.showMessageDialog(this, "Transferências recentes somam mais de R$2.000 em 10 minutos. Transferência bloqueada por segurança.");
        return;
        }

        
        LocalTime agora = Relogio.getInstancia().getHoraAtual();  

        if (agora.isAfter(LocalTime.MIDNIGHT) && agora.isBefore(LocalTime.of(6, 0)) && valor > 1000.0) {
        JOptionPane.showMessageDialog(null, 
            "Transferências acima de R$1.000,00 não são permitidas entre 00h e 06h por motivos de segurança.");
        jTextField1.setText("");
        jTextField2.setText("");
        return;
        }


        Cliente destinatario = clienteDAO.buscarChave(chave);
        
        if (chave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a chave do destinatário.");
            return;
        }
        
        if (destinatario == null) {
            JOptionPane.showMessageDialog(this, "Chave PIX não encontrada.");
            return;
        }
        
        if (destinatario.getCpf().equals(cliente.getCpf())) {
            JOptionPane.showMessageDialog(this, "Não é possível transferir para si mesmo.");
            return;
        }
        
        if (valor > 1000) {
            JOptionPane.showMessageDialog(this,
                "Transferências acima de R$1.000,00 serão rastreadas e analisadas por motivos de segurança.",
                "Aviso de Segurança", JOptionPane.WARNING_MESSAGE);
        }
        
        String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
        int confirmacao = JOptionPane.showConfirmDialog(this,
        "Transferir " + valorFormatado + " para " + destinatario.getNome() +
        "\nChave: " + chave + "\nDeseja continuar?",
        "Confirmar Transferência", JOptionPane.YES_NO_OPTION);

        if (confirmacao != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Transferência cancelada.");
            return;
        }
        
        int denuncias = clienteDAO.buscarQuantidadeDenuncia(destinatario.getCpf());

        if (denuncias >= 5) {
            JOptionPane.showMessageDialog(this, "Esta conta está bloqueada por excesso de denúncias. Transferência cancelada.");
            return;
        } else if (denuncias >= 3) {
            int opcao = JOptionPane.showConfirmDialog(this, 
            "A conta de destino possui muitas denúncias registradas. Deseja continuar?", 
            "Atenção", JOptionPane.YES_NO_OPTION);

            if (opcao != JOptionPane.YES_OPTION) {
            return;
            }
        }


        JPasswordField campoSenha = new JPasswordField();
        int senhaOk = JOptionPane.showConfirmDialog(this, campoSenha,
            "Digite sua senha", JOptionPane.OK_CANCEL_OPTION);

        if (senhaOk != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "Transferência cancelada.");
            return;
        }

        String senhaDigitada = new String(campoSenha.getPassword());

        if (!cliente.verificarSenha(senhaDigitada)) {
            JOptionPane.showMessageDialog(this, "Senha incorreta.");
            return;
        }

        cliente.transferir(valor, clienteDAO);
        clienteDAO.registrarTransacao(cliente.getCpf(), "Transferência enviada", valor, chave);

        destinatario.depositar(valor, clienteDAO, false);
        clienteDAO.registrarTransacao(destinatario.getCpf(), "Transferência recebida", valor, cliente.getCpf());

        JOptionPane.showMessageDialog(this, "Transferência concluída com sucesso!");
        
        // SMS
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatadoSMS = formatoMoeda.format(valor);
        EnviarSMS.enviarSMS("+55" + cliente.getTelefone(), "A3 Bank \nTransferência de R$ " + valorFormatadoSMS + " realizada com sucesso!");
        EnviarSMS.enviarSMS("+55" + destinatario.getTelefone(), "A3 Bank \nVocê recebeu uma transferência de R$ " + valorFormatadoSMS + " de " + cliente.getNome() + ".");

        
        TelaPrincipal tela = new TelaPrincipal(cliente);
        tela.setVisible(true);
        this.dispose();

    } catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Valor inválido. Use o formato: 1.000,00");
    e.printStackTrace();
    }         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaPrincipal tela = new TelaPrincipal(cliente);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTransferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelRelogio;
    // End of variables declaration//GEN-END:variables
    }