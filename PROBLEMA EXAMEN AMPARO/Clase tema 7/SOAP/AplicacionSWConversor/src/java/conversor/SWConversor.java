
package conversor;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "SWConversor")
public class SWConversor {

    
    @WebMethod(operationName = "grad2rad")
    public double hello(@WebParam(name = "ang") double angulo) {
        return angulo*Math.PI/180;
    }
    
    @WebMethod(operationName = "tipoang")
    public String tipoang(@WebParam(name = "ang") double angulo) {
        if (angulo < 90) 
            return "agudo";
        if (angulo == 90)
            return "recto";
        if (angulo > 90)
            return "obtuso";
        return null;
        
        
    }
    
    @WebMethod(operationName = "angsup1")
    public double angsup1(@WebParam(name = "ang") double angulo) {
        return 180 - angulo;
    }
    
}
