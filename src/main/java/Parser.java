import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public ArrayList<Task> list;
    public Parser() {
        this.list = new ArrayList<>();

    }

    public ParsedCommand parse(String command) throws InvalidInputError {
        if (command.equalsIgnoreCase("bye")) {
            ParsedCommand parsedCommand =
                    new ParsedCommand(CommandType.BYE,0,null,null,null);
            return parsedCommand;
        }else if (command.equalsIgnoreCase("list")) {
            ParsedCommand parsedCommand =
                    new ParsedCommand(CommandType.LIST,0,null,null,null);
            return parsedCommand;
        } else if (command.startsWith("mark")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            ParsedCommand parsedCommand =
                    new ParsedCommand(CommandType.MARK,taskIndex,null,null,null);
            return parsedCommand;
        } else if (command.startsWith("unmark")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            ParsedCommand parsedCommand =
                    new ParsedCommand(CommandType.UNMARK,taskIndex,null,null,null);
            return parsedCommand;
        } else if (command.startsWith("delete")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            ParsedCommand parsedCommand =
                    new ParsedCommand(CommandType.DELETE,taskIndex,null,null,null);
            return parsedCommand;

        } else {
            //event
            if (command.startsWith(("todo"))) {
                String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);

                if(splitCom.length ==0 || String.join(" ",splitCom).trim().isEmpty()){
                    throw new InvalidInputError("Sorry, the description of todo can not be empty");
                }
                String result = String.join(" ", splitCom);
                return new ParsedCommand(CommandType.TODO,0,result,null,null);

            }else if (command.startsWith(("deadline"))) {

                //split the command , remove the word deadline
                String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);
                String commandOne= String.join(" ", splitCom);

                //check for invalid input like "deadline " or "deadline"
                if(splitCom.length ==0 || String.join(" ", splitCom).trim().isEmpty()){
                    throw new InvalidInputError("Sorry, the description of deadline can not be empty");

                }

                String deadlineRegex = "/by\\s+(.*)";
                String eventDescriptionRegex = "^(.*?)(?=\\s*/by|$)";

                Pattern patternDescription = Pattern.compile(eventDescriptionRegex);
                Pattern pattern = Pattern.compile(deadlineRegex);

                Matcher matcherDescription = patternDescription.matcher(commandOne);
                Matcher matcher = pattern.matcher(commandOne);




                if (matcher.find() && matcherDescription.find()) {
                    String deadlineTime = matcher.group(1).trim();
                    String description = matcherDescription.group(1).trim();

                    //check for input like "deadline /by Sunday"
                    if(description.isEmpty()) {
                        throw new InvalidInputError("Sorry, the description can not be empty");

                    }
                    return new ParsedCommand(CommandType.DEADLINE,0,description,deadlineTime,null);

                } else {
                    //check for case where deadline are not provided
                    throw new InvalidInputError("Sorry, this is invalid input, you need to provide description and deadline");
                }
            } else if (command.startsWith(("event"))) {
                String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);
                String commandOne = String.join(" ", splitCom);

                //check for case like "event" or "event "
                if(splitCom.length ==0 || String.join(" ", splitCom).trim().isEmpty()) {
                    throw new InvalidInputError("Sorry, the description of event can not be empty");
                }

                String eventDescriptionRegex = "^(.*?)(?=\\s*/from|$)";
                String fromRegex = "/from\\s+(.*?)(?=\\s*/to|$)";
                String toRegex = "/to\\s+(.*)";

                Pattern patternDescription = Pattern.compile(eventDescriptionRegex);
                Pattern patternF = Pattern.compile(fromRegex);
                Pattern patternT = Pattern.compile(toRegex);

                Matcher matcherDescription = patternDescription.matcher(commandOne);
                Matcher matcherFrom = patternF.matcher(commandOne);
                Matcher matcherTo = patternT.matcher(commandOne);



                if (matcherFrom.find() && matcherTo.find() && matcherDescription.find()) {
                    String from = matcherFrom.group(1).trim();
                    String to = matcherTo.group(1).trim();
                    String description = matcherDescription.group(1).trim();

                    if (description.isEmpty()) {
                        throw new InvalidInputError("Sorry, the description can not be empty");
                    }
                    return new ParsedCommand(CommandType.EVENT,0,description,from,to);
                } else {
                    //check if time and description are given
                    throw new InvalidInputError("Sorry, this is invalid input, you need to provide description and exact time");

                }
            } else {
                throw new InvalidInputError("Sorry, I don't understand what you mean");

            }

        }
    }
}
