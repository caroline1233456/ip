import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Storage {
    private File file;
    private Scanner scanner;
    public Storage() {
        Path path = Paths.get("data", "parakeet.txt");
        this.file = path.toFile();
        if (!file.exists()) {
            System.out.println("the file does not exist");
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
            if (taskType.equals("T")) {
                Task newTask = new Todo(isCompleted, description);
                taskList.add(newTask);
            } else if (taskType.equals("D")) {
                Task newTask = new Deadline(isCompleted, description, timeOne);
                taskList.add(newTask);
            } else if (taskType.equals("E")) {
                Task newTask = new Event(isCompleted, description, timeOne, timeTwo);
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
