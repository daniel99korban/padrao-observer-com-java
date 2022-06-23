
package observer;

/**
 *
 * @author danielkorban
 * 
 */
public class TesteObserver {
    public static void main(String[] args) {
        Acao acao = new Acao("VALE3", 45.27);
        Acao acao2 = new Acao("acao espec", 45.27);
        
        Corretora corretora1 = new Corretora(" Daniel-Imoveis ");
        Corretora corretora2 = new Corretora(" Samara-Imobiliaria ");
        
        acao.registraInteressado(corretora1);
        acao.registraInteressado(corretora2);
        acao2.registraInteressado(corretora1);
        
        acao2.setValor(80);
        acao.setValor(50);
        acao.setValor(45);
    }
    
}