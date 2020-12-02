import java.time.LocalDate;
import java.time.Period;

public class Patient {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String[] treatments;
    private MedicalWorker patron;

    public Patient(String name, String surname, LocalDate birthDate, String[] treatments) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.treatments = treatments;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String[] getTreatments() {
        return treatments;
    }

    public MedicalWorker getPatron() {
        return patron;
    }

    public void setPatron(MedicalWorker patron) {
        this.patron = patron;
    }

    public boolean isMature() {
        Period age = Period.between(this.birthDate, LocalDate.now());

        return age.getYears() >= 18;
    }
}
