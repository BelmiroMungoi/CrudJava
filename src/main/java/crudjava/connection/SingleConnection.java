package crudjava.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Belmiro-Mungoi
 */
public class SingleConnection {

    private static String url = "jdbc:mysql://localhost:3306/posjava";
    private static String user = "root";
    private static String password = "";
    private static Connection con = null;

    static {
        connect();
    }

    public SingleConnection() {
        connect();
    }

    // Metodo resposanvel pela conexao com a base de dados
    private static void connect() {
        try {
            if (con == null) {
                Class.forName("com.mysql.jdbc.Driver");// Busca o driver da BD 
                con = DriverManager.getConnection(url, user, password);// Passa os dados da BD  
                con.setAutoCommit(false);// Para nao salvar automaticamente os dados
                //JOptionPane.showMessageDialog(null, "Conexao Efectuada com sucesso");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexao nao efectuada\n" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //Metodo que retorna a conexao
    public static Connection getConnection() {
        return con;
    }
}
