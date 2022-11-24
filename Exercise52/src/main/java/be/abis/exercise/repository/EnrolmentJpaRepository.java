package be.abis.exercise.repository;

import be.abis.exercise.model.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolmentJpaRepository extends JpaRepository<Enrolment,Integer> {

    List<Object[]> findByEnrolleeNQ(@Param("pno") int personId);
}
