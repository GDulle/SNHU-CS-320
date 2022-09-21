//Gunnar Dulle
//CS 320

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	private String idTest, nameTest, descriptionTest;
	private String longId, longName, longDescription;

	@BeforeEach
	void setUp() throws Exception {
		idTest = "123456789f";
		nameTest = "Here is twenty chars";
		descriptionTest = "The description shall be at most fifty characters.";
		longId = "ab123456789";
		longName = "This is too long to be a task name.";
		longDescription = "This description is too long to be the description for a task.";
	}

	//Constructor test	
	@Test
	void taskIdNameAndDescConstructorTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		assertAll(
				"constructor three",
				() -> assertNotNull(idTest, task.getTaskId()),
				() -> assertNotNull(nameTest, task.getTaskName()),
				() -> assertNotNull(descriptionTest, task.getTaskDesc()));
	}
	
	//Getter tests
	@Test
	void getTaskIdTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertEquals(idTest, task.getTaskId());
	}
	
	@Test
	void getTaskNameTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertEquals(nameTest, task.getTaskName());
	}
	
	@Test
	void getTaskDescTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertEquals(descriptionTest, task.getTaskDesc());
	}
	
	//Setter tests
	@Test
	void setTaskNameTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		task.setTaskName(nameTest);
		Assertions.assertEquals(nameTest, task.getTaskName());
	}
	
	@Test
	void setTaskDescTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		task.setTaskDesc(descriptionTest);
		Assertions.assertEquals(descriptionTest, task.getTaskDesc());
	}
	
	//Setter null tests
	@Test
	void nullTaskIdTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null, nameTest, descriptionTest));
	}
	
	@Test
	void nullTaskNameTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
	}
	
	@Test
	void nullTaskDescTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(null));
	}
	
	//Setter too long tests
	@Test
	void longTaskIdTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskId(longId));
	}
	
	@Test
	void longTaskNameTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskName(longName));
	}
	
	@Test
	void longTaskDescTest() {
		Task task = new Task(idTest, nameTest, descriptionTest);
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(longDescription));
	}
}
