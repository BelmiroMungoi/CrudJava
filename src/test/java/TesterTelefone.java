
import java.util.List;
import javax.swing.JOptionPane;
import crudjava.model.MobileBeans;
import crudjava.modelDao.UserDao;
import org.junit.Test;

/**
 *
 * @author Belmiro-Mungoi
 */
public class TesterTelefone {

    @Test
    public void inserirTelefone(){/*
        MobileBeans beans = new MobileBeans();
        String numero = JOptionPane.showInputDialog("Insira o numero de telefone");
        String tipo = JOptionPane.showInputDialog("Insira o tipo");
        String idUser = JOptionPane.showInputDialog("Insira o ID do usuario a quem pertence");
        
        beans.setNumero(numero);
        beans.setTipo(tipo);
        beans.setIdUser(Integer.valueOf(idUser));
        
        UserDao dao = new UserDao();
        dao.salvaTelefone(beans);*/
        
    }
    
    @Test
    public void listar(){
        UserDao dao = new UserDao();
        List<MobileBeans> listaa = dao.listar();
        for (MobileBeans mobileBeans : listaa) {
            System.out.println(mobileBeans.toString());
            
        }
    }
}
