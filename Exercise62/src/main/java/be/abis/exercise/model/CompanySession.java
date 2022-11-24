package be.abis.exercise.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("c")
public class CompanySession extends Session {

    public CompanySession() {
    }

    public CompanySession(LocalDate startDate, Person instructor, Company location, Course course) {
        super(startDate, instructor, location, course);
    }
}
