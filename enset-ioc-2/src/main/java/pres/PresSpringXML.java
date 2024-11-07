import metier.IMetier;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {
    public static void main(String[] args) throws BeansException {
        /* Charge le contexte Spring avec le fichier XML correct */
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Récupère le bean "metier"
        IMetier metier = (IMetier) context.getBean("metier");

        // Affiche le résultat du calcul
        System.out.println("Résultat=>"+metier.calcul());
    }
}
