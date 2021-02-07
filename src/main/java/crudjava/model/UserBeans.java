package crudjava.model;

/**
 *
 * @author Belmiro-Mungoi
 */
public class UserBeans {
    
    protected int idUser;
    protected String nome;
    protected String email;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: " + idUser + "\tNome: " + nome + "\tEmail: " + email;
    }
    

}
