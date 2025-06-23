package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/nome_do_banco";
    private static final String user = "SEU_USUARIO"; //AQUI VC COLOCA SEU USUARIO DO MYSQL
    private static final String senha = "SUA_SENHA";// SENHA DO MYSQL

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
