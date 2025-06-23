package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.Conexao;
import codigo.SegurancaHelper;
import javax.swing.JOptionPane;
import codigo.EnviarEmail;

public class TelaLogin extends javax.swing.JFrame {
    
    private Cliente clienteAtual = null; // pra nao zerar as tentativas 
   
    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        emailField.requestFocusInWindow();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonEnter = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        senhaText = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        cpfText = new javax.swing.JLabel();
        buttonCadastro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        background3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3 Bank - Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEnter.setBackground(new java.awt.Color(0, 102, 153));
        buttonEnter.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        buttonEnter.setForeground(new java.awt.Color(255, 255, 255));
        buttonEnter.setText("Entrar");
        buttonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnterActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 130, 30));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, 30));

        senhaText.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        senhaText.setForeground(new java.awt.Color(242, 242, 242));
        senhaText.setText("Senha:");
        getContentPane().add(senhaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 260, 20));

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 260, 30));

        cpfText.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        cpfText.setForeground(new java.awt.Color(242, 242, 242));
        cpfText.setText("E-mail:");
        getContentPane().add(cpfText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 260, 20));

        buttonCadastro.setForeground(new java.awt.Color(255, 255, 255));
        buttonCadastro.setText("Realizar cadastro");
        buttonCadastro.setBorderPainted(false);
        buttonCadastro.setContentAreaFilled(false);
        buttonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A3_bank_logo2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 180, 70));

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Esqueci minha senha");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 170, 20));

        background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/IMG_4546.JPG"))); // NOI18N
        background3.setText("jLabel1");
        background3.setMaximumSize(new java.awt.Dimension(630, 331));
        background3.setMinimumSize(new java.awt.Dimension(630, 331));
        background3.setPreferredSize(new java.awt.Dimension(630, 331));
        getContentPane().add(background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void buttonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnterActionPerformed
        String email = emailField.getText();
        String senhaDigitada = new String(passwordField.getPassword());
        
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite seu e-mail.", "Aviso", JOptionPane.WARNING_MESSAGE);
            emailField.requestFocus();
            return;
        }
        if (senhaDigitada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite sua senha.", "Aviso", JOptionPane.WARNING_MESSAGE);
            passwordField.requestFocus();
            return;
        }

        ClienteDAO clienteDAO = new ClienteDAO();
        
        if (clienteAtual == null || !clienteAtual.getEmail().equals(email)) {
            clienteAtual = clienteDAO.buscarPorEmail(email);
        }

        if (clienteAtual != null) {
            
            if (clienteDAO.buscarQuantidadeDenuncia(clienteAtual.getCpf()) >= 5) {
                JOptionPane.showMessageDialog(null, "Sua conta está bloqueada por excesso de denúncias.\nVerifique seu e-mail para um código de desbloqueio.");

                 // Gera e envia código
                String codigoGerado = clienteDAO.gerarCodigoVerificacao();
                clienteDAO.salvarCodigoRecuperacao(clienteAtual.getCpf(), codigoGerado);
                EnviarEmail.enviarCodigoVerificacao(clienteAtual.getEmail(), codigoGerado);

                String codigoDigitado = JOptionPane.showInputDialog(null, "Digite o código de desbloqueio enviado ao seu e-mail:");

                if (codigoDigitado != null && clienteDAO.verificarCodigoRecuperacao(clienteAtual.getCpf(), codigoDigitado)) {
                    clienteDAO.atualizarDenunciasParaTres(clienteAtual.getCpf());
                    clienteDAO.apagarCodigoRecuperacao(clienteAtual.getCpf()); // limpa o código do banco
                    JOptionPane.showMessageDialog(null, "Desbloqueio realizado com sucesso. Tente o login novamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Código inválido ou incorreto. A conta permanece bloqueada.");
                }

             return;
            }
            
            if ("SIM".equalsIgnoreCase(clienteAtual.getContaBloqueada())) {
                JOptionPane.showMessageDialog(null, "Sua conta está bloqueada por suspeita de entrada forçada. Verifique o email para desbloquear.");
                String codigoGerado = clienteDAO.gerarCodigoVerificacao();
                clienteDAO.salvarCodigoRecuperacao(clienteAtual.getCpf(), codigoGerado);
                EnviarEmail.enviarCodigoVerificacao(clienteAtual.getEmail(), codigoGerado);

                String codigoDigitado = JOptionPane.showInputDialog(null, "Digite o código de desbloqueio enviado ao seu e-mail:");

                if (codigoDigitado != null && clienteDAO.verificarCodigoRecuperacao(clienteAtual.getCpf(), codigoDigitado)) {
                    clienteDAO.desbloquearConta(clienteAtual.getCpf());
                    clienteDAO.apagarCodigoRecuperacao(clienteAtual.getCpf());
                    clienteAtual = clienteDAO.buscarPorEmail(clienteAtual.getEmail());
                    JOptionPane.showMessageDialog(null, "Desbloqueio realizado com sucesso. Tente o login novamente.");
                    passwordField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Código inválido ou incorreto. A conta permanece bloqueada.");
                }
                return;
            }

            
            boolean senhaCorreta = clienteAtual.verificarSenhaLogin(senhaDigitada);
            if (senhaCorreta) {
                new TelaPrincipal(clienteAtual).setVisible(true); // passa para a próxima tela
                clienteAtual = null;
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
                
                if (clienteAtual.contaBloqueada()) {
                    JOptionPane.showMessageDialog(this, "Por segurança para evitar entrada forçada, bloqueamos a conta.");
                    clienteDAO.bloquearConta(clienteAtual.getCpf());
                    clienteAtual = clienteDAO.buscarPorEmail(clienteAtual.getEmail());// pra atualizar 
                    return;
                }

                if (clienteAtual.precisaBloquearTemporariamente()) {
                    int tempo = clienteAtual.getTempoDeBloqueio();
                    JOptionPane.showMessageDialog(this, "Número de tentativas suspeito. Aguarde " + (tempo / 1000) + " segundos.");

                    try {
                        Thread.sleep(tempo);
                        clienteAtual.aumentarBloqueio();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                passwordField.setText(""); //pra limpar imput
                passwordField.requestFocus();                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado com o E-mail informado.");
            emailField.requestFocus();
        }
        //emailField.setText("");
        passwordField.setText("");
    }//GEN-LAST:event_buttonEnterActionPerformed

    private void buttonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastroActionPerformed
        TelaCadastro teladeCadastro = new TelaCadastro(this); //passa a tela
        teladeCadastro.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_buttonCadastroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = JOptionPane.showInputDialog(null, "Digite o e-mail cadastrado:");
        
        if (email == null || email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você deve digitar um e-mail válido.");
            return;
        }
        
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Formato de e-mail inválido.");
            return;
        }

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.buscarPorEmail(email);

        if (cliente != null) {
            int confirmacao = JOptionPane.showConfirmDialog(null, 
            email + " receberá um e-mail com um código de verificação.\nDeseja continuar?", 
            "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                
                String codigoGerado = clienteDAO.gerarCodigoVerificacao(); 
                clienteDAO.salvarCodigoRecuperacao(email, codigoGerado);

                try {
                    EnviarEmail.enviarCodigoVerificacao(email, codigoGerado);
                    JOptionPane.showMessageDialog(null, "E-mail com código enviado. Verifique sua caixa de entrada.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha ao enviar o e-mail. Tente novamente mais tarde.");
                    e.printStackTrace();
                    return;
                }
                
                String codigoDigitado = JOptionPane.showInputDialog(null, "Digite o código recebido por e-mail:");

                if (codigoDigitado != null && codigoDigitado.equals(codigoGerado)) {
                    JOptionPane.showMessageDialog(null, "Código confirmado com sucesso!");

                    TelaTrocarSenha telaTrocarSenha = new TelaTrocarSenha(email);
                    telaTrocarSenha.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Código inválido. Tente novamente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "E-mail não encontrado.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        System.out.println("Iniciando telaLogin...");
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background3;
    private javax.swing.JButton buttonCadastro;
    private javax.swing.JButton buttonEnter;
    private javax.swing.JLabel cpfText;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel senhaText;
    // End of variables declaration//GEN-END:variables
}
//Pronta