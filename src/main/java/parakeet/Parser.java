package parakeet;

import parakeet.command.*;
import parakeet.task.Task;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Parser class is responsible for parsing user input commands and creating
 * appropriate command objects to interact with the system.
 * It can handle various commands such as "bye", "list", "mark", "unmark",
 * "delete", as well as commands related to adding tasks, such as "todo", "event",
 * and "deadline". It also validates the correctness of the input.
 *
 * <p>It parses input for task descriptions, dates, and times, and ensures that
 * all necessary information is provided in the correct format.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-01-29
 */
public class Parser {
    public ArrayList<Task> list;
    public Parser() {
        this.list = new ArrayList<>();

    }

    /**
     * Parses a given command string and returns the appropriate Command object.
     * It handles various command types, such as:
     * - "bye" for exiting the application
     * - "list" for listing tasks
     * - "mark" for marking a task as done
     * - "unmark" for unmarking a task
     * - "delete" for deleting a task
     * - "todo", "deadline", and "event" for adding tasks
     *
     * @param command The input command string to be parsed.
     * @return The Command object corresponding to the parsed input.
     * @throws InvalidInputError If the command is invalid or in an incorrect format.
     */
    public Command parse(String command) throws InvalidInputError {
        if (command.equalsIgnoreCase("bye")) {
            return new ExitCommand();
        }else if (command.equalsIgnoreCase("list")) {

            return new ListCommand();
        } else if (command.startsWith("mark")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            return new MarkCommand(taskIndex);
        } else if (command.startsWith("unmark")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            return new UnmarkCommand(taskIndex);
        } else if (command.startsWith("delete")) {
            int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
            return new DeleteCommand(taskIndex);

        } else {
            //event, parakeet.command.AddCommand part
            if (command.startsWith(("todo"))) {
                String[] splitCom = Arrays.copyOfRange(command.split(" "),
                        1, command.split(" ").length);

                if(splitCom.length == 0 || String.join(" ", splitCom).trim().isEmpty()) {
                    throw new InvalidInputError("Sorry, the description of todo can not be empty");
                }

                String description = String.join(" ", splitCom);
                return new TodoCommand(description);

            }else if (command.startsWith(("deadline"))) {

                //split the command , remove the word deadline
                String[] splitCom = Arrays.copyOfRange(command.split(" "),1,
                        command.split(" ").length);
                String commandOne= String.join(" ", splitCom);

                //check for invalid input like "deadline " or "deadline"
                if(splitCom.length == 0 || String.join(" ", splitCom).trim().isEmpty()) {
                    throw new InvalidInputError("Sorry, the description of deadline can not be empty");

                }

                String deadlineRegex = "/by\\s+(.*)";
                String eventDescriptionRegex = "^(.*?)(?=\\s*/by|$)";

                Pattern patternDescription = Pattern.compile(eventDescriptionRegex);
                Pattern patternDeadline = Pattern.compile(deadlineRegex);

                Matcher matcherDescription = patternDescription.matcher(commandOne);
                Matcher matcherDeadline = patternDeadline.matcher(commandOne);

                if (matcherDeadline.find() && matcherDescription.find()) {
                    String deadlineTime = matcherDeadline.group(1).trim();
                    String description = matcherDescription.group(1).trim();

                    //check for input like "deadline /by Sunday"
                    if(description.isEmpty()) {
                        throw new InvalidInputError("Sorry, the description can not be empty");

                    }
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime deadline = LocalDateTime.parse(deadlineTime, formatter);
                        return new DeadlineCommand(description, deadline);
                    } catch (DateTimeException e) {
                        throw new InvalidInputError("Error: Invalid date format or invalid date." +
                                " valid: yyyy-MM-dd HH:mm.");
                    }
                } else {
                    //check for case where deadline are not provided
                    throw new InvalidInputError("Sorry, this is invalid input," +
                            " you need to provide description and deadline");
                }
            } else if (command.startsWith(("event"))) {
                String[] splitCom = Arrays.copyOfRange(command.split(" "),1,
                        command.split(" ").length);
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

                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime timeFrom = LocalDateTime.parse(from, formatter);
                        LocalDateTime timeTo = LocalDateTime.parse(to, formatter);
                        return new EventCommand(description, timeFrom, timeTo);
                    } catch (DateTimeException e) {
                        throw new InvalidInputError(
                                "Error: Invalid date format or invalid date. valid: yyyy-MM-dd HH:mm.");

                    }

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
