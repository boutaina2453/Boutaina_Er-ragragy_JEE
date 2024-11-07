package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component
public class DaoImplVWS implements IDao {

    @Override // @Override indique que la méthode remplace celle de la classe parente.
    public double getData() {
        System.out.println("version web service");
        return 90;
    }
}
