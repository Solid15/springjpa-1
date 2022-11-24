package be.abis.exercise.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = PersonNotFoundException.class)
	protected ResponseEntity<? extends Object> handlePersonNotFound(PersonNotFoundException pnfe,
																		 WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return this.handlePersonException(status,pnfe);

	}

	@ExceptionHandler(value = PersonAlreadyExistsException.class)
	protected ResponseEntity<? extends Object> handlePersonAlreadyExists(PersonAlreadyExistsException paee,
			WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		return this.handlePersonException(status,paee);
	}

	@ExceptionHandler(value = PersonCanNotBeDeletedException.class)
	protected ResponseEntity<? extends Object> handlePersonCannotBeDeleted(PersonCanNotBeDeletedException pcde,
			WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		return this.handlePersonException(status,pcde);
	}

	private ResponseEntity<ApiError> handlePersonException(HttpStatus status, Exception e){
		ApiError err = new ApiError("person exception", status.value(), e.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
		return new ResponseEntity<ApiError>(err, responseHeaders, status);
    }

	@ExceptionHandler(value = EnrolException.class)
	protected ResponseEntity<? extends Object> handlePersonAlreadyExists(EnrolException ee,
																		 WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ApiError err = new ApiError("enrolment exception", status.value(), ee.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
		return new ResponseEntity<ApiError>(err, responseHeaders, status);
	}



}
