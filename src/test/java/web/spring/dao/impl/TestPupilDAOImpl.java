import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import web.spring.entity.KnowledgeLevelEnum;
import web.spring.entity.Pupil;
import web.spring.service.PupilService;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPupilDAOImpl extends TestUtilsWithMemoryDB {

    @Autowired
    private PupilService pupilService;

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#getAllPupils(Long id)
     */
    @Test
    public void testGetAllPupils() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupilById");
        pupil.setClassroom("1");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);
        List<Pupil> pupilList = pupilService.getAllPupils();
        assertNotNull(pupilList);
    }

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#getPupilById(Long id)
     */
    @Test
    public void testGetPupilById() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupilById");
        pupil.setClassroom("1");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);

        assertEquals(pupilService.getPupil(Long.valueOf(pupil.getId())).toString(), pupil.toString());
    }

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#getPupilById(String knowledgeLevel)
     */
    @Test
    public void testGetPupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupil");
        pupil.setClassroom("1");
        pupil.setAddress("Test");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);

        List<Pupil> pupilList = pupilService.getPupil("HI");
        assertNotNull(pupilList);
    }

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#changePupil(Pupil pupil)
     */
    @Test
    public void testChangePupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("ChangePupil");
        pupil.setClassroom("4");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.LOW);
        pupilService.addPupil(pupil);

        String changeSurname = "ChangePupilSuccessfully";
        pupil.setSurname(changeSurname);
        pupilService.changePupil(pupil);

        assertEquals(pupil.getSurname(), changeSurname);
    }

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#deletePupil(Long id)
     */
    @Test
    public void testDeletePupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("DeletePupil");
        pupil.setClassroom("4");
        pupil.setAddress("Test");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.LOW);
        pupilService.addPupil(pupil);

        pupilService.deletePupil(Long.valueOf(pupil.getId()));

        assertNull(pupilService.getPupil(Long.valueOf(pupil.getId())));
    }

    /**
     * Checks for correct operation of method @see package.web.spring.doa.impl.PupilDAOImpl#addPupil(Pupil pupil)
     */
    @Test
    public void testAddPupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("AddPupil");
        pupil.setClassroom("5");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.MIDDLE);
        pupilService.addPupil(pupil);

        assertEquals(pupilService.getPupil(Long.valueOf(pupil.getId())).getId(), pupil.getId());
    }
}
