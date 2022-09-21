//Gunnar Dulle
//CS 320

public class Task {
	
	//Variables
	private static final int TASK_ID_LENGTH = 10;
	private static final int TASK_NAME_LENGTH = 20;
	private static final int TASK_DESC_LENGTH = 50;
	private String taskId;
	private String taskName;
	private String taskDesc;
	
	//Constructor
	Task(String taskId, String taskName, String taskDesc) {
		setTaskId(taskId);
		setTaskName(taskName);
		setTaskDesc(taskDesc);
	}

	//Getters
	protected String getTaskId() {
		return taskId;
	}

	protected String getTaskName() {
		return taskName;
	}

	protected String getTaskDesc() {
		return taskDesc;
	}

	//Setters
	protected void setTaskId(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("Task ID cannot be empty.");
		}
		else if (taskId.length() > TASK_ID_LENGTH) {
			throw new IllegalArgumentException("Task ID cannot be longer than " + TASK_ID_LENGTH + " characters.");
		}
		else {
			this.taskId = taskId;
		}
	}

	protected void setTaskName(String taskName) {
		if (taskName == null) {
			throw new IllegalArgumentException("Task Name cannot be empty.");
		}
		else if (taskName.length() > TASK_NAME_LENGTH) {
			throw new IllegalArgumentException("Task ID cannot be longer than " + TASK_NAME_LENGTH + " characters.");
		}
		else {
			this.taskName = taskName;
		}
	}

	protected void setTaskDesc(String taskDesc) {
		if (taskDesc == null) {
			throw new IllegalArgumentException("Task Description cannot be empty.");
		}
		else if (taskDesc.length() > TASK_DESC_LENGTH) {
			throw new IllegalArgumentException("Task Description cannot be longer than " + TASK_DESC_LENGTH + " characters.");
		}
		else {
			this.taskDesc = taskDesc;
		}
	}
}
