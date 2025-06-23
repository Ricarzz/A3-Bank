package codigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import codigo.Conexao;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;



public class ClienteDAO {

    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE Email = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("Nome");
                String cpf = rs.getString("CPF");
                double saldo = rs.getDouble("Saldo");
                String senha = rs.getString("SenhaHash");
                String sexo = rs.getString("Sexo");
                String telefone = rs.getString("Telefone");
                int denuncias = rs.getInt("Denuncias");
                String contaBloqueada = rs.getString("EntradaForcada");
                return new Cliente(nome, cpf, saldo, senha, sexo, telefone, email, denuncias, contaBloqueada);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        
        return null;
    }

    public void atualizarSaldo(String cpf, double novoSaldo) {
        String sql = "UPDATE cliente SET Saldo = ? WHERE CPF = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar saldo: " + e.getMessage());
        }
    }

    public Cliente buscarChave(String chaveTransferencia) {
        String sql = "SELECT * FROM cliente WHERE CPF = ? OR Telefone = ? OR Email = ?";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chaveTransferencia);
            stmt.setString(2, chaveTransferencia);
            stmt.setString(3, chaveTransferencia);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String nome = rs.getString("Nome");
                String cpf = rs.getString("CPF");
                Double saldo = rs.getDouble("Saldo");
                String senha = rs.getString("SenhaHash");
                String sexo = rs.getString("Sexo");
                String telefone = rs.getString("Telefone");
                String email = rs.getString("Email");
                int denuncias = rs.getInt("Denuncias");
                String contaBloqueada = rs.getString("EntradaForcada");
                return new Cliente(nome, cpf, saldo, senha, sexo, telefone, email, denuncias, contaBloqueada);
            }
        } catch(SQLException e) {
            System.out.println("Erro ao encontrar chave PIX: " + e.getMessage());
        }

        return null;

    }

    public void registrarTransacao(String cpfCliente, String tipo, double valor, String chaveDestino) {
    String sql = "INSERT INTO transacao (CPF_Cliente, Tipo, Valor, Chave_Destino) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpfCliente);
            stmt.setString(2, tipo);
            stmt.setDouble(3, valor);
            stmt.setString(4, chaveDestino);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao registrar transação: " + e.getMessage());
        }
    }

    public void mostrarHistoricoTransacoes(String cpfCliente) {
    String sql = "SELECT Tipo, Valor, Data_Hora, Chave_Destino FROM transacao WHERE CPF_Cliente = ? ORDER BY Data_Hora DESC";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpfCliente);
            ResultSet resultado = stmt.executeQuery();

            System.out.println("\n     HISTÓRICO DE TRANSAÇÕES ");

            boolean encontrou = false;
            while (resultado.next()) {
                encontrou = true;
                String tipo = resultado.getString("Tipo");
                double valor = resultado.getDouble("Valor");
                Timestamp dataHora = resultado.getTimestamp("Data_Hora");
                String destino = resultado.getString("Chave_Destino");

                System.out.println("[" + dataHora + "] " + tipo + " de R$" + valor + 
                (destino != null ? " - Destino: " + destino : ""));
            }

            if (!encontrou) {
                System.out.println("Nenhuma transação encontrada.");
            }

            System.out.println("");
            System.out.println("");

        } catch (SQLException e) {
            System.out.println("Erro ao buscar histórico: " + e.getMessage());
        }
    }

    public void registrarDenuncia(String cpfCliente, String chaveSuspeita, String tipo, double valor, String motivo) {
    String sql = "INSERT INTO historico_denuncia (CPF_Cliente, Chave_Suspeita, Tipo, Data_Hora_Suspeita, Valor_Suspeita, Motivo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
        PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpfCliente);
            stmt.setString(2, chaveSuspeita);
            stmt.setString(3, tipo);
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setDouble(5, valor);
            stmt.setString(6, motivo);
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("Denúncia registrada com sucesso! Nossa equipe ja está analisando.");
        } catch (SQLException e) {
          System.out.println("Erro ao registrar denúncia: " + e.getMessage());
        }
    }

    public void listarDenuncias(String cpfCliente) {
        String sql = "SELECT * FROM historico_denuncia WHERE CPF_Cliente = ? ORDER BY Data_Hora_Suspeita DESC";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);) {
            
            stmt.setString(1, cpfCliente);    
            ResultSet rs = stmt.executeQuery();

            System.out.println("");
            System.out.println("Histórico de Denúncias:");
            System.out.println("");

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                
                String chave = rs.getString("Chave_Suspeita");
                String tipo = rs.getString("Tipo");
                Timestamp dataHora = rs.getTimestamp("Data_Hora_Suspeita");
                double valor = rs.getDouble("Valor_Suspeita");
                String motivo = rs.getString("Motivo");

                System.out.printf("| Chave suspeita: %s   | Tipo: %s   | Valor: R$%.2f%n ", chave, tipo, valor);
                System.out.printf("Motivo: %s   | Data: %s%n  ", motivo, dataHora.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                System.out.println("");
                System.out.println("");
            }

            if(!encontrou){
                 System.out.println("Nenhuma denúncia registrada por você.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar denúncias: " + e.getMessage());
        }
    }
    
    public void salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (Nome, CPF, Telefone, Email, SenhaHash, Sexo, Saldo, Denuncias) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());
            stmt.setString(6, cliente.getSexo());
            stmt.setDouble(7, cliente.getSaldo());
            stmt.setInt(8, cliente.getDenuncias());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }
    
    public boolean existeCpfOuEmail(String cpf, String email) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE CPF = ? OR Email = ?";
        try (PreparedStatement stmt = Conexao.conectar().prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setString(2, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // true se já existe 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String obterHistoricoTransacoesComoTexto(String cpfCliente) {
        StringBuilder historico = new StringBuilder();
        String sql = "SELECT Tipo, Valor, Data_Hora, Chave_Destino FROM transacao WHERE CPF_Cliente = ? ORDER BY Data_Hora DESC";

        NumberFormat formatoBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpfCliente);
            ResultSet resultado = stmt.executeQuery();

            boolean encontrou = false;
            while (resultado.next()) {
                encontrou = true;
                String tipo = resultado.getString("Tipo");
                double valor = resultado.getDouble("Valor");
                Timestamp dataHora = resultado.getTimestamp("Data_Hora");
                String destino = resultado.getString("Chave_Destino");

                historico.append("[")
                     .append(dataHora.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                     .append("] ")
                     .append(tipo)
                     .append(" de ")
                     .append(formatoBR.format(valor));

                if (destino != null && !destino.isEmpty()) {
                    historico.append(" - Destino: ").append(destino);
                }

                historico.append("\n");
            }

            if (!encontrou) {
                historico.append("Nenhuma transação encontrada.\n");
            }

        } catch (SQLException e) {
            historico.append("Erro ao buscar histórico: ").append(e.getMessage()).append("\n");
        }
        return historico.toString();
    }
    
    public String obterDenunciasComoTexto(String cpfCliente) {
        StringBuilder denuncias = new StringBuilder();
        String sql = "SELECT * FROM historico_denuncia WHERE CPF_Cliente = ? ORDER BY Data_Hora_Suspeita DESC";

        NumberFormat formatoBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        try (Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpfCliente);
            ResultSet rs = stmt.executeQuery();

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;

                String chave = rs.getString("Chave_Suspeita");
                String tipo = rs.getString("Tipo");
                Timestamp dataHora = rs.getTimestamp("Data_Hora_Suspeita");
                double valor = rs.getDouble("Valor_Suspeita");
                String motivo = rs.getString("Motivo");

                denuncias.append("Chave suspeita: ").append(chave)
                     .append(" |  Tipo: ").append(tipo)
                     .append(" |  Valor: ").append(formatoBR.format(valor)).append("\n")
                     .append("Motivo: ").append(motivo)
                     .append(" |  Data: ").append(dataHora.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                     .append("\n\n");
            }

            if (!encontrou) {
                denuncias.append("Nenhuma denúncia registrada por você.\n");
            }

        } catch (SQLException e) {
            denuncias.append("Erro ao listar denúncias: ").append(e.getMessage()).append("\n");
        }
        return denuncias.toString();
}
        
    public void addDenuncia(String cpf) {
        String sql = "UPDATE cliente SET Denuncias = Denuncias + 1 WHERE CPF = ?";
        
        try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int buscarQuantidadeDenuncia(String cpf) {
        String sql = "SELECT Denuncias FROM cliente WHERE CPF = ?";
        int denuncias = 0;
        
        try(Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                denuncias = rs.getInt("Denuncias");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return denuncias;
    }
    
    public double buscarTotalTransferenciasRecentes(String cpf, int minutos) {
        String sql = "SELECT SUM(Valor) FROM transacao WHERE CPF_Cliente = ? AND Tipo = 'Transferência enviada' AND Data_Hora >= ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            LocalDateTime limite = LocalDateTime.now().minusMinutes(minutos);
            stmt.setTimestamp(2, Timestamp.valueOf(limite));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    public void salvarCodigoRecuperacao(String email, String codigoGerado) {
        String sql = "INSERT INTO recuperacao_senha (Email, Codigo, expira) VALUES (?, ?, ?)";
    
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        
            stmt.setString(1, email);
            stmt.setString(2, codigoGerado);
        
        // Define expiração para 15 minutos a partir de agora
            LocalDateTime expira = LocalDateTime.now().plusMinutes(15);
            stmt.setTimestamp(3, Timestamp.valueOf(expira));
        
            stmt.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean verificarCodigoRecuperacao(String email, String codigo) {
        String sql = "SELECT * FROM recuperacao_senha WHERE Email = ? AND Codigo = ? AND expira > NOW()";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        
            stmt.setString(1, email);
            stmt.setString(2, codigo);
        
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void trocarSenha(String email, String novaSenhaHash) {
        String sql = "UPDATE cliente SET SenhaHash = ? WHERE Email = ?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaSenhaHash);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagarCodigoRecuperacao(String email) {
        String sql = "DELETE FROM recuperacao_senha WHERE Email = ?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String gerarCodigoVerificacao() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Gera número de 6 dígitos
        return String.valueOf(codigo);
    }
    
    public void atualizarDenunciasParaTres(String cpf) {
    String sql = "UPDATE cliente SET Denuncias = 3 WHERE CPF = ?";
    
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
        
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void bloquearConta(String cpf) {
        String sql = "UPDATE cliente SET EntradaForcada = 'SIM' WHERE CPF = ?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao bloquear conta: " + e.getMessage());
        }
    }
    
    public boolean buscarContaBloqueada(String cpf) {
        String sql = "SELECT EntradaForcada FROM cliente WHERE CPF = ?";
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return "SIM".equalsIgnoreCase(rs.getString("ContaBloqueada"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar bloqueio: " + e.getMessage());
        }
        return false;
    }
    
    public void desbloquearConta(String cpf) {
        String sql = "UPDATE cliente SET EntradaForcada = 'NAO' WHERE cpf = ?";
    
        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf); 
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

    
//
