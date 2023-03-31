import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        super(title, description, nonPersonal, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate s) {
        return s.getDayOfMonth() == this.getDateTime().getDayOfMonth();
    }
}
