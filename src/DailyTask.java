import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        super(title, description, nonPersonal, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate s) {
        return true;
    }
}
