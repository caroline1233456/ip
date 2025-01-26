import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Storage {

    public Storage() {
        Path path = Paths.get("data", "parakeet.txt");
        File file = path.toFile();
        if (!file.exists()) {
            System.out.println("the file does not exist");
        }
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }



    }


}
