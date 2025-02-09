package parakeet;

import parakeet.task.Deadline;
import parakeet.task.Event;
import parakeet.task.Task;
import parakeet.task.Todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The {@code Storage} class is responsible for reading and writing task data
 * to a file. The data is stored in a text file at a specified location.
 * The class handles creating necessary directories and files, reading data
 * from the file, and writing task data back to the file.
 */
public class Storage {
    private Path path;
    private File file;
    private Scanner scanner;
    public Storage(Path path) {
        this.path = Paths.get("data", "parakeet.txt");
        this.file = path.toFile();
        try {
            Files.createDirectories(this.path.getParent());
        } catch (IOException e) {
            System.out.println("directory creation unsuccessful");
        }

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("File could not be created");
                }
            } catch (IOException e) {
                System.out.println("Failed to create file: " + e.getMessage());
            }
        }

        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }

    /**
     * Reads the task data from the file and adds the tasks to the provided
     * {@code TaskList}. The file format should be:
     * <pre>
     * type|completed|description|start date|end date
     * </pre>
     * where type is one of the following:
     * <ul>
     *     <li>T for Todo</li>
     *     <li>D for Deadline</li>
     *     <li>E for Event</li>
     * </ul>
     *
     * @param taskList the list of tasks to which the data will be added.
     */
    public void readFromFile(TaskList taskList) {
        while(this.scanner.hasNextLine()) {
            String line = scanner.nextLine();

            //all the task regardless of type follows format: type|complete|description|start date|endDate
            String[] components = line.split("\\|");
            String taskType = components[0].trim();
            boolean isCompleted = components[1].trim().equals("1");//completed is 1 and not completed is 0
            String description = components[2].trim();
            String timeOne = components[3].trim();
            String timeTwo = components[4].trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");


            if (taskType.equals("T")) {
                Task newTask = new Todo(isCompleted, description);
                taskList.add(newTask);
            } else if (taskType.equals("D")) {
                LocalDateTime timeOneDate = LocalDateTime.parse(timeOne, formatter);
                Task newTask = new Deadline(isCompleted, description, timeOneDate);
                taskList.add(newTask);
            } else if (taskType.equals("E")) {
                LocalDateTime timeOneDate = LocalDateTime.parse(timeOne, formatter);
                LocalDateTime timeTwoDate = LocalDateTime.parse(timeTwo, formatter);
                Task newTask = new Event(isCompleted, description, timeOneDate, timeTwoDate);
                taskList.add(newTask);
            } else {
                System.out.println("Error, no event type");
            }
        }
    }

    /**
     * Writes the tasks in the provided {@code TaskList} to the file in a format
     * that can be read later. The task list is converted to a file format where
     * each task is represented by a line in the following format:
     * <pre>
     * type|completed|description|start date|end date
     * </pre>
     *
     * @param taskList the list of tasks to be written to the file.
     */
    public void writeToFile(TaskList taskList) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, false));

            // Write the content to the file
            writer.write(taskList.convertToFileFormat());
            // Flush and close the writer to ensure data is written
            writer.flush(); // This ensures the data is actually written to the file
            writer.close(); // Close
        } catch (IOException e) {
            System.out.println("Error: writing tasklist to file");
        }


    }


}
