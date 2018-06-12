package Model;

public class GuestBookEntry {

	Integer ID;
	String Name;
	String Message;
	
	public GuestBookEntry() {
		
	}

	public GuestBookEntry(
			Integer iD,
			String name,
			String message) {
		super();
		ID = iD;
		Name = name;
		Message = message;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(
			Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(
			String name) {
		Name = name;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(
			String message) {
		Message = message;
	}

	
}
