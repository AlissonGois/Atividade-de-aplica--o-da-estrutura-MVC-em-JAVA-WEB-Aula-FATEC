package Model;

import ConexaoBd.Conexao_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioModelo {
    
    public boolean Gravar(String nome, String cargo, double salario) {
        try {
            Connection con = new Conexao_bd().estabeleceConexao();
            if (con != null) {
                PreparedStatement ps;
                String sql = "insert into cadastrofun (nome,cargo,salario) values (?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1,nome);
                ps.setString(2, cargo);
                ps.setDouble(3, salario);
                
                if (ps.executeUpdate() != 0) {
                    System.out.println("Sucesso ao inserir");
                    con.close();
                    return true;
                } else {
                    System.out.println("Não foi possível inserir");
                    return false;
                }
            }

        } catch (SQLException erro) {
            System.out.println("Exceção causada na inserção");
            return false;
        }
        return false;
    }
}
