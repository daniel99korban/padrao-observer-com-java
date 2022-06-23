
package observer;

/**
 *
 * @author danielkorban
 * d. O método update, herdado de Observer, deve receber como argumento um
número sorteado, e atualizar uma dada casa com -1 caso o valor sorteado esteja
na cartela. Assim podemos controlar se o jogador bateu ou não o bingo.
 */
public interface Observer {
    public void update(int numSorted);
}
