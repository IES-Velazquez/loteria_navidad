package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String usuario;
    private String pass;
    private String role;
    private String nombre;

    public Usuario(String usuario, String pass, String role, String nombre) {
        this.usuario = usuario;
        this.pass = pass;
        this.role = role;
        this.nombre = nombre;
    }

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
