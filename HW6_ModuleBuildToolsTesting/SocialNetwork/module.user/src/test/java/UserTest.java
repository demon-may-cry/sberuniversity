import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import user.User;
import user.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    @Mock
    UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1, "Иван", "Иванов", "qwerty");
    }

    @Test
    @Order(1)
    @DisplayName("Поиск пользователя по id")
    public void testFindById() {
        when(userService.findUserById(1)).thenReturn(user);
        User actual = userService.findUserById(1);
        assertEquals(user.getUserName(), actual.getUserName());
    }

    @Test
    @Order(2)
    @DisplayName("Поиск пользователя по имени")
    public void testFindByName() {
        when(userService.findUserByName("Иван")).thenReturn(user);
        User actual = userService.findUserByName("Иван");
        assertEquals(user.getUserId(), actual.getUserId());
    }

    @Test
    @Order(3)
    @DisplayName("Поиск пользователя по фамилии")
    public void testFindBySurname() {
        when(userService.findUserBySurname("Иванов")).thenReturn(user);
        User actual = userService.findUserBySurname("Иванов");
        assertEquals(user.getUserId(), actual.getUserId());
    }

    @Test
    @Order(4)
    @DisplayName("Проверка пароля")
    public void testCheckPassword() {
        when(userService.authentication("Иван", "Иванов")).thenReturn(true);
        boolean actual = userService.authentication("Иван", "Иванов");
        assertTrue(actual);
    }
}
