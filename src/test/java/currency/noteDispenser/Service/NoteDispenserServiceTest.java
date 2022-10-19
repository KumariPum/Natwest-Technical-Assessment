package currency.noteDispenser.Service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import currency.noteDispenser.bean.NoteDispenserRequest;
import currency.noteDispenser.exception.NoteDispenserException;
import currency.noteDispenser.service.NoteDispenserService;

@RunWith(MockitoJUnitRunner.class)
public class NoteDispenserServiceTest {

	@InjectMocks
	NoteDispenserService service;

	@Test
	public void calulateMinNumOfNotesTest() throws NoteDispenserException {
		NoteDispenserRequest requestObject = new NoteDispenserRequest();

		ArrayList<Integer> minCurrencyNotes = new ArrayList<>();
		minCurrencyNotes.add(1);
		minCurrencyNotes.add(3);
		Collections.sort(minCurrencyNotes, Collections.reverseOrder());

		ArrayList<Integer> providedCurrencyNotes = new ArrayList<>();
		providedCurrencyNotes.add(1);
		providedCurrencyNotes.add(5);
		providedCurrencyNotes.add(3);
		requestObject.setNoteList(providedCurrencyNotes);
		requestObject.setAmount(4);

		List<Integer> response = service.calulateMinNumOfNotes(requestObject);
		assertEquals(minCurrencyNotes, response);
	}

}
