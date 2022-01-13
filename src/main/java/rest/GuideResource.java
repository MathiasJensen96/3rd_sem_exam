package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.GuideFacade;
import facades.TripFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("guide")
public class GuideResource {

    private static final EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final GuideFacade guideFacade = GuideFacade.getGuideFacade(emf);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public Response getAllTrips() {
        return Response.ok(gson.toJson(guideFacade.getAllGuides()), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Response getGuideByName(@PathParam("name") String name) {
        return Response.ok(gson.toJson(guideFacade.getGuideFromName(name)), MediaType.APPLICATION_JSON).build();
    }
}
