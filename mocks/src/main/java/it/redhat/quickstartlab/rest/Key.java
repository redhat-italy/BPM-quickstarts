package it.redhat.quickstartlab.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/key")
public class Key {

    private static final Logger logger = Logger.getLogger("it.redhat.quickstartlab");

    @GET
    public String getInfo() {
        return "Mock REST service to simulate External System";
    }

    @GET
    @Produces("text/plain")
    @Path("/generate")
    public Response generate(@QueryParam("size") String size) {
        int keysize = 6;
        if (size != null && size.length() > 0){
            keysize = Integer.parseInt(size);
        }
        String theKey = it.redhat.quickstartlab.util.Key.generate(keysize);
        logger.info("[Key Service] new key generated: " + theKey );
        return Response.status(Response.Status.OK).entity(theKey).build();
    }

}