import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import web.spring.controller.PupilController;
import web.spring.entity.KnowledgeLevelEnum;
import web.spring.entity.Pupil;
import web.spring.service.PupilService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Checks the methods of this class
 */
public class TestPupilController extends TestUtilsWithMemoryDB {

    @Autowired
    PupilService pupilService;

    @Resource
    private PupilController controller;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#getAllPupils(Long id)
     */
    @Test
    public void testGetAllPupilsTest() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetAllPupil");
        pupil.setClassroom("1");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);

        assertEquals(mapper.writeValueAsString(pupilService.getAllPupils()), controller.getAllPupils());
    }

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#getPupilById(Long id)
     */
    @Test
    public void testGetPupilById() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupilById");
        pupil.setClassroom("1");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);

        assertEquals(mapper.writeValueAsString(pupilService.getPupil(pupil.getId())), controller.getPupilById(pupil.getId()));
    }

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#getPupilById(String knowledgeLevel)
     */
    @Test
    public void testGetPupilByKnowledgeLevel() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupilById");
        pupil.setClassroom("1");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        pupilService.addPupil(pupil);

        List<Pupil> pupilList = pupilService.getPupil(String.valueOf(KnowledgeLevelEnum.HI));
        String getPupilsFromController = controller.getPupilByKnowledgeLevel(String.valueOf(KnowledgeLevelEnum.HI));
        String getPupils = mapper.writeValueAsString(pupilService.getPupil(String.valueOf(KnowledgeLevelEnum.HI)));
        assertEquals(getPupils, getPupilsFromController);
    }

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#changePupil(Pupil pupil)
     */
    @Test
    public void testChangePupil() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("ChangePupil");
        pupil.setClassroom("4");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.LOW);
        pupilService.addPupil(pupil);

        String changeSurname = "ChangePupilController";
        pupil.setSurname(changeSurname);
        String pupilJson = mapper.writeValueAsString(pupil);
        controller.changePupil(pupilJson);

        assertEquals(pupil.getSurname(), changeSurname);
    }

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#deletePupil(Long id)
     */
    @Test
    public void testDeletePupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("DeletePupil");
        pupil.setClassroom("4");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.LOW);
        pupilService.addPupil(pupil);

        controller.deletePupil(pupil.getId());

        assertNull(pupilService.getPupil(pupil.getId()));
    }

    /**
     * Checks for correct operation of method @see package.web.spring.connector.PupilController#addPupil(Pupil pupil)
     */
    @Test
    public void testAddPupil() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("AddPupil");
        pupil.setClassroom("5");
        pupil.setAddress("Test t/t");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.MIDDLE);
        String pupilJson = mapper.writeValueAsString(pupil);

        controller.addPupil(pupilJson);
        assertEquals(pupilJson, controller.getPupilById(pupil.getId()));
    }
}
