package currency.noteDispenser.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import currency.noteDispenser.bean.NoteDispenserRequest;
import currency.noteDispenser.controller.NoteDispenserController;
import currency.noteDispenser.exception.NoteDispenserException;
import currency.noteDispenser.service.NoteDispenserService;

@RunWith(MockitoJUnitRunner.class)
public class NoteDispenserControllerTest {

	@InjectMocks
	private NoteDispenserController noteController;

	@Mock
	private NoteDispenserService service;

	@Test
	public void getMinimumNumberOfNotesTest() throws NoteDispenserException {
		NoteDispenserRequest requestObject = new NoteDispenserRequest();

		ArrayList<Integer> minCurrencyNotes = new ArrayList<>();
		minCurrencyNotes.add(1);
		minCurrencyNotes.add(3);

		ArrayList<Integer> providedCurrencyNotes = new ArrayList<>();
		providedCurrencyNotes.add(1);
		providedCurrencyNotes.add(5);
		providedCurrencyNotes.add(3);
		requestObject.setNoteList(providedCurrencyNotes);
		requestObject.setAmount(4);

		when(service.calulateMinNumOfNotes(requestObject)).thenReturn(minCurrencyNotes);

		ResponseEntity<?> response = noteController.getMinimumNumberOfNotes(requestObject);
		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	public void validateRequestNullCurrencyTest() {
		NoteDispenserRequest requestObject = new NoteDispenserRequest();
		requestObject.setAmount(4);

		ResponseEntity<?> response = noteController.getMinimumNumberOfNotes(requestObject);
		assertEquals(406, response.getStatusCodeValue());

	}

	@Test
	public void validateRequestNullAmountTest() {
		NoteDispenserRequest requestObject = new NoteDispenserRequest();
		ArrayList<Integer> providedCurrencyNotes = new ArrayList<>();
		providedCurrencyNotes.add(1);
		providedCurrencyNotes.add(5);
		providedCurrencyNotes.add(3);
		requestObject.setNoteList(providedCurrencyNotes);
		ResponseEntity<?> response = noteController.getMinimumNumberOfNotes(requestObject);
		assertEquals(406, response.getStatusCodeValue());

	}
	

}
