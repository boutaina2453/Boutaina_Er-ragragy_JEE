package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {//Pour instancier l'objet du maniere dynamique
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("config.txt"));// Crée un objet Scanner pour lire le fichier "config.txt"

        String daoClassName = scanner.nextLine();//Lire la premiere ligne du fichier texte si le fichier n exista pas il va generer l'exption FileNotFoundException (Il faut connaitre le nom de la classe)
        Class cDao=Class.forName(daoClassName);//forName on le donne le nom de la classe et elle cherche si la classe existesi elle existe il va la charger en mémoire s'il n ebxiste pas il va generer une exepotion ClassNotFoundException
        IDao dao=(IDao) cDao.newInstance();//Il faut instancier la classe et il peut avoir des ecxeption InstanciationException //newInstance fait l appele au conscuteur sans parametre le cconstructeur par defaut //IllegalmAccessException on a un constructeur qui est privée
        System.out.println(dao.getData());// Affiche le nom de la classe de l'objet dao

        String MetierImplClassName = scanner.nextLine();
        Class cMetierImpl=Class.forName(MetierImplClassName);
        IMetier metier=(IMetier) cMetierImpl.newInstance();

        Method method=cMetierImpl.getMethod("setDao",IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao);//invoke pour executer la methode
        System.out.println("Résultat=>"+metier.calcul());
    }
}
