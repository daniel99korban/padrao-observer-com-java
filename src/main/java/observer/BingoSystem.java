
package observer.pratica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author danielkorban
 */
public class BingoSystem {
    
    private static BingoSystem uniqueInstance;// referente ao padrão singleton
    private Set<Observer> bingoCards;
    private Set<Integer> numbersSorted; // guardar valores sorteados durante o jogo  
    private int numberDrawn;// num sorteado
    private boolean gameEnded;// inidica se alguém bateu
    
    private BingoSystem() {
        this.bingoCards = new HashSet<>();
        this.numbersSorted = new HashSet<>();
    }
    /**
     * @return retorna uma instância de BingoSystem
     */
    public static BingoSystem getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new BingoSystem();
        return uniqueInstance;
    }
    
    public void subscribe(Observer cartelasRegistradas){
        this.bingoCards.add(cartelasRegistradas);
    }
    
    public void notifyObservers(){
     
        for (Observer ownerCard : this.bingoCards) {
            ownerCard.update(this.numberDrawn);
            
            BingoCard bC = (BingoCard) ownerCard;
            
            System.out.println("cartela de numero: " + bC.getCardId() + " sendo notificada!");
            System.out.println("cardNumbers: " + bC.getCopyNumbers());
            System.out.println("--------------------------------------");
            
            // exibir cartela premiada!
            if(this.isGameEnded()) break;            
            
        }
    }
    
    public void startBingo(int maxNumber){
        // indicar que alguem ja bateu
        if(this.isGameEnded()){
            System.out.println("Numeros chamados no sorteio: \n" + this.numbersSorted);
            // buscar e exibir cartela que bateu
            for (Observer ownerCard : this.bingoCards){
                BingoCard bC = (BingoCard) ownerCard;
                if(bC.didWin()){
                    bingo(bC.toString());
                    break;
                }
            }
            return;
        } 
        
        this.numberDrawn = Randomize.getValueRand(maxNumber);
        
        
        // registrar valor
        this.numbersSorted.add(numberDrawn);
        
        notifyObservers();
        
        startBingo(maxNumber);
  
    }
    
    
    public void bingo(String message){
        System.out.println("Gannhador!\n" + message);
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public Set<Observer> getBingoCards() {
        return bingoCards;
    }
    
}