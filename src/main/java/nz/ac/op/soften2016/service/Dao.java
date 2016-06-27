package nz.ac.op.soften2016.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Basic DAO operations dependent with Hibernate's specific classes
 * @see SessionFactory
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class Dao {

    private SessionFactory sessionFactory;

    public Dao() {

    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Class entity) {
        currentSession().save(entity);
    }

    public void update(Class entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void remove(Class entity) {
        currentSession().delete(entity);
    }

    public Class find(Class entity, Long key) {
        return (Class) currentSession().get(entity, key);
    }

    public List<Class> list(Class entity) {
        return currentSession().createCriteria(entity).list();
    }
}