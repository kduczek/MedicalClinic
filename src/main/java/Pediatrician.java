import java.time.LocalDate;

public class Pediatrician extends MedicalWorker{
    public Pediatrician(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary, int medicalLicenseNumber) {
        super(employeeCode, name, surname, birthDate, hireDate, salary, medicalLicenseNumber);
    }
}
