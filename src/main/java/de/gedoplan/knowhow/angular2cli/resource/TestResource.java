package de.gedoplan.knowhow.angular2cli.resource;

import de.gedoplan.knowhow.angular2cli.model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("test")
@Consumes("application/json")
@Produces("application/json")
public class TestResource {

    @GET
    public User getTest() {
        return new User();
    }

}
