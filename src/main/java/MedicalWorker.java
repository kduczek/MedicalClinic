import java.time.LocalDate;

public class MedicalWorker extends Employee{
    private int medicalLicenseNumber;

    public MedicalWorker(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary, int medicalLicenseNumber) {
        super(employeeCode, name, surname, birthDate, hireDate, salary);
        this.medicalLicenseNumber = medicalLicenseNumber;
    }
}
