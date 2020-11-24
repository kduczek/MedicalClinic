import java.time.LocalDate;

public class Nurse extends MedicalWorker {
    public Nurse(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary, int medicalLicenseNumber) {
        super(employeeCode, name, surname, birthDate, hireDate, salary, medicalLicenseNumber);
    }
}
