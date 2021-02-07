
import java.util.List;
import javax.swing.JOptionPane;
import crudjava.model.UserBeans;
import crudjava.modelDao.UserDao;
import org.junit.Test;

/**
 *
 * @author Belmiro-Mungoi
 */
public class Tester {

    @Test
    public void inserir() {
        UserDao dao = new UserDao();
        UserBeans beans = new UserBeans();

        String nome = JOptionPane.showInputDialog("Insira o nome");
        String email = JOptionPane.showInputDialog("Insira o Email");

        beans.setNome(nome);
        beans.setEmail(email);

        dao.salvar(beans);
    }

    @Test
    public void listar() {
        UserDao dao = new UserDao();
        List<UserBeans> list = dao.exibir();
        for (UserBeans userBeans : list) {
            System.out.println(userBeans.toString());
            System.out.println("----------------------");
        }
    }

    @Test
    public void buscar() {
        UserDao dao = new UserDao();
        String id = JOptionPane.showInputDialog("Insira o ID que deseja ver");
        UserBeans user = dao.busca(Integer.valueOf(id));
        System.out.println(user.toString());
    }

    @Test
    public void editar() {
        UserDao dao = new UserDao();
        String id = JOptionPane.showInputDialog("Insira o ID que deseja editar");
        UserBeans user = dao.busca(Integer.valueOf(id));
        String nome = JOptionPane.showInputDialog("Insira o nome");
        String email = JOptionPane.showInputDialog("Insira o Email");
        user.setNome(nome);
        user.setEmail(email);
        dao.actualiza(user);
    }

    @Test
    public void deletar() {
        UserDao dao = new UserDao();
        String id = JOptionPane.showInputDialog("Insira o ID que deseja eliminar");
        dao.deletar(Integer.valueOf(id));
    }
}
