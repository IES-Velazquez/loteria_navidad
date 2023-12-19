package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Premiado implements Serializable {
    private int numero;
    private int position;
    private double premio;

    public Premiado(int numero, int position, double premio) {
        this.numero = numero;
        this.position = position;
        this.premio = premio;
    }
    public Premiado(){}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Premiado{" +
                "numero=" + numero +
                ", position=" + position +
                ", premio=" + premio +
                '}';
    }
}
