package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.sf.jasperreports.engine.JRException;

import java.util.HashMap;

@Path("/hello")
public class GreetingResource {

    @Inject
    DataProcessingUtility dataProcessingUtility;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @Path("/pdf")
    @GET
    @Produces("application/pdf")
    public byte[] hellod() throws Exception {
        return dataProcessingUtility.generateJasperReport();
    }
}
