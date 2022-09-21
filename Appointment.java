//Gunnar Dulle
//CS 320

import java.util.Date;
 
public class Appointment {
	
	//Variables
	private static final int APPT_ID_LENGTH = 10;
	private static final int APPT_DESC_LENGTH = 50;
	private String apptId;
	private Date apptDate;
	private String apptDesc;
	
	//Constructor
	Appointment(String apptId, Date apptDate, String apptDesc) {
		setApptId(apptId);
		setApptDate(apptDate);
		setApptDesc(apptDesc);
	}

	//Getters
	protected String getApptId() {
		return apptId;
	}

	protected Date getApptDate() {
		return apptDate;
	}

	protected String getApptDesc() {
		return apptDesc;
	}

	//Setters
	protected void setApptId(String apptId) {
		if (apptId == null) {
			throw new IllegalArgumentException("Appointment ID cannot be empty.");
		}
		else if (apptId.length() > APPT_ID_LENGTH) {
			throw new IllegalArgumentException("Appointment ID cannot be longer than " + APPT_ID_LENGTH + " characters.");
		}
		else {
			this.apptId = apptId;
		}
	}

	protected void setApptDate(Date apptDate) {
		if (apptDate == null) {
			throw new IllegalArgumentException("Appointment date cannot be empty.");
		}
		else if (apptDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment date cannot be in the past.");
		}
		else {
			this.apptDate = apptDate;
		}
	}

	protected void setApptDesc(String apptDesc) {
		if (apptDesc == null) {
			throw new IllegalArgumentException("Apointment description cannot be empty.");
		}
		else if (apptDesc.length() > APPT_DESC_LENGTH) {
			throw new IllegalArgumentException("Appointment description cannot be longer than " + APPT_DESC_LENGTH + " characters.");
		}
		else {
			this.apptDesc = apptDesc;
		}
	}
}
