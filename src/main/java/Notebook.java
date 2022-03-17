import java.util.*;

/**
 * Класс Notebook добавляет задачи в виде списка, удаляет задачи из списка, выводит задачи.
 *
 * Содержит следующие методы:
 * descriptionOperations() - метод описывает операции доступные пользователю
 * addTasks() - метод добавляет одну новую задачу в список;
 * deleteTask() - метод удаляет одну задачу из списка;
 * outputTasks() - метод выводит список задач;
 * clearList() - метод очищает весь список задач;
 * emptyList() - метод проверяет список на наличие задач.
 *
 * @author Малуев Артем
 */
public class Notebook {

    private final List<String> tasks;

    public Notebook() {
        tasks = new ArrayList<>();
    }

    // Метод описывает операции доступные пользователю
    public void descriptionOperations() {
        System.out.println("\nЭлектронная записная книжка");
        System.out.println("Для работы с электронной записной книжкой выберите команду из списка:"
                + "\n1 - Добавление новой задачи" + "\n2 - Удаление задачи из списка" + "\n3 - Просмотр списка задач"
                + "\n9 - Удалить все задачи" + "\n\"end\" - Выход\n");
    }

    // Метод служит для добавление новой задачи в список
    public List<String> addTasks(String inputTask) {
        tasks.add(inputTask);
        return tasks;
    }

    // Метод служит для удаления задачи из списка по порядковому номеру
    public List<String> deleteTask(String inputIndex) {
        try {
            int index = Integer.parseInt(inputIndex);
            tasks.remove(index - 1);
            outputTasks();
        } catch (Exception exception) {
            System.out.println("Введена не верная команда");
        }
        return tasks;
    }

    // Метод выводит список дел
    public void outputTasks() {
        if (emptyList()) {
            return;
        }
        System.out.println("Список дел:");
        int i = 1;
        for (String task : tasks) {
            System.out.println(i + ". " + task);
            i++;
        }
    }

    // Метод удаляет все задачи из списка
    public List<String> clearList(String inputVerificatoin) {
        if ("да".equalsIgnoreCase(inputVerificatoin)) {
            tasks.clear();
            outputTasks();
        } else {
            System.out.println("Удаление отменено");
        }
        return tasks;
    }

    // Метод проверяет список на наличие задач
    public boolean emptyList() {
        if (tasks.isEmpty()) {
            System.out.println("Список дел пуст");
            return true;
        }
        return false;
    }
}
