package accounts;

/**
 * Created by win on 22.12.2015.
 */
public class UserProfile {
    private final String login;
    private final String pass;
    private final long id;

    public UserProfile(long id, String login, String pass) {
        this.id    = id;
        this.login = login;
        this.pass  = pass;
    }

    public String getLogin() {
        return login;
    }
    public String getPass() {
        return pass;
    }
    public long getId() { return id;}
}

