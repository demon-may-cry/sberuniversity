package friends;

import user.User;

import javax.naming.NameNotFoundException;
import java.util.*;

public class FriendsImpl implements FriendsService {

    private final Map<User, Set<User>> friendsList = new HashMap<>();

    @Override
    public int getCountFriends() {
        int count = 0;
        for (Map.Entry<User, Set<User>> entry : friendsList.entrySet()) {
            count = entry.getValue().size();
        }
        return count;
    }

    @Override
    public String findFriendByName(String friendName) throws NameNotFoundException {
        String name = null;
        Set<User> friend = new HashSet<>();
        for (Map.Entry<User, Set<User>> entry : friendsList.entrySet()) {
            friend = entry.getValue();
        }
        for (User user : friend) {
            if (user.getUserName().equals(friendName)) {
                name = user.getUserName();
            }
        }
        if (name == null) {
            throw new NameNotFoundException("Друг не найден");
        }
        return name;
    }

    @Override
    public void addFriend(User user, User userFriend) {
        friendsList.computeIfAbsent(user, k -> new HashSet<>()).add(userFriend);
    }

    @Override
    public void removeFriend(User user, User userFriend) {
        friendsList.getOrDefault(user, Collections.emptySet()).remove(userFriend);
    }
}
