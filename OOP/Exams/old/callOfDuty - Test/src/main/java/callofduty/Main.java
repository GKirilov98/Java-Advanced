package callofduty;

import callofduty.core.Engine;
import callofduty.core.MissionControlImpl;
import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.*;
import callofduty.util.io.ConsoleInputReader;
import callofduty.util.io.ConsoleOutputWriter;
import callofduty.util.reflection.MissionExtractionUtil;

public class Main {
    public static void main(String[] args)  {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        MissionControl missionControl = new MissionControlImpl();
        MissionExtraction missionExtractionUtil = new MissionExtractionUtil();

        MissionManager manager = new MissionManagerImpl(missionControl, missionExtractionUtil);

        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}




