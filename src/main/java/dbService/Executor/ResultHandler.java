package dbService.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by win on 13.01.2016.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
