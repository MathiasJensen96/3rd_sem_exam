package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Guide;
import facades.TripFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("trip")
public class TripResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final TripFacade tripFacade = TripFacade.getTripFacade(emf);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public Response getAllTrips() {
        return Response.ok(gson.toJson(tripFacade.getAllTrips()), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("guide/{id}")
    public String getGuideName(@PathParam("id") long id) {
        return tripFacade.getGuideFromTripID(id);
    }
}
