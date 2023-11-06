package ConexaoBd;

 import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao_bd {

    private final String bd = "funcionarios";
    private final String usuario = "root";
    private final String senha = "";

    public Connection estabeleceConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/" + bd,
                    usuario, senha);
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro na conexÃ£o: " + erro);
            return null;
        }
    }   
}
