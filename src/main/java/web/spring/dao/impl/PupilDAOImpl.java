package web.spring.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.spring.dao.AbstractDAO;
import web.spring.dao.PupilDAO;
import web.spring.entity.KnowledgeLevelEnum;
import web.spring.entity.Pupil;

import java.util.List;

/**
 * Implements class DAO @see package.web.spring.dao.PupilDAO
 */
@Repository
public class PupilDAOImpl extends AbstractDAO implements PupilDAO {

    /**
     * Get all pupils list from database.
     *
     * @return all pupils
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Pupil> getAllPupils() {
        return (List<Pupil>) getSession().createCriteria(Pupil.class).list();
    }

    /**
     * Get pupil by id.
     * @param id
     * @return pupil
     */
    @Override
    public Pupil getPupil(Long id) {
        return (Pupil) getSession().get(Pupil.class, id);
    }

    /**
     * Get pupil by knowledge level.
     *
     * @param knowledgeLevel
     * @return pupils
     */
    @Override
    public List<Pupil> getPupil(String knowledgeLevel) {
        KnowledgeLevelEnum knowledgeLevelEnum = KnowledgeLevelEnum.parse(knowledgeLevel);
        Criteria criteria = getSession().createCriteria(Pupil.class);
        return criteria.add(Restrictions.eq("knowledgeLevel", knowledgeLevelEnum)).list();
    }

    /**
     * Change an pupil.
     *
     * @param pupil
     */
    @Override
    public void changePupil(Pupil pupil) {
        getSession().update(pupil);
    }

    /**
     * Delete an pupil.
     *
     * @param id
     */
    @Override
    public void deletePupil(Long id) {
        Pupil pupil = (Pupil) getSession().load(Pupil.class, id);
        getSession().delete(pupil);
    }

    /**
     * Save pupil in DB.
     *
     * @param pupil
     */
    @Override
    public void addPupil(Pupil pupil) {
        try {
            Session session = getSession();
            session.flush();
            session.save(pupil);
        }catch  (Exception e){
            e.printStackTrace();
        }
    }
}
