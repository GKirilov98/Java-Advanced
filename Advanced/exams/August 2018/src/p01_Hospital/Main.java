package p01_Hospital;


import java.util.*;

public class Main {

    static class Department {
        private String name;
        private List<Patient> patientList;
        private int room = 1;
        private int beds = 0;

        public Department(String name) {
            this.name = name;
            patientList = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Patient> getPatientList() {
            return patientList;
        }


        public void addPatient(String patient, String doctor) {
            if (checkFreeSpace()) {
                return;
            }

            if (beds == 3) {
                room += 1;
                beds = 0;
            }

            patientList.add(new Patient(patient, doctor, this.room));
            beds++;
        }

        public boolean checkFreeSpace() {
            return room == 21;
        }

    }

    static class Patient {
        private String name;
        private String doctor;
        private int roomNumber;

        public String getName() {
            return name;
        }

        public String getDoctor() {
            return doctor;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public Patient(String name, String doctor, int roomNumber) {
            this.name = name;
            this.doctor = doctor;
            this.roomNumber = roomNumber;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String register = scanner.nextLine().trim();
        LinkedHashMap<String, Department> allDepartments = new LinkedHashMap<>();
        while (!register.equals("Output")) {
            String[] tokens = register.split("\\s+");
            String department = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            allDepartments.putIfAbsent(department, new Department(department));
            allDepartments.get(department).addPatient(patient, doctor);

            register = scanner.nextLine().trim();
        }

        String command = scanner.nextLine().trim();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            if (tokens.length == 1) {
                allDepartments.get(tokens[0]).getPatientList().forEach(p -> System.out.println(p.getName()));
            } else if (tokens[1].length() < 3) {
                int currRoom = Integer.parseInt(tokens[1]);
                allDepartments.get(tokens[0]).getPatientList().stream().filter(p -> p.getRoomNumber() == currRoom)
                        .sorted(Comparator.comparing(Patient::getName)).forEach(p -> {
                    System.out.println(p.getName());
                });
            } else {
                List<String> patientsCurrDoctor = new ArrayList<>();
                String currDoctor = command;
                for (String department : allDepartments.keySet()) {
                    allDepartments.get(department).getPatientList().forEach(p -> {
                        if (p.getDoctor().equals(currDoctor)) {
                            patientsCurrDoctor.add(p.getName());
                        }
                    });
                }

                patientsCurrDoctor.sort(String::compareTo);
                patientsCurrDoctor.forEach(System.out::println);
            }

            command = scanner.nextLine().trim();
        }

    }
}
