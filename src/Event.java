import java.time.LocalDate;
public record Event(LocalDate date, String title, String description) {

    @Override
    public String toString() {
        return "Событие: " + title + "\tКогда: " + date + "\tОписание: " + description + "\n";
    }
}