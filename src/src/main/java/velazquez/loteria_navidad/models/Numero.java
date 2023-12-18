package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Numero implements Serializable {
    private String bol_num;

    public Numero(String bol_num) {
        this.bol_num = bol_num;
    }

    public String getBol_num() {
        return bol_num;
    }

    public void setBol_num(String bol_num) {
        this.bol_num = bol_num;
    }

    @Override
    public String toString() {
        return "{" +
                "bol_num='" + bol_num + '\'' +
                '}';
    }
}
