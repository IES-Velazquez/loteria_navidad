package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.models.Decimo;
import velazquez.loteria_navidad.models.Usuario;

import java.util.ArrayList;

public interface DAODecimo {
    public boolean createDecimo(Decimo decimo);
    public boolean deleteDecimo(Decimo decimo);
    public int availableDecimos(int numero);
    public ArrayList<Decimo> decimosFromUser(Usuario usuario);
    public int numDecimosFromUser(Decimo decimo);
}
