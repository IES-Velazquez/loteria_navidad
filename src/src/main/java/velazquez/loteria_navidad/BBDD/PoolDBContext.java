package velazquez.loteria_navidad.BBDD;




import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class PoolDBContext {
    static final Logger logger = LoggerFactory.getLogger(PoolDBContext.class);

    public BasicDataSource dataSource;

    public PoolDBContext() {
        initDataSource();
    }

    private void initDataSource() {
        Context initContext;

        try {
            logger.info("PoolDBContext init");
            initContext = new InitialContext();

            dataSource = (BasicDataSource) initContext.lookup("java:/comp/env/jdbc/ConexionMariadb");
            logger.info("PoolDBContext init OK");
        } catch (NamingException e) {
            logger.error(e.getMessage());
            logger.error(Arrays.toString(e.getStackTrace()));
        }
    }

    public Connection getConnection() {
        logger.info("PoolDBContext getConnection");
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            logger.info("PoolDBContext getConnection OK");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            logger.error(e.getCause().getMessage());
            logger.error(Arrays.toString(e.getStackTrace()));
        }

        return connection;
    }
}
