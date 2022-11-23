package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Customer findMatchingCustomer(String email) throws CustomerNotFoundException {
        try {
            Customer c = (Customer) em.createQuery("Select c from Customer c where c.email=:email").setParameter("email", email).getSingleResult();
            return c;
        } catch (NoResultException e) {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    @Transactional
    public Customer createNewCustomer(String fname, String lname, String email) {
        Customer c = new Customer(fname, lname, email);
        em.persist(c);
        return c;
    }
}
