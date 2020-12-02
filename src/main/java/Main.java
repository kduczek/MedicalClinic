import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option;
        int employeeCode;
        //Creating all employees of Clinic
        List<Employee> employeeList = new ArrayList<>();
        OfficeWorker officeWorker = new OfficeWorker(2137, "Barbara", "Nowak",
                LocalDate.of(1972, 7, 22),
                LocalDate.of(2012, 5, 17),
                3250.50);

        Nurse nurse = new Nurse(7452, "Karolina", "Podgrzybek",
                LocalDate.of(1989, 8, 13),
                LocalDate.of(2014, 7, 1),
                2990.70, 77732);

        Internist internist = new Internist(1723, "Jan", "Kowalski",
                LocalDate.of(1972, 2, 13),
                LocalDate.of(2015, 9, 1),
                4100, 7777);

        Pediatrician pediatrician = new Pediatrician(4217, "Kamil", "Slimak",
                LocalDate.of(1989, 11, 23),
                LocalDate.of(2018, 12, 3),
                5250.50, 76982);

        employeeList.add(officeWorker);
        employeeList.add(nurse);
        employeeList.add(pediatrician);
        employeeList.add(internist);


        //loop in which user can choose what he want to do
        while (true){
            printOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            if(option > 5 || option < 1) {
                System.out.println("Wrong number! You have to choose again! \n");
            }

            switch (option) {
                case 1:
                    try {
                        Patient patient = officeWorker.registerNewPatient();
                        String[] treatmentsTab = patient.getTreatments();
                        boolean isDoctorNeeded = true;
                        for (String treatment : treatmentsTab) {
                            if (treatment.equals("General check up")
                                    || treatment.equals("Ultrasound examination")
                                    || treatment.equals("Writing a prescription")) {
                                patient.setPatron(nurse);

                                if (patient.isMature()) {
                                    patient.setPatron(internist);
                                } else {
                                    patient.setPatron(pediatrician);
                                }

                                isDoctorNeeded = false;
                                break;
                            }
                        }

                        if (!isDoctorNeeded) {
                            patient.setPatron(nurse);
                        }
                    } catch (IllegalArgumentException iae) {
                        System.err.println("Wrong date");
                    }
                    break;
                case 2:
                    employeeCode = getEmployeeCodeFromUser();
                    try {
                        verifyEmployeeCode(employeeList, employeeCode);
                        System.out.println("Total salary " +
                                officeWorker.countWholeSalary(returnEmployeeWhichHasThisCode(employeeList, employeeCode)) + " zl");
                    } catch (IllegalArgumentException iae) {
                        System.err.println("Wrong employee code!");
                    }
                    break;

                case 3:
                    employeeCode = getEmployeeCodeFromUser();
                    try {
                        verifyEmployeeCode(employeeList, employeeCode);
                        System.out.println("Time of employment " +
                                officeWorker.countWorkingTime(Objects.requireNonNull(returnEmployeeWhichHasThisCode(employeeList, employeeCode))) + "year(s)");
                    } catch (IllegalArgumentException iae) {
                        System.err.println("Wrong employee code!");
                    }
                    break;

                case 4:
                    employeeCode = getEmployeeCodeFromUser();
                    try {
                        verifyEmployeeCode(employeeList, employeeCode);
                        System.out.println("All informations about this employee");
                        Objects.requireNonNull(returnEmployeeWhichHasThisCode(employeeList, employeeCode)).printData();

                    } catch (IllegalArgumentException iae) {
                        System.err.println("Wrong employee code!");
                    }
                    break;
                case 5:
                    System.out.println("Finishing program ...");
                    scanner.close();
                    return;
                default:
                    System.err.println("Error!");
                    return;
            }
        }

    }

    //Simple method to print all available options without code repetition
    private static void printOptions() {
        System.out.println("~~~~~~Medical Clinic~~~~~");
        System.out.println("List of possible actions:");
        System.out.println("1. Register new patient.");
        System.out.println("2. Print employee whole salary.");
        System.out.println("3. Print employee time of employment");
        System.out.println("4. Print employee data");
        System.out.println("5. Finish");
    }

    //Simple method which take user input and returns it as an integer
    private static int getEmployeeCodeFromUser() {
        System.out.println("Type employee code: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        return code;
    }

    //void method which have to throw exception when we provide employee code of non-existing employee,
    //otherwise the method does nothing
    private static void verifyEmployeeCode(List<Employee> employeeList, int code) {
        for(Employee emp : employeeList) {
            if(emp.getEmployeeCode() == code) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    //method that returns employee from list which fulfills required condition
    private static Employee returnEmployeeWhichHasThisCode(List<Employee> employeeList, int employeeCode) {
        for(Employee emp : employeeList) {
            if(emp.getEmployeeCode() == employeeCode) {
                return emp;
            }
        }
        return null;
    }

}
