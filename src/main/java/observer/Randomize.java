
package observer;

import java.util.Random;

/**
 *
 * @author danielkorban
 */
public class Randomize {
      public static int getValueRand(int max){
        Random random = new Random();
        // gera um numero aleatório dentro com conjunto (0 - maxNumber)
        int valorSorteado = random.nextInt(max);
        return valorSorteado;
    }
}
