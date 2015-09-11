package web.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring.dao.PupilDAO;
import web.spring.entity.Pupil;
import web.spring.service.PupilService;

import java.util.List;

/**
 * Implements class DAO @see package.web.spring.service.PupilService
 */
@Service
@Transactional
public class PupilServiceImpl implements PupilService {

    @Autowired
    private PupilDAO pupilDAO;

    /**
     * Get all pupils list from database.
     *
     * @return all pupils
     */
    @Override
    public List<Pupil> getAllPupils() {
        return pupilDAO.getAllPupils();
    }

    /**
     * Get pupil by id.
     * @param id
     * @return pupil
     */
    @Override
    public Pupil getPupil(Long id) {
        return pupilDAO.getPupil(id);
    }

    /**
     * Get pupil by knowledge level.
     *
     * @param knowledgeLevel
     * @return pupils
     */
    @Override
    public List<Pupil> getPupil(String knowledgeLevel) {
        return pupilDAO.getPupil(knowledgeLevel);
    }

    /**
     * Change an pupil.
     *
     * @param pupil
     */
    @Override
    public void changePupil (Pupil pupil) {
        pupilDAO.changePupil(pupil);
    }

    /**
     * Delete an pupil.
     *
     * @param id
     */
    @Override
    public void deletePupil(Long id) {
        pupilDAO.deletePupil(id);
    }

    /**
     * Save pupil in DB.
     *
     * @param pupil
     */
    @Override
    public void addPupil(Pupil pupil) {
        pupilDAO.addPupil(pupil);
    }
}
