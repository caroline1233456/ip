import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ParsedCommand {
    private CommandType commandType;
    //index is for mark, unmark and delete
    private int index;
    //for event description
    private String description;
    //for deadline or event start time
    private  LocalDate timeOne;
    //for event end time
    private LocalDate timeTwo;

    public ParsedCommand(CommandType commandType, int index, String description, LocalDate timeOne, LocalDate timeTwo) {
        this.commandType = commandType;
        this.index = index;
        this.description = description;
        this.timeOne = timeOne;
        this.timeTwo = timeTwo;
    }

    public CommandType getCommandType() {
        return this.commandType;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getTimeOne() {
        return this.timeOne;
    }

    public LocalDate getTimeTwo() {
        return this.timeTwo;
    }

}
