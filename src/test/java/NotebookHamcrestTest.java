import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class NotebookHamcrestTest {
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

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testDeleteTask() {
        int index = 0;
        List<String> expected = new ArrayList<>();
        expected.add("task");
        expected.remove(index);

        List<String> result = sut.deleteTask("1"); // 1 - порядковый номер задачи для удаления

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testEmptyList() {
        boolean expected = true;

        boolean result = sut.emptyList();

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void testAddTasksIgnoringCase() {
        String a = "Task";
        String b = "task";

        MatcherAssert.assertThat(a, Matchers.equalToIgnoringCase(b));
    }

    @Test
    public void testClearList() {
        String str = "да"; // команда на подтверждение удаления списка
        List<String> task = sut.clearList(str);

        MatcherAssert.assertThat(task, Matchers.empty());
    }
}
