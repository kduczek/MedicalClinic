import java.time.LocalDate;

public class Internist extends MedicalWorker{
    public Internist(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary, int medicalLicenseNumber) {
        super(employeeCode, name, surname, birthDate, hireDate, salary, medicalLicenseNumber);
    }
}
