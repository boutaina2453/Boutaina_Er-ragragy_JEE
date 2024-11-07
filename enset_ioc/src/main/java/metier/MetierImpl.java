package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    //Couplage faible
    private IDao dao; //depand des interfaces et pas de classe

    @Override
    public double calcul() {
        double tmp = dao.getData();
        double res = tmp * 540 / Math.cos(tmp * Math.PI);

        return res;
    }

    /*
    Injecter dans la variable dao un objet d'une classe qui implemente l'interface IDao
    */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

}
