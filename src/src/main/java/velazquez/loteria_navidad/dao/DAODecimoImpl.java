package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.db.PoolDBContext;
import velazquez.loteria_navidad.models.Decimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAODecimoImpl implements DAODecimo {
    static final Logger logger = LoggerFactory.getLogger(DAODecimoImpl.class);
    @Override
    public boolean createDecimo(Decimo decimo) {
        // TODO
        return false;
    }

    @Override
    public boolean deleteDecimo(Decimo decimo) {
        // TODO 
        return false;
    }

    @Override
    public int availableDecimos(int numero) {
        Connection con;
        final int LIMITE = 20;
        int restantes = 0;

        try {
            String sql = "SELECT ?-SUM(cantidad) FROM Decimos WHERE numero=?";
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, LIMITE);
            statement.setInt(2, numero);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                restantes = rs.getInt(1);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return restantes;
    }
}
