package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestao_bd";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    static {
        try {
            // Registrar o driver JDBC (opcional a partir do Connector/J 8.0)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            // Lidar com a exceção de carregamento do driver
            ex.printStackTrace();
        }
    }

    public static Connection conectar() {
        try {
            // Estabelecer a conexão com o banco de dados
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            // Lidar com exceções de conexão
            ex.printStackTrace();
            return null;
        }
    }

    public static void desconectar(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            // Lidar com exceções de fechamento da conexão
            ex.printStackTrace();
        }
    }
}
