//Gunnar Dulle
//CS 320


import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.util.List;

public class AppointmentService {
	
	//Variables
	private ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	
	//Create Unique ID
	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	//Search through task list
	private Appointment searchForAppt(String apptId) throws Exception {
		int i = 0;
		while (i < apptList.size()) {
			if (apptId.equals(apptList.get(i).getApptId())) {
				return apptList.get(i);
			}
			i++;
		}
		throw new Exception("No appointment with this ID.");
	}
	
	//Add new appointment constructor
	public void newAppt(Date apptDate, String apptDesc) {
		Appointment appt = new Appointment(newUniqueId(), apptDate, apptDesc);
		apptList.add(appt);
	}
	
	//Delete appointment
	public void deleteAppt(String apptId) throws Exception {
		apptList.remove(searchForAppt(apptId));
	}
	
	//Get the appointment list
	protected List<Appointment> getApptList() {
		return apptList;
	}
}