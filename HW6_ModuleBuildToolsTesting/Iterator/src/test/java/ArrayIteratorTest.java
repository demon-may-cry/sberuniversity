import org.junit.jupiter.api.*;
import ru.sberuniversity.iterator.ArrayIterator;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayIteratorTest {

    @Test
    @Order(1)
    @DisplayName("Тест наличия следующего элемента")
    public void testHasNext() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{1, 2});
        boolean result = iterator.hasNext();
        assertTrue(result);
    }

    @Test
    @Order(2)
    @DisplayName("Тест отсутствия следующего элемента")
    public void testNextNull() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{});
        assertThrows(ArrayIndexOutOfBoundsException.class, iterator::next);
    }

    @Test
    @Order(3)
    @DisplayName("Тест размера коллекции")
    public void testSize() {
        int expected = 4;
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{0, 1, 2, 3});
        assertEquals(expected, iterator.size());
    }
}
