package currency.noteDispenser.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NoteDispenserRequest {

	private List<Integer> noteList;
	private int amount;

	public NoteDispenserRequest() {
		super();
	}

	public NoteDispenserRequest(List<Integer> noteList, int amount) {
		super();
		this.noteList = noteList;
		this.amount = amount;
	}

	public List<Integer> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Integer> noteList) {
		this.noteList = noteList;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
