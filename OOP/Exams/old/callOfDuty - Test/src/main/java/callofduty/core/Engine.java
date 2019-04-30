package callofduty.core;

import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Engine {
    private static final String INPUT_LINE_DELIMITER = "\\s";

    private static final Integer INPUT_LINE_COMMAND_ELEMENT_INDEX = 0;

    private static final String OVER_COMMAND_KEYWORD = "Over";

    private boolean isRunning;

    private final InputReader reader;

    private final OutputWriter writer;

    private final MissionManager manager;

    public Engine(InputReader reader, OutputWriter writer, MissionManager manager) {
        this.isRunning = false;
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    private Map<String, List<String>> formatArguments(String inputLine) {
        List<String> splittedInputLine = Arrays
                .stream(inputLine.split(INPUT_LINE_DELIMITER))
                .collect(Collectors.toList());

        return new HashMap<>() {{
            put(splittedInputLine.get(INPUT_LINE_COMMAND_ELEMENT_INDEX), splittedInputLine
                    .stream()
                    .skip(1)
                    .collect(Collectors.toList()));
        }};
    }

    private String executeCommand(Map<String, List<String>> formattedArguments) {
        String actionName = formattedArguments
                .entrySet()
                .stream()
                .findFirst()
                .orElseThrow()
                .getKey();

        List<String> actionArguments = formattedArguments
                .entrySet()
                .stream()
                .findFirst()
                .orElseThrow()
                .getValue();

        try {
            return (String) Arrays.stream(this.manager
                    .getClass()
                    .getDeclaredMethods())
                    .filter(x -> x.getName().equals(actionName.toLowerCase()))
                    .findFirst()
                    .orElseThrow()
                    .invoke(this.manager, actionArguments);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void checkIfOver(Map<String, List<String>> formattedArguments) {
        if(formattedArguments.containsKey(OVER_COMMAND_KEYWORD)) {
            this.isRunning = false;
        }
    }

    public void run() {
        this.isRunning = true;

        while (this.isRunning) {
            String inputLine = this.reader.readLine();
            Map<String, List<String>> formattedArguments = this.formatArguments(inputLine);
            this.checkIfOver(formattedArguments);
            String commandResult = this.executeCommand(formattedArguments);
            this.writer.println(commandResult);
        }
    }
}
