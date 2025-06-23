package codigo;
import br.com.login.modle.loginView.TelaLogin;

public class Cliente {
    private String nome;
    private String cpf;
    private double saldo;
    private String senha;
    private String sexo;
    private String telefone;
    private String email;
    private int denuncias;
    private String contaBloqueada;
    
    // pra realizar o bloqueio
    private int tentativaSenha = 0;
    private int tempoDeBloqueio = 5000;
    private int nTempo = 5;
    static double valorLimite = 3000;

    public Cliente(String nome, String cpf, double saldo, String senha, String sexo, String telefone, String email, int denuncias, String contaBloqueada) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
        this.senha = senha;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.denuncias = denuncias;
        this.contaBloqueada = contaBloqueada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() { 
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getDenuncias(){
        return denuncias;
    }
    
    public void setDenuncias(int denuncias){
        this.denuncias = denuncias;
    }
    
    public String getContaBloqueada() {
        return contaBloqueada;
    }
    
    public void setContaBloqueada(String contaBloqueada) {
        this.contaBloqueada = contaBloqueada;
    }

    public void boasVindas(){
        System.out.println(""); // só pra pular linha
        System.out.println("Acesso liberado!");
        System.out.println("Boas vindas ao A3-Bank, " + nome + "!");
    }

    public void informacaoConta(){
        System.out.println(""); // só pra pular linha 
        System.out.println("Informações da conta: ");
        System.out.println("Nome: " + nome);
        System.out.println("Sexo: " + sexo);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Saldo: R$" + saldo);
        System.out.println(""); // só pra pular linha 
    }

    public void mostrarSaldo(){ 
        System.out.println("Seu saldo atual é: R$" + saldo);
    }

    public double depositar(double valorDeposito, ClienteDAO clienteDAO, boolean mensagem){
        saldo += valorDeposito;
        clienteDAO.atualizarSaldo(cpf, saldo);
        clienteDAO.registrarTransacao(cpf, "Depósito", valorDeposito, null);

        if(mensagem) {
        System.out.println(""); // só pra pular linha
        System.out.println("Deposito efetuado");
        System.out.println("Novo saldo atual: R$" + saldo);
        }

        return saldo;
    }

    public double transferir(double valorTransferencia, ClienteDAO clienteDAO) {
        saldo -= valorTransferencia;
        clienteDAO.atualizarSaldo(cpf, saldo);
        System.out.println("");
        System.out.println("Transferência realizada, seu saldo atual é: R$" + saldo); 
        return saldo;
    }
    
    // verificações antigas, antes da interface
    public boolean verificarTransferencia(double valorTransferencia){
        if(valorTransferencia > saldo) {
            System.out.println("Não há saldo o suficiente para realizar a transferência!");
            System.out.println("Transferência cancelada.");
            return false;
        } else if(valorTransferencia <= 0) {
            System.out.println("Não é possivel transferir valores negativos ou nulos.");
            System.out.println("Transferência cancelada.");
            return false;
        } else if(valorTransferencia > valorLimite && valorTransferencia <= saldo) {
            System.out.println("Alerta: transferência acima de R$3.000 será registrada e verificada.");
            return true;
        } else {
            return true;
        }
    }
    
    public boolean verificarDeposito(double valorDeposito) {
        if(valorDeposito <= 0) {
            System.out.println(""); // pra pular linha
            System.out.println("Impossivel depositar um valor nulo ou negativo");
            System.out.println("Deposito cancelado.");
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarSenha(String respostaSenha){
        String hashDigitado = SegurancaHelper.gerarHash(respostaSenha);
        
        if(this.senha.equals(hashDigitado)){
                System.out.println(""); // só pra pular linha
                return true;
            } else {
                System.out.println(""); // pular linha
                System.out.println("Senha incorreta, transferência cancelada.");
                System.out.println(""); // só pra pular linha
                return false;
            }      
    }

    public boolean verificarSenhaLogin (String respostaSenha) {
        String hashDigitado = SegurancaHelper.gerarHash(respostaSenha);

        if(this.senha.equals(hashDigitado)){
            tentativaSenha = 0;
            tempoDeBloqueio = 5000;
            nTempo = 5;
            return true;
        } else {
            tentativaSenha++;
            return false;
        }
    }
    
    public boolean precisaBloquearTemporariamente() {
    return tentativaSenha >= 3 && tentativaSenha < 5;
    }

    public boolean contaBloqueada() {
        return tentativaSenha == 5;
    }

    public int getTempoDeBloqueio() {
        return tempoDeBloqueio;
    }

    public void aumentarBloqueio() {
        tempoDeBloqueio += 5000;
        nTempo += 5;
    }
}
//a