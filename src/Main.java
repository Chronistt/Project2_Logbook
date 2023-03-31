import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Task task = new WeeklyTask(" 1 task ", "write a book", true, LocalDateTime.now());
        Task task1 = new WeeklyTask(" 2 task ", "write a book", true, LocalDateTime.now());
        System.out.println(task);
        System.out.println(task1);


        Scanner scanner = new Scanner(System.in);
        printMenu();

        while (true) {
            System.out.println("Выберите пункт меню:");
            printMenu();
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        TaskService.addTask(scanner);
                        break;
                    case 2:
                        TaskService.removeTask(scanner);
                        break;
                    case 3:
                        TaskService.getAllByDate(scanner);
                        break;
                    case 0:
                    break;                     }
            }
            }
        }
        private static void printMenu() {
        System.out.println("1. Добавить задачу\n" +
                "2. Удалить задачу \n" +
                "3. Получить задачи на указанный день\n" +
                "0. Выход"         );
    }


}