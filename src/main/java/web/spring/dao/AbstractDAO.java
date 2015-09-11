package web.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Creates a SessionFactory
 */
public class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @return Session
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
