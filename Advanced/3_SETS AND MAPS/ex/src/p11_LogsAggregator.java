import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class p11_LogsAggregator {
    public static void main(String[] args) {
         Scanner console = new Scanner(System.in);
         int n = Integer.parseInt(console.nextLine());
        TreeMap<String, TreeSet<String>> userIp = new TreeMap<>();
        HashMap<String, Integer> userDuration = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = console.nextLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);
            if (!userIp.containsKey(user)){
                userIp.put(user, new TreeSet<>(){{
                    add(ip);
                }});
                userDuration.put(user, duration);
            } else {
                userIp.get(user).add(ip);
                userDuration.put(user, duration + userDuration.get(user));
            }
        }

        for (Object user : userIp.keySet()) {
            StringBuilder ips = new StringBuilder();
            for (String ip : userIp.get(user)) {
                ips.append(ip + ", ");
            }
            ips.replace(ips.length() - 2, ips.length(), "]");
            System.out.printf("%s: %d [%s%n",user,userDuration.get(user),ips);
        }
    }
}
