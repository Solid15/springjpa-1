package be.abis.exercise.controller;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.PersonCreationDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.exception.EnrolException;
import be.abis.exercise.mapper.PersonMapper;
import be.abis.exercise.mapper.SessionMapper;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.Session;
import be.abis.exercise.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrainingApiController {

    @Autowired
    TrainingService trainingService;

    @GetMapping("sessions/query")
    List<SessionDTO> findSessionsForCourse(@RequestParam("title") String courseTitle){
        List<Session> sessionsFound = trainingService.findSessionsForCourse(courseTitle);
        return sessionsFound.stream().map(SessionMapper::toDTO).collect(Collectors.toList()) ;
    }

    @GetMapping("persons/{id}/enrolments")
    public List<EnrolmentDTO> findEnrolments(@PathVariable("id") int personId)
    {
        return trainingService.findEnrolments(personId);
    }

    @PostMapping("sessions/{id}/enrolments")
    public void enrollForSession(@RequestBody PersonCreationDTO personDTO, @PathVariable("id") int sessionId) throws EnrolException {
        Person person = PersonMapper.toPerson(personDTO);
        trainingService.enrolForSession(person,sessionId);
    }

}
