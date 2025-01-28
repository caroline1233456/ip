import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ParsedCommand {
    private CommandType commandType;
    //index is for mark, unmark and delete
    private int index;
    //for event description
    private String description;
    //for deadline or event start time
    private  LocalDateTime timeOne;
    //for event end time
    private LocalDateTime timeTwo;

    public ParsedCommand(CommandType commandType, int index, String description, LocalDateTime timeOne, LocalDateTime timeTwo) {
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

    public LocalDateTime getTimeOne() {
        return this.timeOne;
    }

    public LocalDateTime getTimeTwo() {
        return this.timeTwo;
    }

}
