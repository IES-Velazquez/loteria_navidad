package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Decimo implements Serializable {
    private int numero;
    private String grupo;
    private int cantidad;
    private String fraccion;
    private String serie;
    private String usuario;

    public Decimo(int numero, String grupo, int cantidad, String fraccion, String serie, String usuario) {
        this.numero = numero;
        this.grupo = grupo;
        this.cantidad = cantidad;
        this.fraccion = fraccion;
        this.serie = serie;
        this.usuario = usuario;
    }

    public Decimo() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        this.fraccion = fraccion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Decimo{" +
                "numero=" + numero +
                ", grupo='" + grupo + '\'' +
                ", cantidad=" + cantidad +
                ", fraccion='" + fraccion + '\'' +
                ", serie='" + serie + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
