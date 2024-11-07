package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {

    // Dépendance faible : MetierImpl dépend de l'interface IDao
    private IDao dao;

    /*
      Constructeur avec injection de dépendance.
     Utilise le bean nommé "dao2" pour l'injection via @Qualifier.

      @param dao un bean de type IDao nommé "dao2"
     */
    @Autowired
    public MetierImpl(@Qualifier("dao2") IDao dao) {
        this.dao = dao;
    }

    /*
      Méthode de calcul qui utilise les données de IDao.

      @return résultat du calcul en fonction des données fournies par dao
     */
    @Override
    public double calcul() {
        double tmp = dao.getData();
        return tmp * 540 / Math.cos(tmp * Math.PI);
    }

    /*
      Setter pour injection de dépendance via mutateur.
     Utilisé en cas de besoin de réinitialiser l'instance de dao.

      @param dao un objet de type IDao
     */
    @Autowired
    @Qualifier("dao2")
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
