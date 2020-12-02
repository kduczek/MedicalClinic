import java.time.LocalDate;

public class MedicalWorker extends Employee{
    private int medicalLicenseNumber;

    public MedicalWorker(int employeeCode, String name, String surname, LocalDate birthDate, LocalDate hireDate, double salary, int medicalLicenseNumber) {
        super(employeeCode, name, surname, birthDate, hireDate, salary);
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    //Method created to concat lot of text to String and use this String in Log in Main
    public String printTreatment(Patient patient) {
        StringBuilder stringBuilder = new StringBuilder("********TREATMENT********\n");
        stringBuilder.append(patient.getPatron().getClass().getName().toUpperCase()).append(": ").append(patient.getPatron().getName())
                .append(" ").append(patient.getPatron().getSurname());
        stringBuilder.append("\nPATIENT: ").append(patient.getName()).append(" ").append(patient.getSurname());
        stringBuilder.append("\nTREATMENTS: ");

        for(String temp : patient.getTreatments()) {
            stringBuilder.append(temp).append(", ");
        }

        return stringBuilder.toString();
    }
}

