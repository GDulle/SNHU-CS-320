//Gunnar Dulle
//CS 320

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	
	//Variables
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	//Create Unique ID
	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	//Search through task list
	private Task searchForTask(String taskId) throws Exception {
		int i = 0;
		while (i < taskList.size()) {
			if (taskId.equals(taskList.get(i).getTaskId())) {
				return taskList.get(i);
			}
			i++;
		}
		throw new Exception("No task with this ID.");
	}
	
	//Add new task constructors
	public void newTask(String taskName, String taskDesc) {
		Task task = new Task(newUniqueId(), taskName, taskDesc);
		taskList.add(task);
	}
	
	//Deletes task when given task ID
	public void deleteTask(String taskId) throws Exception {
		taskList.remove(searchForTask(taskId));
	}
	
	//Update name in a task
	public void updateTaskName(String taskId, String taskName) throws Exception {
		searchForTask(taskId).setTaskName(taskName);
	}
	
	//Update description in a task
	public void updateTaskDesc(String taskId, String taskDesc) throws Exception {
		searchForTask(taskId).setTaskDesc(taskDesc);
	}
	
	//Get the task list
	protected List<Task> getTaskList() {
		return taskList;
	}
}
