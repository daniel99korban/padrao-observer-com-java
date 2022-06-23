
package observer.pratica;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author danielkorban
 * 
 * Classe observer
 */
public class BingoCard implements Observer{
    
    private int cardId;  
    private int[] numbers;
    // auxiliar para evitar valores repetidos no sorteio usando a funcão add que retorna false caso o valor ja esteja na estrutura
    private Set<Integer> copyNumbers;// todos os numeros sorteados
    private BingoSystem subject;
    /**
     * @param subject
     * @param cardId
     * @param numberOfSlots número de casas de cada cartela
     * @param maxNumber maior número possível da cartela
     */
    public BingoCard(BingoSystem subject, int cardId, int numberOfSlots, int maxNumber){
        this.subject = subject;
        this.cardId = cardId;
        // this.numbers = new int[numberOfSlots];
        this.numbers = new int[numberOfSlots];
        this.copyNumbers = new HashSet<>();
        // gerar cartela mas valores podem se repetir
        for(int i = 0; i < numbers.length; i++){
            int value = Randomize.getValueRand(maxNumber);
            numbers[i] = value;
            // evitar valores repetidos refazendo o sorteio
            /*if(!this.numbers.add(value)){
                i--;
            }else{
                this.numbers.add(value);
            }*/
            this.copyNumbers.add(value);
        }
        
    }
    
    /*private void compareValue(int value, int numSorted){
         if(value == numSorted){
            System.out.println("Numero: " + numSorted + " foi marcado na cartela!");
            this.numbers.remove(value);
            this.numbers.add(value);
            //this.numbers[i] = -1; 
         }
    }*/   
    
    @Override
    public void update(int numSorted) { 
        // buscar e marcar valor como contido na cartela (-1)
        for(int i= 0; i < numbers.length; i++){
            if(this.numbers[i]  == numSorted){
                System.out.println("Numero: " + numSorted + " foi marcado na cartela!");
                this.numbers[i] = -1; 
            }
        }
        
        //this.numbers.forEach(value -> this.compareValue(value, numSorted));

        // uma cartela ja foi sorteada
        if(didWin()){
            this.subject.setGameEnded(true);
        }
    }
    
    public boolean didWin(){
        boolean winner = true;
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] != -1) winner = false;
        }
        return winner;
    }
    
    public int getCardId() {
        return cardId;
    }

    public Set<Integer> getCopyNumbers() {
        return copyNumbers;
    }
    

    @Override
    public String toString() {
        return "DADOS CARTELA\n{" + "\n    cardId : " + this.getCardId() + "\n    cardNumbers: "+ copyNumbers + "\n}";
    }
    
}