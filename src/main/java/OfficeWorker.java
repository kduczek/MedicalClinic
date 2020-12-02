import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfficeWorker extends Employee{
    private static final Scanner scanner = new Scanner(System.in);

    public OfficeWorker(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary) {
        super(employeeCode, name, surname, birthDate, hireDate, salary);
    }



    public double countWorkingTime(Employee employee) {
        Period salaryPeriod = Period.between(employee.getHireDate(), LocalDate.now());
        int months = salaryPeriod.getYears() * 12 + salaryPeriod.getMonths();
        return (double) Math.round((months / 12.0) * 100) / 100;
    }

    public double countWholeSalary(Employee employee) {
        double workTime = countWorkingTime(employee);
        return (double) Math.round((workTime * employee.getSalary()) * 100) / 100;
    }

    public Patient registerNewPatient() {
        LocalDate birthdate;
        System.out.println("Please insert name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter surname: ");
        String surname = scanner.nextLine();

        System.out.println("Birthdate \nPlease enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter month: ");
        int month = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        int day = scanner.nextInt();
        scanner.nextLine();

        if(verifyBirthDate(year, month, day)) {
            birthdate = LocalDate.of(year, month, day);
        } else {
            throw new IllegalArgumentException();
        }


        System.out.println("Please enter number of medical treatments: ");
        int numberOfTreatments = scanner.nextInt();
        scanner.nextLine();

        String[] treatments = new String[numberOfTreatments];

        List<String> listOfTreatments = new ArrayList<>();
        listOfTreatments.add("Injection");
        listOfTreatments.add("Weight measurement");
        listOfTreatments.add("Pressure measurement");
        listOfTreatments.add("Blood collection");
        listOfTreatments.add("General check up");
        listOfTreatments.add("Ultrasound examination");
        listOfTreatments.add("Writing a prescription");

        for(int i = 0; i < numberOfTreatments; i++) {
            printMedicalProcedures();
            int option = scanner.nextInt();
            scanner.nextLine();
            treatments[i] = listOfTreatments.get(option);
        }

        scanner.close();
        return new Patient(name, surname, birthdate, treatments);
    }

    private void printMedicalProcedures() {
        System.out.println("Available medical procedures:");
        System.out.println("1. Injection");
        System.out.println("2. Weight measurement");
        System.out.println("3. Pressure measurement");
        System.out.println("4. Blood collection");
        System.out.println("5. General check up");
        System.out.println("6. Ultrasound examination");
        System.out.println("7. Writing a prescription");
    }

    private static boolean verifyBirthDate(int year, int month, int day) {
        String date = year + "-" + month + "-" + day;

        boolean valid;

        try {

            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("uuuu-M-d")
                            .withResolverStyle(ResolverStyle.STRICT)
            );

            valid = true;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        }

        return valid;
    }
}
