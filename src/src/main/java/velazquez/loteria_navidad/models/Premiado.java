package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Premiado implements Serializable {
    private String bol_num;
    private int position;
    private double premio;

    public Premiado(String bol_num, int position, double premio) {
        this.bol_num = bol_num;
        this.position = position;
        this.premio = premio;
    }

    public String getBol_num() {
        return bol_num;
    }

    public void setBol_num(String bol_num) {
        this.bol_num = bol_num;
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
                "bol_num='" + bol_num + '\'' +
                ", position=" + position +
                ", premio=" + premio +
                '}';
    }
}
