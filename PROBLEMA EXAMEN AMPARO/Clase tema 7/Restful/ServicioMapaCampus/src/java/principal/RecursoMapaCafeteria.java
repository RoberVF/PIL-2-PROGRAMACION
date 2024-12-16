
package principal;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/informacion")
public class RecursoMapaCafeteria {

    @GET
    @Path("/cafeterias")
    @Produces("image/jpg")
    public Response getMpaCafeterias(@QueryParam("nombre") String cafeteria) throws Exception{
        String localizacion = "";
        switch (cafeteria) {
            case "Telecomunicacion":
                localizacion = "28.070900,-15.454100";
                break;
           case "Arquitectura":
                localizacion = "28.072633,-15.453946";
                break;
            case "Industriales":
                localizacion = "28.069700,-15.455946";
                break;
        }
        URL url = new URL(crearUrlServicioGoogleMap(localizacion));
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        return Response.ok(outputStream.toByteArray()).build();

    }
    
    private String crearUrlServicioGoogleMap(String ubicacionCaf) {
        String url = "http://maps.googleapis.com/maps/api/staticmap";
        String centro = "?center=28.071029,-15.453446";
        String zoom = "&zoom=17";
        String medida = "&size=800x500";
        String tipo = "&maptype=satellite";
        String waypoint = "&markers=color:red|label:T|" + ubicacionCaf;
        String key ="&key=AIzaSyA9Rk4rCltmFYQQVFViOSqpBL0AEVjF8i4";
        return url+centro+zoom+medida+tipo+waypoint+key;
    }
    
}
