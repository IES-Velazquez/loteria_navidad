package velazquez.loteria_navidad.utils;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import velazquez.loteria_navidad.models.Numero;
import velazquez.loteria_navidad.models.Premiado;
import velazquez.loteria_navidad.models.User;

import java.util.ArrayList;

//Para acceder a a la API es necesario incluir el path de la aplicación +/rest/json/* y el servicio al que se quiera acceder

@Path("/json")
public class BoletosResources {
//    Retoma los 4 primeros premiados
    @Path("/resumen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response resume(){
//        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Premiado> premiados = new ArrayList<>();
        premiados.add(new Premiado("23234", 1, 234.34));
        premiados.add(new Premiado("23562", 2, 134.34));
        premiados.add(new Premiado("99823", 3, 34.34));
        premiados.add(new Premiado("23", 4, 4.34));

        Gson gson = new Gson();
        String jsonString = gson.toJson(premiados);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }

//    Recibe un list comn
    @Path("/premiado")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response premiado(){
        /*
        Este bloque también es provicional, ya que no se ha decidido la estructura
        de los modelos para este parámetro.

        Lo fundamental es que debe recibir un json con un array de objetos con los números que se quieran comprobar, estos luego se comprueban con la Api del Pais.Us
         */
        System.out.println("llega");
        ArrayList<Premiado> premiados = new ArrayList<>();
        premiados.add(new Premiado("23234", 1, 234.34));
        premiados.add(new Premiado("23562", 2, 134.34));
        premiados.add(new Premiado("99823", 3, 34.34));
        premiados.add(new Premiado("23", 4, 4.34));

        Gson gson = new Gson();
        String jsonString = gson.toJson(premiados);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }

    /*
    Este método devuelve todos los usuarios en formato json

    El model de user está por hacer
     */
    @Path("/users_list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        //bloque provisional hasta que se cree el dao
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("manolo"));

        Gson gson = new Gson();
        String jsonString = gson.toJson(users);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }

    /*
    Este bloque recibe objeto Json User y devuelve una lista
    de los boletos que tiene
     */
    @Path("/user_boletos")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response userBoletos(User user){

        System.out.println(user);
//        Premiado premiado = new Premiado("234");
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(premiado);
//        return Response.status(Response.Status.OK).entity(jsonString).build();




        //        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Premiado> premiados = new ArrayList<>();
        premiados.add(new Premiado("23234", 1, 234.34));
        premiados.add(new Premiado("23562", 2, 134.34));
        premiados.add(new Premiado("99823", 3, 34.34));
        premiados.add(new Premiado("23", 4, 4.34));

        Gson gson = new Gson();
        String jsonString = gson.toJson(premiados);
        return Response.status(Response.Status.OK).entity(jsonString).build();
    }
    /*
    Este bloque recibe un premiado con solo el id del boleto y devuelve los boletos que quedan por vender
     */
    @Path("/boletos_avaliable")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkNumber(Numero boleto){


        System.out.println(boleto);
        //        Este bloque sirve como template para probar la api hasta que se haga el resto
        ArrayList<Premiado> premiados = new ArrayList<>();
        premiados.add(new Premiado("23234", 1, 234.34));
        premiados.add(new Premiado("23562", 2, 134.34));
        premiados.add(new Premiado("99823", 3, 34.34));
        premiados.add(new Premiado("23", 4, 4.34));

        Gson gson = new Gson();
        String jsonString = gson.toJson(premiados);
        return Response.status(Response.Status.OK).entity(jsonString).build();


    }
}
