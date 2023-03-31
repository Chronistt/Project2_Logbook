import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        super(title, description, nonPersonal, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate s) {
        return s.getDayOfYear() == this.getDateTime().getDayOfYear();
    }
}
