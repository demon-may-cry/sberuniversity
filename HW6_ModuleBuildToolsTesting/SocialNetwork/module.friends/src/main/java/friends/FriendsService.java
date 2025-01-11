package friends;

import user.User;

import javax.naming.NameNotFoundException;

public interface FriendsService {
    int getCountFriends();

    String findFriendByName(String friendName) throws NameNotFoundException;

    void addFriend(User user, User userFriend);

    void removeFriend(User user, User userFriend);
}
