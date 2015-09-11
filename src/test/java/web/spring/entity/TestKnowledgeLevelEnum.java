import org.junit.Test;
import web.spring.entity.KnowledgeLevelEnum;

import static org.junit.Assert.*;

/**
 * Checks the getter values of this enum
 */
public class TestKnowledgeLevelEnum {

    /**
     * Checks the set value in Enum as String @see package.web.spring.entity.KnowledgeLevelEnum.class
     */
    @Test
    public void testGetValue() {
        KnowledgeLevelEnum knowledgeLevelEnum = KnowledgeLevelEnum.HI;
        assertEquals("HI", knowledgeLevelEnum.getValue());
    }

    /**
     * Compares String in Enum @see package.web.spring.entity.KnowledgeLevelEnum.class
     */
    @Test
    public void testParse() {
        KnowledgeLevelEnum knowledgeLevelEnum = KnowledgeLevelEnum.parse("HI");
        assertEquals(knowledgeLevelEnum, KnowledgeLevelEnum.HI);
    }
}