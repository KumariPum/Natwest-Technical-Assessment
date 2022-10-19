package currency.noteDispenser.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import currency.noteDispenser.bean.NoteDispenserRequest;
import currency.noteDispenser.bean.NoteDispenserResponse;
import currency.noteDispenser.exception.ErrorDetails;
import currency.noteDispenser.service.NoteDispenserService;

@RestController
public class NoteDispenserController {

	NoteDispenserResponse responseObject = null;

	@Autowired
	NoteDispenserService service;

	/**
	 * This method receives the request and pass on to service after validation of request
	 * 
	 * @param NoteDispenserRequest object
	 * @return NoteDispenserResponse object
	 */
	@GetMapping("/getNotes")
	public ResponseEntity<?> getMinimumNumberOfNotes(@RequestBody NoteDispenserRequest requestObj) {

		ResponseEntity<?> validateReq = validateRequest(requestObj);
		if (Objects.nonNull(validateReq) && validateReq.getStatusCodeValue() == 406) {
			return validateReq;
		}
		try {
			List<Integer> calculatedMinNumOfNotes = service.calulateMinNumOfNotes(requestObj);
			responseObject = new NoteDispenserResponse();
			responseObject.setMinimumNumOfNotes(calculatedMinNumOfNotes);
			return new ResponseEntity<NoteDispenserResponse>(responseObject, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	private ResponseEntity<?> validateRequest(@RequestBody NoteDispenserRequest requestObj) {
		ErrorDetails details = null;
		ResponseEntity<ErrorDetails> responseEntity = null;
		if (Objects.isNull(requestObj.getNoteList())) {
			details = new ErrorDetails(LocalDateTime.now(), "Please provide valid Integer Currency Notes");

			responseEntity = new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_ACCEPTABLE);
		}

		if (requestObj.getAmount() == 0) {
			details = new ErrorDetails(LocalDateTime.now(), "Please provide non " + "zero Amount");

			responseEntity = new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_ACCEPTABLE);
		}

		return responseEntity;
	}

}
