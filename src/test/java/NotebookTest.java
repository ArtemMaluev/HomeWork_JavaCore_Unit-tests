import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class NotebookTest {
    private Notebook sut;

    @BeforeEach
    public void init() {
        System.out.println("Тесты запущенны");
        sut = new Notebook();
    }

    @BeforeAll
    public static void started() {
        System.out.println("Старт теста");
    }

    @AfterEach
    public void finished() {
        System.out.println("Окончание теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Тесты завершенны");
    }

    @Test
    public void testAddTasks() {
        String inputTask = "newTask";
        List<String> expected = new ArrayList<>();
        expected.add(inputTask);

        List<String> result = sut.addTasks(inputTask);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDeleteTask() {
        int index = 0;
        List<String> expected = new ArrayList<>();
        expected.add("task");
        expected.remove(index);

        List<String> result = sut.deleteTask("1"); // 1 - порядковый номер задачи для удаления

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEmptyList() {
        boolean expected = true;

        boolean result = sut.emptyList();

        Assertions.assertEquals(expected, result);
        Assertions.assertTrue(result);
    }
}
