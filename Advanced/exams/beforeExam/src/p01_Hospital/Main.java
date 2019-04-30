package p01_Hospital;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

public class Main {
    static class Patient {
        private String name;
        private String doctor;
        private int room;

        public String getName() {
            return name;
        }

        public String getDoctor() {
            return doctor;
        }

        public int getRoom() {
            return room;
        }

        public Patient(String name, String doctor, int room) {
            this.name = name;
            this.doctor = doctor;
            this.room = room;
        }
    }

    static class Department {
        private int room = 1;
        private int bed = 0;
        private String name;
        private List<Patient> patientList;

        public List<Patient> getPatientList() {
            return patientList;
        }

        public Department(String department) {
            this.name = department;
            patientList = new ArrayList<>();
        }

        public void addPatient(String patientName, String doctorName){
            if (room > 20){
                return;
            }

            patientList.add(new Patient(patientName, doctorName, this.room));
            bed++;
            if (bed == 3){
                room ++;
                bed = 0;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Department> hospital = new LinkedHashMap<>();
        while (!line.equals("Output")) {
            String[] tokens = line.split("\\s+");
            String department = "";
            for (int i = 0; i < tokens.length - 3; i++) {
                department += tokens[i];
            }
            String doctor = tokens[tokens.length - 3] + " " + tokens[tokens.length - 2];
            String patient = tokens[tokens.length - 1];

            hospital.putIfAbsent(department, new Department(department));
            hospital.get(department).addPatient(patient, doctor);

            line = scanner.nextLine();
        }

        String command = scanner.nextLine().trim();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            if (hospital.containsKey(tokens[0])) {
                String department = tokens[0];
                if (isNumeric(tokens[tokens.length - 1])) {
                    int room = Integer.parseInt(tokens[tokens.length - 1]);
                    hospital.get(department).getPatientList().stream().filter(p -> p.getRoom() == room)
                            .sorted(Comparator.comparing(Patient::getName))
                            .forEach(p -> System.out.println(p.getName()));
                } else {
                    hospital.get(department).getPatientList().forEach(p -> System.out.println(p.getName()));
                }

            } else {
                printDoctorPatients(hospital, command);
            }

            command = scanner.nextLine();
        }


    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    private static void printDoctorPatients(Map<String, Department> hospital, String doctor) {
        List<String> doctorsPatients = new ArrayList<>();
        hospital.values().forEach(d ->
                d.getPatientList().forEach(p -> {
                    if (p.getDoctor().equals(doctor)) {
                        doctorsPatients.add(p.getName());
                    }
                }));
        Collections.sort(doctorsPatients);
        doctorsPatients.forEach(System.out::println);
    }
}
