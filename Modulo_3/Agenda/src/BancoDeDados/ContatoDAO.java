/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoDeDados;

/**
 *
 * @author reido
 */
import JavaBeans.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    public static boolean salvarContato(Contato contato) {
        String sql = "INSERT INTO contatos (contato, celular, email, grupo, bloqueio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, contato.getContato());
            preparedStatement.setString(2, contato.getCelular());
            preparedStatement.setString(3, contato.getEmail());
            preparedStatement.setString(4, contato.getGrupo());
            preparedStatement.setBoolean(5, contato.getBloqueio());
            int linhasAfetadas = preparedStatement.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

