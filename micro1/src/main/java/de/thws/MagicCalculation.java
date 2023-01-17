package de.thws;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("calc")
public class MagicCalculation {


    @GET
    public Integer calc(@QueryParam("in") @DefaultValue("0") Integer in) {
        return in * 123;
    }
    
}
