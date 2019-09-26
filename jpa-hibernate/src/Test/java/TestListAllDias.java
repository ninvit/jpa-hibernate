import dao.DAO;
import dao.DAOImpl;
import model.DiaTrabalhado;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestListAllDias {

    private DAO<DiaTrabalhado> dao;

    @Inject
    public TestListAllDias(DAO<DiaTrabalhado> dao) {
        this.dao = dao;
    }

    @Transactional
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();
        DAOImpl<DiaTrabalhado> dao = new DAOImpl<>(DiaTrabalhado.class, manager);

        ArrayList<LocalDate> datas = new ArrayList<LocalDate>();

        for (int i = 0; i < dao.listAll().size(); i++) {
            datas.add(dao.listAll().get(i).getData());
        }
        System.out.println("Datas: " +datas);
        System.out.println("teste git");
    }
}
