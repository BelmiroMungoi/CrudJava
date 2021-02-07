package crudjava.model;

/**
 *
 * @author Belmiro-Mungoi
 */
public class MobileBeans extends UserBeans{

    private int idTel;
    private String numero;
    private String tipo;
    private int idUser1;

    public int getIdTel() {
        return idTel;
    }

    public void setIdTel(int idTel) {
        this.idTel = idTel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUser1() {
        return idUser1;
    }

    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }

    @Override
    public String toString() {
        return "Id: " + idUser + "\tNome: " + nome + "\tEmail: " + email +
                "\tNumero: " + numero + "\tTipo: " + tipo;
    }
    
    
}
