package velazquez.loteria_navidad.utils;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez.loteria_navidad.dao.DAODecimoImpl;
import velazquez.loteria_navidad.models.Decimo;
import velazquez.loteria_navidad.models.Premiado;
import velazquez.loteria_navidad.models.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Para acceder a a la API es necesario incluir el path de la aplicación +/rest/json/* y el servicio al que se quiera acceder
 */
@Path("/json")
public class BoletosResources {
    static final Logger logger = LoggerFactory.getLogger(BoletosResources.class);
    /*
    Retoma los 4 primeros premiados
     */
    @Path("/resumen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response resume(){
//        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Premiado> premiados = new ArrayList<>();
        premiados.add(new Premiado(23234, 1, 234.34));
        premiados.add(new Premiado(23562, 2, 134.34));
        premiados.add(new Premiado(99823, 3, 34.34));
        premiados.add(new Premiado(23, 4, 4.34));

        Gson gson = new Gson();
        String jsonString = gson.toJson(premiados);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }

    /*
    Recibe un list de Premiados y devuelve ese mismo list con los datos de premios y posicion

    EJ:
        Request:
        [{"numero" :23234}, {"numero": 23562}]

        Response:
        [{"numero": 23234,"position":1,"premio":234.34},{"numero": 23562,"position":2,"premio":134.34}]

    Nota: por supuesto, este mismo servicio se puede utilizar para comprobar un
    único boleto
     */
    @Path("/premiado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response premiado(List<Premiado> to_check){
        /*
        Lo fundamental es que debe recibir un json con un array de objetos con los números que se quieran comprobar, estos luego se comprueban con la Api del Pais.Us
        La respuesta del método es provisional hasta terminar el DAO
         */
        System.out.println(to_check);

        //provisional
        for(Premiado pre: to_check){
            pre.setPosition(1);
            pre.setPremio(1000000);
        }
        Gson gson = new Gson();
        String jsonString = gson.toJson(to_check);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }

    /*
    Este bloque recibe objeto Json Usuario y devuelve una lista
    de los boletos que tiene

    Solo es necesario construirlo con el atributo usuario

    EJ:
        Request:
        {"usuario": "manolo"}
     */
    @Path("/user_boletos")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response userBoletos(Usuario user){

        System.out.println(user);
        //        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Decimo> decimos = new ArrayList<>();
        decimos.add(new Decimo(1234, "alguno", 1, "fraccion", "serie", "manolo"));
        Gson gson = new Gson();
        String jsonString = gson.toJson(decimos);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }
    /*
    Este bloque recibe un Usuario, solo atributo usuario, y devuelve el usuario con
    todos sus atributos
     */
    @Path("/user_data")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response userData(Usuario usuario){
        //Template
        usuario.setNombre("manolo");
        usuario.setPass("sfsdf");
        usuario.setRole("user");
        Gson gson = new Gson();
        String jsonString = gson.toJson(usuario);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }


    /*
    Este bloque recibe un Decimo objeto con solo el id del decimo y comprueba
    cuantos hay para comprobar
    La forma en la que se devuelve no se ha concretado todavía

    EJ:
        REQUEST:
        {"numero": 234534}
     */
    @Path("/boletos_avaliable")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkNumber(Decimo boleto){

        DAODecimoImpl daoDecimo = new DAODecimoImpl();
        int cantidad = daoDecimo.availableDecimos(boleto.getNumero());
        //        Este bloque sirve como template para probar la api hasta que se haga el resto
//        ArrayList<Premiado> premiados = new ArrayList<>();
//        premiados.add(new Premiado(23234, 1, 234.34));
//        premiados.add(new Premiado(23562, 2, 134.34));
//        premiados.add(new Premiado(99823, 3, 34.34));
//        premiados.add(new Premiado(23, 4, 4.34));
//
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(premiados);
//        return Response.status(Response.Status.OK).entity(jsonString).build();
        Map respuesta = new HashMap<>();
        respuesta.put("cantidad", cantidad);
        respuesta.put("numero", boleto.getNumero());
        Gson gson = new Gson();
        String jsonString = gson.toJson(respuesta);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }
    /*
    Este bloque anade un Decimo, se debe enviar con todos los parametros

    Se debe decidir si no envía nada o si se le pasan parámetros al cliente
     */
    @Path("/boleto_add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addBoleto(Decimo decimo){
        //Dao por hacer
    }
    /*
    Este bloque borra un Decimo, es necesario pasar los atributos de numero y usuario
     */
    @Path("/boleto_delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBoleto(Decimo decimo){
        //dao por hacer
    }

    /*
    Este método devuelve todos los usuarios en formato json

     */
    @Path("/users_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        //bloque provisional hasta que se cree el dao
        ArrayList<Usuario> users = new ArrayList<>();
        users.add(new Usuario("manolo", "xxxxx", "admin", "manolo lamas"));

        Gson gson = new Gson();
        String jsonString = gson.toJson(users);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }
    /*
    Devuelve todos los boletos
     */
    @Path("/boletos_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBoletos(){
        //        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Decimo> decimos = new ArrayList<>();
        decimos.add(new Decimo(1234, "alguno", 1, "fraccion", "serie", "manolo"));
        Gson gson = new Gson();
        String jsonString = gson.toJson(decimos);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }
    /*
    Este bloque borra un usuario, debe llegar el atributo usuario
     */
    @Path("/user_delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(Usuario usuario){
        //dao por hacer
    }
}
