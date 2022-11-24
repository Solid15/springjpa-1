package be.abis.exercise.controller;

import be.abis.exercise.dto.PersonCreationDTO;
import be.abis.exercise.dto.PersonDTO;
import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.mapper.PersonMapper;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonApiController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonService ps;

    @GetMapping("")
    public List<PersonDTO> getAllPersons(){

        List<PersonDTO> personDTOs = new ArrayList<>();
        List<Person> persons = ps.getAllPersons();
        for (Person p : persons){
            personDTOs.add(PersonMapper.toDTO(p));
        }
        return personDTOs;


    }

    @GetMapping("{id}")
    public PersonDTO findPerson(@PathVariable("id") int id) throws PersonNotFoundException {
        return PersonMapper.toDTO(ps.findPerson(id));
    }

    @PostMapping("/login")
    public PersonDTO findPersonByMailAndPwd(@RequestBody Login login) throws PersonNotFoundException {
        return PersonMapper.toDTO(ps.findPerson(login.getEmail(), login.getPassword()));
    }

    @GetMapping(path="/compquery")
    public List<PersonDTO> findPersonsByCompanyName(@RequestParam("compname") String compName) {

        List<PersonDTO> personDTOs = new ArrayList<>();
        List<Person> persons = ps.findPersonsByCompanyName(compName);
        for (Person p : persons){
            personDTOs.add(PersonMapper.toDTO(p));
        }
        return personDTOs;

    }

    @PostMapping(path="")
    public PersonDTO addPerson(@RequestBody PersonCreationDTO personDTO) throws PersonAlreadyExistsException {
        Person p = PersonMapper.toPerson(personDTO);
        Person addedPerson = ps.addPerson(p);
         return PersonMapper.toDTO(addedPerson);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
        ps.deletePerson(id);
    }

    @PutMapping("{id}")
    public PersonDTO changePassword(@PathVariable("id") int id, @RequestBody PersonCreationDTO personDTO) throws PersonNotFoundException {
        //System.out.println("changing password to newpswd= " + personDTO.getPassword());
        Person person = PersonMapper.toPerson(personDTO);
        Person changedPerson = ps.changePassword(person, person.getPassword());
        return PersonMapper.toDTO(changedPerson);
    }





}
