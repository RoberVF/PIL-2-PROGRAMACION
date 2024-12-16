
package codigo;


import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/saludos")
public class RecursoSaludos {

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String getText(@QueryParam("nombre") String alias) {
        return "<h1>Hello " + alias + " World :) !! </h1>";
    }
   
    @GET
    @Path("/hello2")
    @Produces("text/html")
    public String getText2() {
        return "<h1>Hello World :) !! </h1>";
    }
    
}
