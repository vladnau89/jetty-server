package dbService.dao;

import java.sql.Connection;
import java.sql.SQLException;
import dbService.executor.Executor;
import dbService.executor.ResultHandler;
import accounts.UserProfile;

/**
 * Created by win on 13.01.2016.
 */
public class UserDAO {
    private Executor executor;

    public UserDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserProfile get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new UserProfile(result.getLong(1), result.getString(2), result.getString(3));
        });
    }

    public long getUserId(String login, String password) throws SQLException {

        String query = String.format("select * from users where login='%s' and password ='%s'", login, password);
        return executor.execQuery(query, result -> {
            result.next();
            return result.getLong(1);
        });
    }

    public void insertUser(String login, String password) throws SQLException {
        executor.execUpdate(String.format("insert into users (login, password) values ('%s', '%s')", login , password));
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
