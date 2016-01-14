package accounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 22.12.2015.
 */
public class AccountService implements IAccountService {

    private long currentId;
    private final List<UserProfile> profiles;

    public AccountService() {
        profiles = new ArrayList<>();
        currentId = 0;
    }

    public long addUser(String login, String password)
    {
        profiles.add(new UserProfile(++currentId, login, password));
        return currentId;
    }

    public  UserProfile getUser(long id)
    {
        return profiles
                .stream()
                .filter(userProfile -> userProfile.getId() == id)
                .findFirst()
                .get();
    }

    public void printConnectInfo()
    {
        System.out.println("Connected!");
    }

    public UserProfile getUser(String login, String password) {
        return profiles
                .stream()
                .filter(userProfile -> userProfile.getLogin().equals(login) && userProfile.getPass().equals(password))
                .findFirst()
                .get();
    }

    public void cleanUp() throws Exception {

    }
}
