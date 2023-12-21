package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.models.Decimo;

public interface DAODecimo {
    public boolean createDecimo(Decimo decimo);
    public boolean deleteDecimo(Decimo decimo);
    public int availableDecimos(int numero);
    public int decimosFromUser(Decimo decimo);
}
