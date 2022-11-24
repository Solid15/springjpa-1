package be.abis.exercise.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("p")
public class PublicSesssion extends Session {

    public PublicSesssion() {
    }

    public PublicSesssion(LocalDate startDate, Person instructor, Company location, Course course) {
        super(startDate, instructor, location, course);
    }
}
