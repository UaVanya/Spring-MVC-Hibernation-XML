package web.spring.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Create entity.
 */
@Entity
@Table(name="pupils")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Pupil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "classroom", nullable = false)
    private String classroom;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "knowledge_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private KnowledgeLevelEnum knowledgeLevel;

    /**
     * @return current id the pupil
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id puil
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return current firstname the pupil
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname pupil
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return current surname the pupil
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname pupil
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return current classroom the pupil
     */
    public String getClassroom() {
        return classroom;
    }

    /**
     * Sets the classroom pupil
     *
     * @param classroom
     */
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    /**
     * @return current address the pupil
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address pupil
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return current knowledgeLevel the pupil
     */
    public KnowledgeLevelEnum getKnowledgeLevel() {
        return knowledgeLevel;
    }

    /**
     * Sets the knowledgeLevel pupil
     *
     * @param knowledgeLevel
     */
    public void setKnowledgeLevel(KnowledgeLevelEnum knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    /**
     * Used to compare pupil in the test class.
     *
     * @return string with data about pupil
     */
    @Override
    public String toString() {
        return "Pupil: [id=" + id + ", firstname=" + firstname
                + ", surname=" + surname + ", classroom=" + classroom
                + ", address=" + address + ", knowledgeLevel=" + knowledgeLevel + "]";
    }
}
