package be.abis.exercise.mapper;

import be.abis.exercise.dto.PersonCreationDTO;
import be.abis.exercise.dto.PersonDTO;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        Company c = person.getCompany();
        String companyName = null;
        String companyTown = null;
        if (c != null) {
            companyName = c.getName().trim();
            companyTown = c.getAddress().getTown().trim();
        }
        return new PersonDTO(person.getFirstName(),
                person.getLastName().trim(),
                person.getEmailAddress(),
                person.getBirthDate(),
                companyName,
                companyTown);
    }

    public static Person toPerson(PersonCreationDTO personDTO) {
        Person p = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getBirthDate(), personDTO.getEmailAddress(), personDTO.getPassword(), personDTO.getLanguage());
        if (personDTO.getCompanyName()!=null && !personDTO.getCompanyName().trim().isEmpty()) {
            Address a = new Address(personDTO.getStreet(), personDTO.getNr(), personDTO.getZipcode(), personDTO.getTown(), personDTO.getCountryCode());
            Company c = new Company(personDTO.getCompanyName(), personDTO.getTelephoneNumber(), personDTO.getVatNr(), a);
            p.setCompany(c);
        }
        return p;
    }


}
