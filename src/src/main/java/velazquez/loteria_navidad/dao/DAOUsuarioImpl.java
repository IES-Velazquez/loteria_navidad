package velazquez.loteria_navidad.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.db.PoolDBContext;
import velazquez.loteria_navidad.models.Usuario;

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

    @Override
    public Usuario getUsuario(String usuario) {
        Connection con;
        Usuario objetoUsuario = null;

        try {
            String sql = "SELECT * FROM Usuarios WHERE usuario=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, usuario);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String user = rs.getString("usuario");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String nombre = rs.getString("nombre");

                objetoUsuario = new Usuario(user, pass, role, nombre);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return objetoUsuario;
    }
}
