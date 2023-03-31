import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        super(title, description, nonPersonal, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate s) {
        return s.getDayOfWeek() == this.getDateTime().getDayOfWeek();
    }
}
