import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(officeWorker.countWorkingTime(internist));
        System.out.println(officeWorker.countWholeSalary(internist));
        internist.printData();
    }
}
