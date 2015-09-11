package web.spring.entity;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class PupilUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Conversion from string to object Pupil
     *
     * @param json
     * @param aClass
     * @return
     * @throws IOException
     */
    public static Pupil convertJsonToPupilObject(String json, Class<Pupil> aClass) throws IOException {
        Pupil pupil = mapper.readValue(json, aClass);
        return pupil;
    }
}
