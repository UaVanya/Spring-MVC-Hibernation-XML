import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import web.spring.entity.KnowledgeLevelEnum;
import web.spring.entity.Pupil;
import web.spring.entity.PupilUtils;

import java.io.IOException;

/**
 * Checks the methods of this class
 */
public class TestPupilUtils {

    /**
     * Checks for correct operation of method @see package.web.spring.entity.PupilUtils#convertJsonToPupilObject(String json, Class<Pupil> aClass)
     *
     * @throws IOException
     */
    @Test
    public void testConvertJsonToPupilObject() throws IOException {
        Pupil pupil = new Pupil();
        pupil.setFirstname("Test");
        pupil.setSurname("GetPupil");
        pupil.setClassroom("1");
        pupil.setAddress("Test");
        pupil.setKnowledgeLevel(KnowledgeLevelEnum.HI);

        ObjectMapper mapper = new ObjectMapper();
        String pupilJson = mapper.writeValueAsString(pupil);
        Pupil pupilUtil = PupilUtils.convertJsonToPupilObject(pupilJson, Pupil.class);
        assertThat(pupil.toString(), is(pupilUtil.toString()));
    }

    /**
     * Checks for correctly responds to crash
     *
     * @throws IOException
     */
    @Test(expected = JsonParseException.class)
    public void testExceptionConvertJsonToPupilObject() throws IOException {
        String simpleStr = "Simple string";
        Pupil pupilUtil = PupilUtils.convertJsonToPupilObject(simpleStr, Pupil.class);
    }
}
