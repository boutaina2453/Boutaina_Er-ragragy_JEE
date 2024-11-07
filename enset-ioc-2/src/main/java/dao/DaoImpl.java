package dao;

import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        /*
        Se connecter a la BD recupere la températue
         */
        System.out.println("Version base de données");
        double temp=Math.random()*40;
        return temp;
    }
}
