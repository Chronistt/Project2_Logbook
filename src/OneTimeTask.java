import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        super(title, description, nonPersonal, dateTime);
    }
    @Override
    public boolean appearsIn(LocalDate s) {
        return s == this.getDateTime().toLocalDate();
    }
}
