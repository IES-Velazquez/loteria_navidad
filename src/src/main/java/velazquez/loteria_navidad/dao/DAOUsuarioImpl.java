package velazquez.loteria_navidad.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.db.PoolDBContext;
import velazquez.loteria_navidad.models.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class DAOUsuarioImpl implements DAOUsuario{
    static final Logger logger = LoggerFactory.getLogger(DAOUsuarioImpl.class);

    @Override
    public boolean register(String user, String password, String nombre) {
        boolean success = false;
        Connection con = null;

        try {
            String sql = "INSERT INTO Usuarios VALUES (?, ?, 'user', ?)";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, user);
            statement.setString(2, password);
            statement.setString(3, nombre);

            ResultSet rs = statement.executeQuery();
            success = true;

            statement.close();
            con.close();
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

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return objetoUsuario;
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Connection con;
        Usuario usuario = null;

        try {
            String sql = "SELECT * FROM Usuarios";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String user = rs.getString("usuario");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String nombre = rs.getString("nombre");

                usuario = new Usuario(user, pass, role, nombre);
                usuarios.add(usuario);
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return usuarios;
    }

    public boolean deleteUsuario(Usuario usuario){
        boolean success = false;
        Connection con;

        try {
            String sql = "DELETE FROM Usuarios WHERE usuario = ?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, usuario.getUsuario());

            statement.execute();
            success = true;

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    return success;
    }
}
