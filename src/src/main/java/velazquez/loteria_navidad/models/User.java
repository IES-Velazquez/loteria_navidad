package velazquez.loteria_navidad.models;

import com.google.gson.annotations.JsonAdapter;
import org.glassfish.jersey.server.JSONP;

import java.io.Serializable;

public class User implements Serializable {
    private String user;

    public User(String user) {
        this.user = user;
    }
    public User(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
                "user='" + user + '\'' +
                '}';
    }
}
