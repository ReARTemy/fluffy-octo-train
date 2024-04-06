package org.donstu.controllers;

import org.donstu.domain.Master;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/master")
public class MasterController {
    private static List<Master> masters = new ArrayList<>();
    static {
        masters.add(new Master("Ivan", 5, 1000));
        masters.add(new Master("Petr", 10, 2000));
        masters.add(new Master("Alexey", 15, 3000));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getMasters();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMasters() {
        GenericEntity<List<Master>> genericEntity = new GenericEntity<List<Master>>(masters) {};
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMaster(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (masters.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(masters.get(num)).build();
        }
    }
}
