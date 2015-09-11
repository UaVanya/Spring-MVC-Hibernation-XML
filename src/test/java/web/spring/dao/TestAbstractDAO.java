import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import web.spring.dao.AbstractDAO;

import javax.annotation.Resource;

/**
 * Check database connection
 */
public class TestAbstractDAO extends TestUtilsWithMemoryDB {
    @Resource
    AbstractDAO abstractDAO;

    /**
     * Check the resulting compound of the method AbstractDAO class
     */
    @Transactional
    @Test
    public void testGetSession() {
        Session sessionFactory = null;
        Assert.assertNotNull(abstractDAO.getSession());
    }
}
