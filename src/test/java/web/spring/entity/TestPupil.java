import org.junit.Test;
import static org.junit.Assert.*;

import web.spring.entity.KnowledgeLevelEnum;
import web.spring.entity.Pupil;

/**
 * Checks the setter/getter values of this class entity
 */
public class TestPupil {
    private static Pupil pupil = new Pupil();

    /**
     * Check the correctly established 'id'
     */
    @Test
    public void TestSetGetId() {
        int id = 5;
        pupil.setId(id);
        assertEquals(id, pupil.getId());
    }

    /**
     * Check the correctly established 'firstname'
     */
    @Test
    public void TestSetGetFirstname() {
        String firstname = "TestFirstname";
        pupil.setFirstname(firstname);
        assertEquals(firstname, pupil.getFirstname());
    }

    /**
     * Check the correctly established 'surname'
     */
    @Test
    public void TestSetGetSurname() {
        String surname = "TestSurname";
        pupil.setSurname(surname);
        assertEquals(surname, pupil.getSurname());
    }

    /**
     * Check the correctly established 'classroom'
     */
    @Test
    public void TestSetGetClassroom() {
        String classroom = "John";
        pupil.setClassroom(classroom);
        assertEquals(classroom, pupil.getClassroom());
    }

    /**
     * Check the correctly established 'address'
     */
    @Test
    public void TestSetGetAddress() {
        String address = "John";
        pupil.setAddress(address);
        assertEquals(address, pupil.getAddress());
    }

    /**
     * Check the correctly established 'knowledgeLevel'
     */
    @Test
    public void TestGetKnowledgeLevel() {
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);
        assertEquals(KnowledgeLevelEnum.HI, pupil.getKnowledgeLevel());
    }

    /**
     * Check the correctness of the returned string.
     */
    @Test
    public void TestToString() {
        String strDataPupil = "Pupil: [id=null, firstname=null, surname=null, classroom=null, address=null, knowledgeLevel=null]";
        Pupil pupil = new Pupil();
        assertEquals(pupil.toString(), strDataPupil);
    }
}
