package codigo;

// ALGUMAS ADPTAÇÕES PRA QUNADO O PROJETO AINDA NÃO TINHA INTERFACE

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //String[] loginsCadastrados = {"ricardo@gmail.com", "erick@gmail.com"};
        //String email = "";
        //String senha = "";
        //Cliente cliente1 = new Cliente("", "", 0);
        ClienteDAO clienteDAO = new ClienteDAO();
        boolean menuRepeticao = true;
        boolean continuaEmail = true;
        boolean continuaSenha = true;
        Cliente cliente1 = null;

        // parte do login
        while(continuaEmail){ 
            System.out.println("Digite seu login (email):"); 
            String respostaEmail = entrada.nextLine(); 

            cliente1 = clienteDAO.buscarPorEmail(respostaEmail);

            if (cliente1 != null) {
                continuaEmail = false;
            } else {
                System.out.println("");
                System.out.println("Login incorreto ou não encontrado. Tente novamente.");
                System.out.println("");
            }
            /*for(String loginCorreto : loginsCadastrados) {
             if(respostaEmail.equals(loginCorreto)) {
                continuaEmail = false;
                email = respostaEmail;
                break;
             }   
            }
            if(continuaEmail){
                System.out.println("login incorreto, tente novamnete.");
            }*/
        }
        /*switch(email) {
            case "ricardo@gmail.com":
            senha = "123456";
            cliente1 = new Cliente("Ricardo", "000", 2000);
            break;

            case "erick@gmail.com":
            senha = "654321";
            cliente1 = new Cliente("Erick", "111",6000);
            break;
        }*/

        // parte da senha
        while(continuaSenha) {
            System.out.println("Digite sua senha: ");
            String respostaSenha = entrada.nextLine();

            //cliente1.verificarSenhaLogin(respostaSenha) - chamar estava duplicando junto com if
            if(cliente1.verificarSenhaLogin(respostaSenha)) {
                continuaSenha = false;
            }

        }

        // dentro do app
        cliente1.boasVindas();
        cliente1.informacaoConta();
        
        while(menuRepeticao) {
            System.out.println(""); // só pra pular linha           
            System.out.println("""
                Menu de opções:

            ********************************
            1 - Para realizar transferência 
            2 - Para depositar 
            3 - Consultar saldo
            4 - Histórico de transação
            5 - Denunciar PIX suspeito
            6 - Histórico de denúncias 
            0 - Sair do aplicativo 
            ********************************

            Digite a opção desejada: """);
            int escolhaMenu = entrada.nextInt();
            System.out.println(""); // só pra pular linha

            switch (escolhaMenu) {
                case 1:                
                System.out.println("Qual valor deseja transferir:");
                double valorTransferencia = entrada.nextDouble();
                System.out.println(""); // só pra pular linha
                entrada.nextLine(); // pra nao bugar com o enter

                if(cliente1.verificarTransferencia(valorTransferencia) == false) break;

                System.out.println("Digite a chave para qual vai transferir: ");
                String chaveTransferencia = entrada.nextLine();
                System.out.println(""); // só pra pular linha
                Cliente destinatario = clienteDAO.buscarChave(chaveTransferencia);

                if(destinatario == null) {
                    System.out.println("Chave PIX não encontrada, transferência cancelada.");
                    break;
                }

                System.out.println("Transferência no valor de R$" + valorTransferencia + " para " + destinatario.getNome() + " | " + chaveTransferencia + " está correto?");
                String respostaTransferencia = entrada.nextLine();

                if(respostaTransferencia.equalsIgnoreCase("sim")) {
                    System.out.println(""); //pular linha
                    System.out.println("Digite sua senha: ");
                    String respostaSenha = entrada.nextLine();

                    if(!cliente1.verificarSenha(respostaSenha)) break;

                    cliente1.transferir(valorTransferencia, clienteDAO);
                    clienteDAO.registrarTransacao(cliente1.getCpf(), "Transferência enviada", valorTransferencia, chaveTransferencia);
                    destinatario.depositar(valorTransferencia, clienteDAO, false);
                    clienteDAO.registrarTransacao(destinatario.getCpf(), "Transferência Recebida", valorTransferencia, cliente1.getCpf());

                } else { 
                    System.out.println("");
                    System.out.println("Transferência cancelada.");
                } 
                break;

                case 2:
                System.out.println("Qual valor do depósito: ");
                double valorDeposito = entrada.nextDouble();
                //cliente1.verificarDeposito(valorDeposito);
                if(cliente1.verificarDeposito(valorDeposito)) {
                    cliente1.depositar(valorDeposito, clienteDAO, true);
                }
                break;

                case 3: 
                cliente1.mostrarSaldo();
                break;

                case 4:
                clienteDAO.mostrarHistoricoTransacoes(cliente1.getCpf());
                break;

                case 5:
                entrada.nextLine(); //não bugar com enter
                System.out.println("Qual seria a chave PIX suspeita:");
                String chaveSuspeita = entrada.nextLine();
                System.out.println("");
                System.out.println("Qual o motivo:");
                String motivo = entrada.nextLine();
                System.out.println("");
                System.out.println("Qual o tipo da transação(Transferência, Depósito):");
                String tipo = entrada.nextLine();
                System.out.println("");
                System.out.println("Qual o valor da transação:");
                double valor = entrada.nextDouble();
            
                clienteDAO.registrarDenuncia(cliente1.getCpf(), chaveSuspeita, tipo, valor, motivo);
                break;
                
                case 6:
                clienteDAO.listarDenuncias(cliente1.getCpf());
                break;
                
                case 0:
                menuRepeticao = false;
                break;
        
                default:
                System.out.println("Digite apenas uma das opções!");
                break;
            }
        }
        /*if(!denuncias.isEmpty()){
            System.out.println("Denúncias registradas nessa sessão:");
            for(String d : denuncias) {
                System.out.println("- " + d);
            }
        }*/
        System.out.println("Fim do programa.");
        entrada.close();
    }
}


