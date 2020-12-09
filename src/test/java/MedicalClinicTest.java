import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class MedicalClinicTest {
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

    Patient patient = new Patient("Arek", "Kowalski",
            LocalDate.of(1998, 2, 18),
            new String[]{"Injection"});

    @Test
    public void officeWorkerConstructorTest() {
        Assertions.assertNotNull(officeWorker);
    }

    @Test
    public void nurseConstructorTest() {
        Assertions.assertNotNull(nurse);
    }

    @Test
    public void internistConstructorTest() {
        Assertions.assertNotNull(internist);
    }

    @Test
    public void pediatricianConstructorTest() {
        Assertions.assertNotNull(pediatrician);
    }

    @Test
    public void employeeGetSetNameTest() {
        internist.setName("Krystian");
        Assertions.assertEquals("Krystian", internist.getName());
    }

    @Test
    public void employeeGetSetSurnameTest() {
        internist.setSurname("Duczek");
        Assertions.assertEquals("Duczek", internist.getSurname());
    }

    @Test
    public void employeeGetSetEmployeeCodeTest() {
        internist.setEmployeeCode(3456);
        Assertions.assertEquals(3456, internist.getEmployeeCode());
    }

    @Test
    public void employeeGetSetBirthDateTest() {
        internist.setBirthDate(LocalDate.now());
        Assertions.assertEquals(LocalDate.now(), internist.getBirthDate());
    }

    @Test
    public void employeeGetSetHireDateTest() {
        internist.setHireDate(LocalDate.now());
        Assertions.assertEquals(LocalDate.now(), internist.getHireDate());
    }

    @Test
    public void employeeGetSetSalaryTest() {
        internist.setSalary(3250.5);
        Assertions.assertEquals(3250.5, internist.getSalary());
    }

    @Test
    public void patientConstructorTest() {
        Assertions.assertNotNull(patient);
    }

    @Test
    public void patientGetSetNameTest() {
        patient.setName("Rafal");
        Assertions.assertEquals("Rafal", patient.getName());
    }

    @Test
    public void patientGetSetSurnameTest() {
        patient.setSurname("Stan");
        Assertions.assertEquals("Stan", patient.getSurname());
    }

    @Test
    public void patientGetSetBirthDateTest() {
        patient.setBirthDate(LocalDate.now());
        Assertions.assertEquals(LocalDate.now(), patient.getBirthDate());
    }

    @Test
    public void patientGetSetPatronTest() {
        patient.setPatron(internist);
        Assertions.assertEquals(internist, patient.getPatron());
    }

    @Test
    public void patientGetSetTreatmentsTest() {
        String[] tab = new String[]{"Injection"};
        patient.setTreatments(tab);
        Assertions.assertEquals(tab, patient.getTreatments());
    }

    @Test
    public void patientIsMatureTest() {
        patient.setBirthDate(LocalDate.of(1998, 8, 31));
        Assertions.assertTrue(patient.isMature());
    }

    @Test
    public void patientListOfTreatmentsTest() {
        StringBuilder stringBuilder = new StringBuilder("Treatments: ");
        for(String temp : patient.getTreatments()) {
            stringBuilder.append(temp).append(", ");
        }

        Assertions.assertEquals(stringBuilder.toString(), patient.listOfTreatments());
    }

    @Test
    public void officeWorkerCountWorkingTimeTest() {
        Period salaryPeriod = Period.between(internist.getHireDate(), LocalDate.now());
        int months = salaryPeriod.getYears() * 12 + salaryPeriod.getMonths();
        double monthsInDouble = (double) Math.round((months) * 100) / 100;
        Assertions.assertEquals((double) Math.round((months / 12.0) * 100 ) / 100, officeWorker.countWorkingTime(internist));
    }

    @Test
    public void officeWorkerCountWholeSalaryTest() {
        Period salaryPeriod = Period.between(internist.getHireDate(), LocalDate.now());
        int months = salaryPeriod.getYears() * 12 + salaryPeriod.getMonths();
        double workTime = (double) Math.round((months) * 100) / 100;
        Assertions.assertEquals((double) Math.round((workTime * internist.getSalary()) * 100) / 100, officeWorker.countWholeSalary(internist));
    }

    @Test
    public void medicalWorkerPrintTreatmentTest() {
        patient.setPatron(internist);
        StringBuilder stringBuilder = new StringBuilder("********TREATMENT********\n");
        stringBuilder.append(patient.getPatron().getClass().getName().toUpperCase()).append(": ").append(patient.getPatron().getName())
                .append(" ").append(patient.getPatron().getSurname());
        stringBuilder.append("\nPATIENT: ").append(patient.getName()).append(" ").append(patient.getSurname());
        stringBuilder.append("\nTREATMENTS: ");

        for(String temp : patient.getTreatments()) {
            stringBuilder.append(temp).append(", ");
        }

        Assertions.assertEquals(stringBuilder.toString(), internist.printTreatment(patient));
    }

}
