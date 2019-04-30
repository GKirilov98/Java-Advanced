import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p09_UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        String command = console.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String ip = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];
            if (!logs.containsKey(user)) {
                LinkedHashMap<String, Integer> ipCount = new LinkedHashMap<>();
                ipCount.put(ip, 1);
                logs.put(user, ipCount);
            } else {
                if (!logs.get(user).containsKey(ip)) {
                    logs.get(user).put(ip, 1);
                } else {
                    logs.get(user).put(ip, logs.get(user).get(ip) + 1);
                }
            }
            command = console.nextLine();
        }

        for (String user : logs.keySet()) {
            System.out.println(user + ":");
            StringBuilder toPrintIp = new StringBuilder();
            for (String ip : logs.get(user).keySet()) {
                toPrintIp.append(ip + " => "+ logs.get(user).get(ip) +", ");
            }
           toPrintIp.replace(toPrintIp.length() - 2,toPrintIp.length(),".");
            System.out.println(toPrintIp);
        }
    }
}
