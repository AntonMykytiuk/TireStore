package ua.singleton.tirestore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.singleton.tirestore.model.Tire;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TireDaoImp implements TireDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TireDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int saveTire(Tire tire) {
        return (int) currentSession().save(tire);
    }

    @Override
    public void updateTire(Tire tire) {
        currentSession().update(tire);
    }

    @Override
    public List<Tire> loadAllTires() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Tire> query = builder.createQuery(Tire.class);
        Root<Tire> root = query.from(Tire.class);
        query.select(root);
        Query<Tire> q = currentSession().createQuery(query);
        return q.getResultList();
    }

    @Override
    public Tire loadTireById(int id) {
        return currentSession().get(Tire.class, id);
    }

    @Override
    public void deleteTire(Tire tire) {
        currentSession().delete(tire);
    }
}
