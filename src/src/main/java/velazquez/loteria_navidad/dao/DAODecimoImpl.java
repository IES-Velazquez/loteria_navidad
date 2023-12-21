package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.db.PoolDBContext;
import velazquez.loteria_navidad.models.Decimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.models.Usuario;

public class DAODecimoImpl implements DAODecimo {
    static final Logger logger = LoggerFactory.getLogger(DAODecimoImpl.class);
    @Override
    public boolean createDecimo(Decimo decimo) {
        boolean success = false;
        String sql = null;
        PreparedStatement statement = null;
        int available = availableDecimos(decimo.getNumero());
        int availableAfterPurchase = available - decimo.getCantidad();

        // se verifica que existan décimos suficientes para realizar la operación
        if (availableAfterPurchase < 0) {
            logger.error("No se puede comprar más de 20 décimos de un mismo número");
            return false;
        }

        PoolDBContext pool = new PoolDBContext();
        Connection con = pool.getConnection();
        DAOUsuarioImpl daoUsuario = new DAOUsuarioImpl();
        Usuario usuario = daoUsuario.getUsuario(decimo.getUsuario());

        // ya existen décimos para el usuario indicado (update)
        if (numDecimosFromUser(decimo) > 0) {
            try {
                sql = "UPDATE FROM Decimos " +
                        "SET cantidad=? " +
                        "WHERE numero=? AND usuario=?;";
                statement = con.prepareStatement(sql);
                statement.setInt(1, (numDecimosFromUser(decimo)+decimo.getCantidad()));
                statement.setInt(2, decimo.getNumero());
                statement.setString(3, decimo.getUsuario());

                statement.execute();
                success = true;

                statement.close();
                con.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            // no existen décimos para el usuario indicado (insert)
            try {
                sql = "INSERT INTO Decimos (numero, grupo, cantidad, fraccion, serie, usuario) VALUES (?.?.?.?,?,?)";
                statement = con.prepareStatement(sql);
                statement.setInt(1, decimo.getNumero());
                statement.setString(2, decimo.getGrupo());
                statement.setInt(3, decimo.getCantidad());
                statement.setString(4, decimo.getFraccion());
                statement.setString(5, decimo.getSerie());
                statement.setString(6, decimo.getUsuario());

                statement.execute();
                success = true;

                statement.close();
                con.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return success;
    }

    @Override
    public boolean deleteDecimo(Decimo decimo) {
        Connection con = null;
        boolean success = false;

        try {
            String sql = "DELETE FROM Decimos WHERE numero=? AND usuario=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, decimo.getNumero());
            statement.setString(2, decimo.getUsuario());

            statement.execute();
            success = true;

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return success;
    }

    @Override
    public ArrayList<Decimo> getDecimos() {
        Connection con = null;
        ArrayList<Decimo> decimos = null;
        try {
            String sql = "SELECT * FROM Decimos";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            Decimo decimo;
            int numero;
            String grupo;
            int cantidad;
            String fraccion;
            String serie;
            String user;
            decimos = new ArrayList<>();
            while (rs.next()) {
                numero = rs.getInt("numero");
                grupo = rs.getString("grupo");
                cantidad = rs.getInt("cantidad");
                fraccion = rs.getString("fraccion");
                serie = rs.getString("serie");
                user = rs.getString("usuario");

                decimo = new Decimo(numero,grupo,cantidad,fraccion,serie,user);
                decimos.add(decimo);
            }

            statement.close();

        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            try{
                if(con!=null){
                    con.close();
                }
            }catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public int availableDecimos(int numero) {
        Connection con;
        final int LIMITE = 20;
        int restantes = 0;

        try {
            String sql = "SELECT SUM(cantidad) FROM Decimos WHERE numero=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, numero);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                restantes = LIMITE - rs.getInt(1);
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return restantes;
    }

    @Override
    public ArrayList<Decimo> decimosFromUser(Usuario usuario) {
        Connection con = null;
        ArrayList<Decimo> decimos = new ArrayList<Decimo>();

        try {
            String sql = "SELECT * FROM Decimos AND usuario=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, usuario.getUsuario());

            ResultSet rs = statement.executeQuery();

            Decimo decimo;
            int numero;
            String grupo;
            int cantidad;
            String fraccion;
            String serie;
            String user;

            while (rs.next()) {
                numero = rs.getInt("numero");
                grupo = rs.getString("grupo");
                cantidad = rs.getInt("cantidad");
                fraccion = rs.getString("fraccion");
                serie = rs.getString("serie");
                user = rs.getString("usuario");

                decimo = new Decimo(numero,grupo,cantidad,fraccion,serie,user);
                decimos.add(decimo);
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return decimos;
    }

    @Override
    public int numDecimosFromUser(Decimo decimo) {
        Connection con = null;
        int numBoletos = 0;

        try {
            String sql = "SELECT cantidad FROM Decimos WHERE numero=? AND usuario=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, decimo.getNumero());
            statement.setString(2, decimo.getUsuario());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                numBoletos = rs.getInt(1);
            }

            statement.close();
            con.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return numBoletos;
    }
}
