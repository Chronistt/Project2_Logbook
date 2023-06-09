import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private String title;
    private String description;
    private boolean nonPersonal;
    public static int id=0;

    private LocalDateTime dateTime;

    public Task(String title, String description, boolean nonPersonal, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.nonPersonal = nonPersonal;
        this.dateTime = dateTime;
        id++;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNonPersonal() {
        return nonPersonal;
    }

    public void setNonPersonal(boolean nonPersonal) {
        this.nonPersonal = nonPersonal;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean appearsIn(LocalDate s) {
        return s.equals(LocalDate.from(this.getDateTime()));
    }

 
    @Override
    public String toString() {
        return getId()+getTitle() +"  "+ getDescription() +"  "+ getDateTime()+"  "+ (isNonPersonal()?"WORK":"PERSONAL");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return nonPersonal == task.nonPersonal && title.equals(task.title) && description.equals(task.description) && dateTime.equals(task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, nonPersonal, dateTime);
    }
}
