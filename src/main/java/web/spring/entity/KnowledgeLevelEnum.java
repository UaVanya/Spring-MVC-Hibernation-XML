package web.spring.entity;

public enum KnowledgeLevelEnum {

    LOW("LOW"),
    MIDDLE("MIDDLE"),
    HI("HI");

    private String value;

    /**
     * Sets the value of this Enum as String.
     *
     * @param value
     */
    KnowledgeLevelEnum(String value) {
        this.value = value;
    }

    /**
     * @return value of this Enum as String
     */
    public String getValue() {
        return value;
    }

    /**
     * Add support to compare Strings with the parse String method.
     * Replicated functionality of the parse of the java.lang.String.class
     *
     * @param value String to test.
     * @return the value class KnowledgeLevelEnum if equal otherwise null.
     */
    public static KnowledgeLevelEnum parse(String value) {
        for (KnowledgeLevelEnum knowledgeLevel : values()) {
            if (knowledgeLevel.getValue().equalsIgnoreCase(value)) {
                return knowledgeLevel;
            }
        }
        return null;
    }
}
