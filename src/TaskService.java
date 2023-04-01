import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TaskService {
    public static List<Task> listTask = new ArrayList<>();

     public static void addTask (Scanner scanner) {
        Task task;
         boolean nonPersonal=false;
        scanner.nextLine();
        System.out.println("Название задачи");
        String title = scanner.nextLine();
        System.out.println("Описание задачи");
        String description = scanner.nextLine();
        System.out.println("Тип задачи: 1 - рабочая. 2 - личная");
        label:
         switch (scanner.nextInt()) {
             case 1:{
                nonPersonal = true;
            }
             case 2:{
                nonPersonal = false;
            }
             default : {
                System.out.println("Введите еще раз");
                break label;
            }
        }
        System.out.println("Введите повторяемость задачи: 0 - однократная, 1 - ежедневная, 2- еженедельная, 3 - ежемесячная, 4 - ежегодная");
        int regularity = scanner.nextInt();
        System.out.println("Введите дату дд.ММ.гггг ЧЧ:мм");
        scanner.nextLine();

        listTask.add(createTask(scanner, title,description,nonPersonal,regularity));
    }

    public static Task createTask (Scanner scanner, String title, String description, boolean nonPersonal, int regularity) {
       // try {
            LocalDateTime taskDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Task task;
        //try {
                task = registerTask(regularity, title, description, nonPersonal, taskDate);
                System.out.println("Задача создана "+task);
            /*} catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
           }*/
        return task;
    }
    public static Task registerTask (int regularity, String title, String description, boolean nonPersonal, LocalDateTime localDateTime) {
         switch (regularity){
            case 0 : {
                OneTimeTask oneTimeTask = new OneTimeTask (title, description, nonPersonal, localDateTime);
                //listTask.add(oneTimeTask.getId(), oneTimeTask);
                 return oneTimeTask;
            }
            case 1 : {
                DailyTask dailyTask = new DailyTask(title, description, nonPersonal, localDateTime);
                // listTask.add(dailyTask.getId(), dailyTask);
                return dailyTask;
            }
            case 2: {
                WeeklyTask weeklyTask = new WeeklyTask(title, description, nonPersonal, localDateTime);
                // listTask.add(weeklyTask.getId(), weeklyTask);
                return weeklyTask;
            }

            case 3: {
                MonthlyTask monthlyTask = new MonthlyTask(title, description, nonPersonal, localDateTime);
                // listTask.add(monthlyTask.getId(), monthlyTask);
                return monthlyTask;
            }
            case 4: {
                YearlyTask yearlyTask = new YearlyTask(title, description, nonPersonal, localDateTime);
                // listTask.add(yearlyTask.getId(), yearlyTask);
                return yearlyTask;
            }
            default: {
                System.out.println("Введите номер от 0 до 4");
                return null;


            }


        }
    }

    public static Collection<Task> getAllByDate(Scanner scanner) {
           System.out.println("Введите дату дд.ММ.гггг");
           try {
        String dateInput = scanner.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateInput, dateTimeFormatter);
    listTask = listTask.stream()
            .filter(d-> d.appearsIn(date))
            .collect(Collectors.toList());

           } catch (DateTimeParseException e) {
               System.out.println("Неверный формат даты. Попробуйте еще раз");
           }
           scanner.nextLine();
        System.out.println("Для выхода нажмите Ввод\n");
        return listTask;

    }

   public static void removeTask (int id) {
       System.out.println("Введите идентификатор задачи для удаления");
       listTask.removeIf(task1 -> task1.getId()==id);
   }

}
