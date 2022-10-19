package currency.noteDispenser.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NoteDispenserResponse {

	private List<Integer> minimumNumOfNotes;

	public NoteDispenserResponse() {
		super();
	}

	public NoteDispenserResponse(List<Integer> minimumNumOfNotes) {
		super();
		this.minimumNumOfNotes = minimumNumOfNotes;
	}

	public List<Integer> getMinimumNumOfNotes() {
		return minimumNumOfNotes;
	}

	public void setMinimumNumOfNotes(List<Integer> minimumNumOfNotes) {
		this.minimumNumOfNotes = minimumNumOfNotes;
	}

}
