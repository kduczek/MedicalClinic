import java.time.LocalDate;

public class Employee {
    private int employeeCode;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private double salary;

    public Employee(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printData() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Date of birth: " + this.birthDate.toString());
        System.out.println("Salary: " + this.salary);
        System.out.println("Date of employment: " + this.hireDate.toString());
        System.out.println("Employee code: " + this.employeeCode);
    }
}
