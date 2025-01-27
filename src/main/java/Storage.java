import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Storage {
    private File file;
    private Scanner scanner;
    public Storage() {
        Path path = Paths.get("data", "parakeet.txt");
        this.file = path.toFile();
        try {
            Files.createDirectories(path.getParent());
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

    public void readFromFile(TaskList taskList) {
        while(this.scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] components = line.split("\\|");
            String taskType = components[0].trim();
            boolean isCompleted = components[1].trim().equals("1");//completed is 1 and not completed is 0
            String description = components[2].trim();
            String timeOne = components[3].trim();
            String timeTwo = components[4].trim();//all the task regardless of type follows format: type|complete|description|start date|endDate

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");


            if (taskType.equals("T")) {
                Task newTask = new Todo(isCompleted, description);
                taskList.add(newTask);
            } else if (taskType.equals("D")) {
                LocalDate timeOneDate = LocalDate.parse(timeOne, formatter);
                Task newTask = new Deadline(isCompleted, description, timeOneDate);
                taskList.add(newTask);
            } else if (taskType.equals("E")) {
                LocalDate timeOneDate = LocalDate.parse(timeOne, formatter);
                LocalDate timeTwoDate = LocalDate.parse(timeTwo, formatter);
                Task newTask = new Event(isCompleted, description, timeOneDate, timeTwoDate);
                taskList.add(newTask);
            } else {
                System.out.println("Error, no event type");
            }
        }
    }

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
