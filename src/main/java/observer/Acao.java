
package observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author danielkorban
 * Classe publicadora
 */
public class Acao {

    private final String codigo;
    private double valor;
    // lista de interessados nas alterações dos valores 
    private Set<AcaoObserver> interessados = new HashSet<>();

    public Acao(String codigo, double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public void registraInteressado(AcaoObserver interessado) {
        this.interessados.add(interessado);
    }

    public void cancelaInteresse(AcaoObserver interessado) {
        this.interessados.remove(interessado);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        // notificar interessados
        for (AcaoObserver interessado : this.interessados) {
            interessado.notificaAlteracao(this);
        }
    }

    public String getCodigo() {
        return codigo;
    }
    
}