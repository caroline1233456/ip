package parakeet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parakeet.task.Deadline;
import parakeet.task.Event;
import parakeet.task.Task;
import parakeet.task.Todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageTest {
    private TaskList taskList;
    private Storage storage;
    private Path tempFilePath;
    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFilePath = Files.createTempFile("parakeet_test", ".txt");
        storage = new Storage(tempFilePath);
        taskList = new TaskList();
    }
    @Test
    void writeToFile_taskSet_writeCorrectFormat() throws IOException {
        // Arrange: Add tasks
        Task todo = new Todo(false, "Read book");
        Task deadline = new Deadline(true, "Submit assignment"
                , LocalDateTime.of(2024, 1, 30, 23, 59));
        Task event = new Event(false, "Team meeting",
                LocalDateTime.of(2024, 2, 1, 14, 0),
                LocalDateTime.of(2024, 2, 1, 16, 0));
        try {
            taskList.add(todo);
            taskList.add(deadline);
            taskList.add(event);
        } catch (DuplicateTaskError e) {
            assert false;
        }


        storage.writeToFile(taskList);


        String expectedContent = "T | 0 | Read book | 0 | 0 \n" +
                "D | 1 | Submit assignment | Jan 30 2024 23:59 | 0 \n" +
                "E | 0 | Team meeting | Feb 01 2024 14:00 | Feb 01 2024 16:00\n";

        String fileContent = Files.readString(tempFilePath);
        assertEquals(expectedContent, fileContent, "File content should match the expected format.");
    }
    @Test
    void writeToFile_EmptyTaskList_ShouldWriteNothing() throws IOException {
        // Act: Write an empty task list
        storage.writeToFile(taskList);

        // Assert: File should be empty
        String fileContent = Files.readString(tempFilePath);
        assertTrue(fileContent.isEmpty(), "File should be empty when no tasks are written.");
    }

    }
