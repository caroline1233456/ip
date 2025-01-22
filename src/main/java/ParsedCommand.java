public class ParsedCommand {
    private CommandType commandType;
    //index is for mark, unmark and delete
    private int index;
    //for event description
    private String description;
    //for deadline or event start time
    private String timeOne;
    //for event end time
    private String timeTwo;

    public ParsedCommand(CommandType commandType, int index, String description, String timeOne, String timeTwo) {
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

    public String getTimeOne() {
        return this.timeOne;
    }

    public String getTimeTwo() {
        return this.timeTwo;
    }

}
