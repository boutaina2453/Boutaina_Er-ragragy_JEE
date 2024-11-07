package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculTest {
    private Calcul calcul;

    @Test
    public void testSomme() {
        calcul = new Calcul();
        double a = 5;
        double b = 2;
        double expected = 7;
        double res = calcul.somme(a, b);

        // Utilisation de assertTrue pour vérifier l'égalité
        Assertions.assertTrue(res == expected, "Le résultat attendu est 7");
    }
}
