package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cv;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@ApplicationScoped
public class CvDAOImpl implements CvDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Cv getCV(int id) {
        return em.find(Cv.class, id);
    }

    @Override
    public List<Cv> getAllCv() {
        return (List<Cv>) em.createQuery("SELECT c from Cv c where c.id > 0").getResultList();
    }
}
