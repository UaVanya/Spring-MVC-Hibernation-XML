package web.spring.service;

import web.spring.entity.Pupil;

import java.util.List;

/**
 * Create Service interface
 */
public interface PupilService {

    /**
     * Get all pupils list from database.
     *
     * @return all pupils
     */
    public List<Pupil> getAllPupils();

    /**
     * Get pupil by id.
     * @param id
     * @return pupil
     */
    public Pupil getPupil(Long id);

    /**
     * Get pupil by knowledge level.
     *
     * @param knowledgeLevel
     * @return pupils
     */
    public List<Pupil> getPupil(String knowledgeLevel);

    /**
     * Change an pupil.
     *
     * @param pupil
     */
    public void changePupil(Pupil pupil);

    /**
     * Delete an pupil.
     *
     * @param id
     */
    public void deletePupil(Long id);

    /**
     * Save pupil in DB.
     *
     * @param pupil
     */
    public void addPupil(Pupil pupil);
}
