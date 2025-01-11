package user;

public interface UserService {
    User findUserById(Integer id);

    User findUserByName(String name);

    User findUserBySurname(String surname);

    boolean authentication(String name, String password);
}
