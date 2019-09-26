import dao.DAO;
import dao.DAOImpl;
import model.DiaTrabalhado;

    import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.time.LocalDate;

public class TestUpdateDia {

    private DAO<DiaTrabalhado> dao;

    @Inject
    public TestUpdateDia(DAO<DiaTrabalhado> dao) {
        this.dao = dao;
    }

    @Transactional
    public static void main(String[] args){

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        DAOImpl<DiaTrabalhado> dao = new DAOImpl<>(DiaTrabalhado.class, manager);
        DiaTrabalhado diaTrabalhado = dao.findById(4);
        diaTrabalhado.setData(LocalDate.of(1986,07,14));
        dao.update(diaTrabalhado);
    }
}
