package accounts;

/**
 * Created by win on 14.01.2016.
 */
public interface IAccountService {

    long addUser(String login, String password) throws Exception;
    UserProfile getUser(long id )throws Exception;
    void printConnectInfo();
    void cleanUp() throws Exception;
    UserProfile getUserByLogin(String login) throws Exception;
}
