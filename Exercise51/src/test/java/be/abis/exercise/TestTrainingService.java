package be.abis.exercise;

import be.abis.exercise.dto.EnrolmentDTO;
import be.abis.exercise.dto.SessionDTO;
import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TestTrainingService {

	@Autowired
	TrainingService trainingService;

	@Test
	public void thereIsOneNonCancelledSessionForDB2BAS(){
		List<SessionDTO> sessions = trainingService.findSessionsForCourse("DB2BAS");
		assertEquals(1,sessions.size());
	}

	@Test
	public void thereAre3NonCancelledEnrolmentForPerson25(){
		List<EnrolmentDTO> enrolments = trainingService.findEnrolments(25);
		assertEquals(3,enrolments.size());
	}

	
	

}
