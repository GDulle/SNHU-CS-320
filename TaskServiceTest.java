//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	private String idTest, nameTest, descriptionTest;
	private String longName, longDescription;

	@BeforeEach
	void setUp() throws Exception {
		idTest = "123456789f";
		nameTest = "Here is twenty chars";
		descriptionTest = "The description shall be at most fifty characters.";
		longName = "This is too long to be a task name.";
		longDescription = "his description is too long to be the description for a task.";
	}

	//Test new task variables
	@Test
	void newTaskIdTest() {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
		Assertions.assertNotEquals("EMPTY", service.getTaskList().get(0).getTaskId());
	}
	
	@Test
	void newTaskNameTest() {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		Assertions.assertNotNull(service.getTaskList().get(0).getTaskName());
		Assertions.assertNotEquals("EMPTY", service.getTaskList().get(0).getTaskName());
	}
	
	@Test
	void newTaskDescTest() {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		Assertions.assertNotNull(service.getTaskList().get(0).getTaskDesc());
		Assertions.assertNotEquals("EMPTY", service.getTaskList().get(0).getTaskDesc());
	}
	
	//Test null variables
	@Test
	void newTaskNullNameTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(null, descriptionTest));
	}
	
	@Test
	void newTaskNullDescTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(nameTest, null));
	}
	
	//Test long name and description
	@Test
	void newTaskLongNameTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(longName, descriptionTest));
	}
	
	@Test
	void newTaskLongDescTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(nameTest, longDescription));
	}
	
	//Test deleting Task
	@Test
	void deleteTaskTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		assertEquals(1, service.getTaskList().size());
		service.deleteTask(service.getTaskList().get(0).getTaskId());
		assertEquals(0, service.getTaskList().size());
	}
	
	@Test
	void deleteTaskNotFoundTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		assertEquals(1, service.getTaskList().size());
		assertThrows(Exception.class, () -> service.deleteTask(idTest));
		assertEquals(1, service.getTaskList().size());
	}
	
	//Update task variables
	@Test
	void updateNameTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		service.updateTaskName(service.getTaskList().get(0).getTaskId(), nameTest);
		assertEquals(nameTest, service.getTaskList().get(0).getTaskName());
	}
	
	@Test
	void updateDescTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		service.updateTaskDesc(service.getTaskList().get(0).getTaskId(), descriptionTest);
		assertEquals(descriptionTest, service.getTaskList().get(0).getTaskDesc());		
	}
	
	@Test
	void updateNameTaskNotFoundTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		assertThrows(Exception.class, () -> service.updateTaskName(idTest, nameTest));
	}
	
	@Test
	void updateDescTaskNotFoundTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		assertThrows(Exception.class, () -> service.updateTaskDesc(idTest, descriptionTest));
	}
	
	//Unique ID Test
	@Test
	void uniqueIdTest() {
		TaskService service = new TaskService();
		service.newTask(nameTest, descriptionTest);
		service.newTask(nameTest, descriptionTest);
		service.newTask(nameTest, descriptionTest);
		assertEquals(3, service.getTaskList().size());
		assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(1).getTaskId());
		assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(2).getTaskId());
		assertNotEquals(service.getTaskList().get(1).getTaskId(), service.getTaskList().get(2).getTaskId());
	}
}
