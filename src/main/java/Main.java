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
    }
}
