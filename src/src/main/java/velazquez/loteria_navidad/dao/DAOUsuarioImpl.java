package velazquez.loteria_navidad.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.db.PoolDBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarioImpl implements DAOUsuario{
    static final Logger logger = LoggerFactory.getLogger(DAOUsuarioImpl.class);

    @Override
    public boolean register(String user, String password, String nombre) {
        boolean success = false;
        Connection con;

        try {
            String sql = "INSERT INTO Usuarios VALUES (?, ?, 'user', ?)";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, user);
            statement.setString(2, password);
            statement.setString(3, nombre);

            statement.execute();
            success = true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return success;
    }
}
