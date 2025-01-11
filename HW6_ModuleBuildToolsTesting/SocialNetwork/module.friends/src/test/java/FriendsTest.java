import friends.FriendsImpl;
import friends.FriendsService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import user.User;

import javax.naming.NameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FriendsTest {

    FriendsService friendsService;

    User user;
    User userFriend;
    User userFriend2;
    User userFriend3;
    User userFriend4;

    @BeforeEach
    public void setUp() {
        friendsService = new FriendsImpl();

        user = new User(0, "Иван", "Иванов", "asdf");
        userFriend = new User(1, "Петр", "Петров", "zxcv");
        userFriend2 = new User(2, "Семён", "Семёнович", "poiu");
        userFriend3 = new User(3, "Наталья", "Филимонова", "vbnm");
        userFriend4 = new User(4, "Борис", "Денисов", "fghj");

        friendsService.addFriend(user, userFriend);
        friendsService.addFriend(user, userFriend2);
        friendsService.addFriend(user, userFriend3);
    }

    @Test
    @Order(1)
    @DisplayName("Добавление друга")
    public void testAddFriend() {
        int expected = 4;
        friendsService.addFriend(user, userFriend4);
        assertEquals(expected, friendsService.getCountFriends());
    }

    @Test
    @Order(2)
    @DisplayName("Удаление друга")
    public void testRemoveFriend() {
        int expected = 2;
        friendsService.removeFriend(user, userFriend2);
        assertEquals(expected, friendsService.getCountFriends());
    }

    @Test
    @Order(3)
    @DisplayName("Поиск друга по имени")
    public void testFindFriendByName() throws NameNotFoundException {
        String expected = "Семён";
        String actual = friendsService.findFriendByName("Семён");
        assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    @DisplayName("Друг не найден")
    public void testFriendNotFound() {
        assertThrows(NameNotFoundException.class, () -> friendsService.findFriendByName("Игорь"));
    }
}
