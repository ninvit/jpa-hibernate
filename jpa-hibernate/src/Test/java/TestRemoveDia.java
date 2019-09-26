import dao.DAO;
import dao.DAOImpl;
import model.DiaTrabalhado;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class TestRemoveDia {

    private DAO<DiaTrabalhado> dao;

    @Inject
    public TestRemoveDia(DAO<DiaTrabalhado> dao) {
        this.dao = dao;
    }

    @Transactional
    public static void main(String[] args){

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        DiaTrabalhado diaTrabalhado = new DiaTrabalhado();
        DAOImpl<DiaTrabalhado> dao = new DAOImpl<>(DiaTrabalhado.class, manager);
        diaTrabalhado.setId(3);
        dao.remove(diaTrabalhado);
    }
}
