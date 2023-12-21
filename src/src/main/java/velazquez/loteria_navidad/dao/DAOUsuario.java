package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.models.Usuario;

public interface DAOUsuario {
    public boolean register(String user, String password, String nombre);

    public Usuario getUsuario(String usuario);

    public boolean deleteUsuario(Usuario usuario);
}
