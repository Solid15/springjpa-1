package be.abis.exercise;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.model.Session;
import be.abis.exercise.repository.SessionJpaRepository;
import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TestTrainingService {

	@Autowired
	TrainingService trainingService;
	@Autowired
	SessionJpaRepository sessionRepository;

	@Test
	public void thereIsOneNonCancelledSessionForDB2BAS(){
		List<Session> sessions = trainingService.findSessionsForCourse("DB2BAS");
		assertEquals(1,sessions.size());
	}

	@Test
	public void thereAre3NonCancelledEnrolmentForPerson25(){
		List<EnrolmentDTO> enrolments = trainingService.findEnrolments(25);
		assertEquals(3,enrolments.size());
	}

	@Test
	@Transactional
	public void cancelSession1() {
		trainingService.cancelSession(1);
		assertTrue(sessionRepository.findById(1).isCancelled());
	}

	
	

}
