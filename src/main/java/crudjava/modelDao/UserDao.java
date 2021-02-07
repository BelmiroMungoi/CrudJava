package crudjava.modelDao;

import crudjava.connection.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import crudjava.model.MobileBeans;
import crudjava.model.UserBeans;

/**
 *
 * @author Belmiro-Mungoi
 */
public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = SingleConnection.getConnection();
    }

    //Metodo para salvar os dados apos a insercao
    public void salvar(UserBeans userBeans) {
        try {
            String sql = "insert into usuario(nome, email) values(?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);// Prepara a Query
            statement.setString(1, userBeans.getNome());// Recupera o nome e coloca na posicao 1  
            statement.setString(2, userBeans.getEmail());// Recupera o email e coloca na posicao 2
            statement.execute(); // Executa a query sql
            connection.commit();// Salva os dados no banco
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            try {
                connection.rollback();// Reverte ou recomeca a operacao
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
    }// fim do metodo

    //Metodo para salvar os dados na tabela telefone 
    public void salvaTelefone(MobileBeans beans) {
        try {
            String sql = "insert into telefone(numTelefone, tipo, idUser) values(?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, beans.getNumero());
            pst.setString(2, beans.getTipo());
            pst.setInt(3, beans.getIdUser1());
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }// Fim do metodo

    //Metodo para a busca ou visualizacao dos dados na tabela user 
    public List<UserBeans> exibir() {
        List<UserBeans> list = new ArrayList<UserBeans>();
        try {
            String sql = "select *from usuario";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();// Executa a query
            // Enquanto houver dados na tabela 
            while (rs.next()) {
                UserBeans beans = new UserBeans();
                beans.setIdUser(rs.getInt("idUser"));
                beans.setNome(rs.getString("nome"));
                beans.setEmail(rs.getString("email"));
                list.add(beans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }// Fim do metodo

    //Metodo que ira listar os dados da tabela telefone e a tabela usuario  
    public List listar() {
        List<MobileBeans> lista = new ArrayList<MobileBeans>();
        try {
            String sql = "select usuario.idUser, nome, email, numTelefone, tipo "
                    + "from telefone "
                    + "inner join usuario "
                    + "on telefone.idUser = usuario.idUser "
                    + "order by nome";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MobileBeans beans = new MobileBeans();
                beans.setIdUser(rs.getInt("idUser"));
                beans.setNome(rs.getString("nome"));
                beans.setEmail(rs.getString("email"));
                beans.setNumero(rs.getString("numTelefone"));
                beans.setTipo(rs.getString("tipo"));
                lista.add(beans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }//Fim do metodo

    // Metodo de busca ou pesquisa
    public UserBeans busca(int id) {
        UserBeans beans = new UserBeans();
        try {
            String sql = "select *from usuario where idUser = " + id;
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();// Executa a query
            // Enquanto houver dados na tabela 
            while (rs.next()) {

                beans.setIdUser(rs.getInt("idUser"));
                beans.setNome(rs.getString("nome"));
                beans.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return beans;
    }// Fim do metodo de pesquisa

    //Metodo de atualizacao
    public void actualiza(UserBeans userBeans) {
        try {
            String sql = "update usuario set nome = ?, email = ? where idUser = "
                    + userBeans.getIdUser();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, userBeans.getNome());
            pst.setString(2, userBeans.getEmail());
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }

    }// Fim do metodo de atualizacao 

    //Metodo para deletar dados 
    public void deletar(int id) {
        try {
            String sql = "delete from usuario where idUser = " + id;
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }// Fim do metodo
}
