import java.time.LocalDate;
import java.time.Period;

public class OfficeWorker extends Employee{
    public OfficeWorker(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary) {
        super(employeeCode, name, surname, birthDate, hireDate, salary);
    }



    public double countWorkingTime(MedicalWorker medicalWorker) {
        Period salaryPeriod = Period.between(medicalWorker.getHireDate(), LocalDate.now());
        int months = salaryPeriod.getYears() * 12 + salaryPeriod.getMonths();
        return (double) Math.round((months / 12.0) * 100) / 100;
    }

    public double countWholeSalary(MedicalWorker medicalWorker) {
        double workTime = countWorkingTime(medicalWorker);
        return (double) Math.round((workTime * medicalWorker.getSalary()) * 100) / 100;
    }
}
