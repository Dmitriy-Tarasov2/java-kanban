import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.time.LocalDateTime;


public class SleepTrackerApp {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please provide the path to the sleep log file.");
            return;
        }

        String filePath = args[0];
        List<SleepingSession> sessions = readSleepLog(filePath);

        int totalSessions = countTotalSessions(sessions);
        System.out.println("Total sleep sessions: " + totalSessions);
    }

    private static List<SleepingSession> readSleepLog(String filePath) throws IOException {
        List<SleepingSession> sessions = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    LocalDateTime startTime = LocalDateTime.parse(parts[0]);
                    LocalDateTime endTime = LocalDateTime.parse(parts[1]);
                    String quality = parts[2];
                    sessions.add(new SleepingSession(startTime, endTime, quality));
                }
            });
        }
        return sessions;
    }

    private static int countTotalSessions(List<SleepingSession> sessions) {
        return sessions.size();
    }
}
