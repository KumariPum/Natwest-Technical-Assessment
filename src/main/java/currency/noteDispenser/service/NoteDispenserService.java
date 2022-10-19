package currency.noteDispenser.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import currency.noteDispenser.bean.NoteDispenserRequest;
import currency.noteDispenser.exception.NoteDispenserException;

@Service
public class NoteDispenserService {

	/**
	 * This method calculates the minimum number of notes for given list of notes and amount
	 * 
	 * @param NoteDispenserRequest object
	 * @throws NoteDispenserException
	 * @return List of minimum number of notes
	 */
	public List<Integer> calulateMinNumOfNotes(NoteDispenserRequest requestObj) throws NoteDispenserException {
		List<Integer> givenList = requestObj.getNoteList();
		Collections.sort(givenList, Collections.reverseOrder());
		List<Integer> filteredList = processRequest(givenList, requestObj);
		return filteredList;

	}

	private List<Integer> processRequest(List<Integer> givenList, NoteDispenserRequest requestObj)
			throws NoteDispenserException {
		List<Integer> minNotesNeeded = new ArrayList<Integer>();
		int givenAmount = requestObj.getAmount();

		try {
			for (int notes : givenList) {
				if (givenAmount >= notes) {
					minNotesNeeded.add(notes);
					givenAmount = givenAmount - notes;
				}
			}
			int sumOfMinNotes = minNotesNeeded.stream().reduce(0, (x, y) -> x + y);
			if (sumOfMinNotes == requestObj.getAmount()) {
				return minNotesNeeded;
			} else {
				minNotesNeeded.clear();
				return minNotesNeeded;
			}
		} catch (Exception e) {
			throw new NoteDispenserException("Error occurred while calculating minimum number of notes");
		}
	}

}
