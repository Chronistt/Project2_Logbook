import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    public static List<Task> listTask = new ArrayList<>();

    public TaskService(List<Task> listTask) {
        this.listTask = listTask;
    }

    public void addTask (Task task){
        listTask.add(task);
    };

    public Collection<Task> getAllByDate(LocalDate date) {
    listTask = listTask.stream()
            .filter(d-> d.appearsIn(date))
            .collect(Collectors.toList());
       return listTask;
    }

   public void removeTask (int id) {
        Task task = null;
        for (int i = 0; i < listTask.size(); i++)
            task = listTask.get(i);
        if (task.getId()==id) {
            listTask.remove(i);
        }
         }

        }
