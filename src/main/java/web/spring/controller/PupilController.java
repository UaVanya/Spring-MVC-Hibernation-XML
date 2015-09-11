package web.spring.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import web.spring.entity.Pupil;
import web.spring.entity.PupilUtils;
import web.spring.service.PupilService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Performs in methods Rest queries.
 */
@RestController
@RequestMapping(value = "/")
public class PupilController {
    private final String messagesNoPupils = "list.pupils.empty";
    private final String messagesNoPupilsById = "pupil.by.id";
    private final String messagesNoPupilsByKnowledgeLevel = "pupil.by.knowledgeLevel";

    private ObjectMapper mapper = new ObjectMapper();

//    @Autowired
//    private MessageSource messageSource;

    @Autowired
    private PupilService pupilService;

    /**
     * Get all pupils list from database.
     *
     * @return string data of about pupils
     */
    @RequestMapping(value = "/pupilsList", method = RequestMethod.GET)
    public @ResponseBody String getAllPupils() throws IOException {
        List<Pupil> pupils = pupilService.getAllPupils();
        if (!pupils.isEmpty()) {
            return mapper.writeValueAsString(pupils);
        }
//        return messageSource.getMessage("list.pupils.empty", null, Locale.ENGLISH);
        return messagesNoPupils;
    }

    /**
     * Get pupil by id.
     *
     * @param id
     * @return string data of pupil
     */
    @RequestMapping(value = "/pupil", method = RequestMethod.GET)
    public @ResponseBody String getPupilById(@RequestParam Long id) throws IOException {
        Pupil pupil = pupilService.getPupil(id);
        if (pupil != null){
            return mapper.writeValueAsString(pupil);
        }
//        return messageSource.getMessage("pupil.by.id", null, Locale.ENGLISH);
        return messagesNoPupilsById;
    }

    /**
     * Get pupil by knowledge level.
     *
     * @param knowledgeLevel
     * @return string data of pupil
     */
    @RequestMapping(value = "/pupils", method = RequestMethod.GET)
    public @ResponseBody String getPupilByKnowledgeLevel(@RequestParam String knowledgeLevel) throws IOException {
        List<Pupil> pupils = pupilService.getPupil(knowledgeLevel);
        if (!pupils.isEmpty()) {
            return mapper.writeValueAsString(pupils);
        }
//        return messageSource.getMessage("pupil.by.knowledgeLevel", null, Locale.ENGLISH);
        return messagesNoPupilsByKnowledgeLevel;
    }

    /**
     * Change an pupil.
     *
     * @param pupilJson
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    @ResponseBody
    public void changePupil(@RequestBody String pupilJson) throws IOException {
        Pupil pupil = PupilUtils.convertJsonToPupilObject(pupilJson, Pupil.class);
        pupilService.changePupil(pupil);
    }

    /**
     * Delete an pupil
     *
     * @param id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deletePupil(@RequestParam(value="id") Long id){
        pupilService.deletePupil(id);
    }

    /**
     * Save pupil in DB.
     */
    @RequestMapping(value = "/save",  produces = "application/json", method = RequestMethod.POST)
    public void addPupil(@RequestBody String pupilJson) throws IOException {
        Pupil pupil = PupilUtils.convertJsonToPupilObject(pupilJson, Pupil.class);
        pupilService.addPupil(pupil);
    }
}
