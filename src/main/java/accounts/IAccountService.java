package accounts;

/**
 * Created by win on 14.01.2016.
 */
public interface IAccountService {

    long addUser(String login, String password);
    UserProfile getUser(long id);
    void printConnectInfo();
}
