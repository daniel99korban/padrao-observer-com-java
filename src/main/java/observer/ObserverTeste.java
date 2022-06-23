
package observer.pratica;

/**
 *
 * @author danielkorban
 */
public class ObserverTeste {

    public static void main(String[] args) {
        // iniciar sistema e criar um bingo
        BingoSystem b = BingoSystem.getUniqueInstance();
        int maxNumber = 50;
        int slots = 6;
        
        Observer cartela1 = new BingoCard(b, 01, slots, maxNumber);
        Observer cartela2 = new BingoCard(b, 02, slots, maxNumber);
        Observer cartela3 = new BingoCard(b, 03, slots, maxNumber);
        Observer cartela4 = new BingoCard(b, 04, slots, maxNumber);
        Observer cartela5 = new BingoCard(b, 05, slots, maxNumber);
        // cadastrar cartelas
        b.subscribe(cartela1);
        b.subscribe(cartela2);
        b.subscribe(cartela3);
        b.subscribe(cartela4);
        b.subscribe(cartela5);
        
        b.startBingo(maxNumber);
        
    }
}
