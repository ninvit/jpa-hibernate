import dao.DAO;
import dao.DAOImpl;
import model.DiaTrabalhado;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class TestPersistDia {

    private DAO<DiaTrabalhado> dao;

    @Inject
    public TestPersistDia(DAO<DiaTrabalhado> dao) {
        this.dao = dao;
    }

    @Transactional
    public static void main(String[] args){

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        DiaTrabalhado diaTrabalhado = new DiaTrabalhado();
        diaTrabalhado.setData(LocalDate.now());
        diaTrabalhado.setEntrar(Instant.now());
        diaTrabalhado.setComer(Instant.now().plusSeconds(1000));
        diaTrabalhado.setVoltar(Instant.now().plusSeconds(10000));
        diaTrabalhado.setSair(Instant.now().plusSeconds(100000));
        DAOImpl<DiaTrabalhado> dao = new DAOImpl<>(DiaTrabalhado.class, manager);
        dao.save(diaTrabalhado);

        Duration horasDeTrabalho1 = Duration.between(diaTrabalhado.getEntrar(), diaTrabalhado.getComer());
        Duration horasDeTrabalho2 = Duration.between(diaTrabalhado.getVoltar(), diaTrabalhado.getSair());
        Long totalHorasDia = horasDeTrabalho1.toHours() + horasDeTrabalho2.toHours();
        System.out.println("Total! " + totalHorasDia);
    }
}
