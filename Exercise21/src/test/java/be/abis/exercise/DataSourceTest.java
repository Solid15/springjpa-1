package be.abis.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testConnectionViaPostgreSQLsucceeded() throws SQLException {
        Connection c = dataSource.getConnection();
        assertEquals("PostgreSQL",c.getMetaData().getDatabaseProductName());
    }
}
