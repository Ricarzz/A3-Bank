package br.com.login.modle.loginView;

import codigo.Cliente;
import codigo.ClienteDAO;
import codigo.SegurancaHelper;
import codigo.Conexao;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {
    private TelaLogin telaLoginRef;

    public TelaCadastro(TelaLogin telaLogin) {
        this.telaLoginRef = telaLogin;
        initComponents();
        setLocationRelativeTo(null);
        
        RadioButtonMasculino.setOpaque(false);
        RadioButtonMasculino.setContentAreaFilled(false);
        RadioButtonMasculino.setBorderPainted(false);

        RadioButtonFeminino.setOpaque(false);
        RadioButtonFeminino.setContentAreaFilled(false);
        RadioButtonFeminino.setBorderPainted(false);

        RadioButtonOutro.setOpaque(false);
        RadioButtonOutro.setContentAreaFilled(false);
        RadioButtonOutro.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Background3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TxtNome = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RadioButtonMasculino = new javax.swing.JRadioButton();
        RadioButtonFeminino = new javax.swing.JRadioButton();
        RadioButtonOutro = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        Background1 = new javax.swing.JLabel();

        Background3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        Background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/IMG_4546.JPG"))); // NOI18N
        Background3.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A3 Bank - Cadastro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 50, -1));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 130, -1));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("E-mail:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 80, -1));

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 70, -1));

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Confirma Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 130, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 130, 30));

        TxtNome.setToolTipText("");
        getContentPane().add(TxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 150, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, -1));

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Insira seus dados");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, 20));

        buttonGroup1.add(RadioButtonMasculino);
        RadioButtonMasculino.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        RadioButtonMasculino.setForeground(new java.awt.Color(242, 242, 242));
        RadioButtonMasculino.setText("Masculino");
        RadioButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonMasculinoActionPerformed(evt);
            }
        });
        getContentPane().add(RadioButtonMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        buttonGroup1.add(RadioButtonFeminino);
        RadioButtonFeminino.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        RadioButtonFeminino.setForeground(new java.awt.Color(242, 242, 242));
        RadioButtonFeminino.setText("Feminino");
        RadioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonFemininoActionPerformed(evt);
            }
        });
        getContentPane().add(RadioButtonFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        buttonGroup1.add(RadioButtonOutro);
        RadioButtonOutro.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        RadioButtonOutro.setForeground(new java.awt.Color(242, 242, 242));
        RadioButtonOutro.setText("Outro");
        RadioButtonOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonOutroActionPerformed(evt);
            }
        });
        getContentPane().add(RadioButtonOutro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Sexo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 150, -1));

        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 150, -1));

        Background1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background0.jpG"))); // NOI18N
        Background1.setText("jLabel1");
        getContentPane().add(Background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = TxtNome.getText();
        String cpf = jTextField2.getText();
        String telefone = jTextField3.getText();
        String email = jTextField4.getText();
        String senha = new String(jPasswordField1.getPassword());
        String confirmaSenha = new String(jPasswordField2.getPassword());
        
        if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }
        
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Formato de e-mail inválido.");
            return;
        }

        if (!senha.equals(confirmaSenha)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
            return;
        }
        
        String sexo = "";
        if (RadioButtonMasculino.isSelected()) {
            sexo = "Masculino";
        } else if (RadioButtonFeminino.isSelected()) {
            sexo = "Feminino";
        } else if (RadioButtonOutro.isSelected()) {
            sexo = "Outro";
        }
        
        String senhaHash = SegurancaHelper.gerarHash(senha);
        
        Cliente cliente = new Cliente(nome, cpf, 0.0, senhaHash, sexo, telefone, email, 0, "NAO");
        
        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.existeCpfOuEmail(cpf, email)) {
            JOptionPane.showMessageDialog(this, "CPF ou e-mail já cadastrado.");
            return;
        }
        
        try {
            clienteDAO.salvarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cadastro realizado! Bem vindo(a) à família A3 Bank!");
            this.dispose();
            telaLoginRef.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
        }

        //cliente.setSaldo(0.0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void RadioButtonMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonMasculinoActionPerformed

    private void RadioButtonFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonFemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonFemininoActionPerformed

    private void RadioButtonOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonOutroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonOutroActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel Background3;
    private javax.swing.JRadioButton RadioButtonFeminino;
    private javax.swing.JRadioButton RadioButtonMasculino;
    private javax.swing.JRadioButton RadioButtonOutro;
    private javax.swing.JTextField TxtNome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
//rr