package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotaion {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("dao","metier","ext"); //Scannerle package dao et le package metier
        IMetier metier=context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
