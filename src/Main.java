import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();

        while (true) {
            System.out.println("Выберите пункт меню:");
            printMenu();
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        try {
                            TaskService.addTask(scanner);
                        } catch (IncorrectArgumentException e) {
                            System.out.println("Введи еще раз");;
                        }
                        break;
                    case 2:
                        System.out.println("Введите идентификатор задачи для удаления");
                        TaskService.removeTask(scanner.nextInt());
                        break;
                    case 3:
                        System.out.println(TaskService.getAllByDate(scanner));
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