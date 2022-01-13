package facades;

import dtos.TripsDTO;
import entities.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TripFacade {

    private static EntityManagerFactory emf;
    private static TripFacade instance;

    public TripFacade() {
    }

    public static TripFacade getTripFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }

    public TripsDTO getAllTrips() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Trip> query = em.createQuery("SELECT t FROM Trip t", Trip.class);
        List<Trip> trips = query.getResultList();
        //System.out.println(trips.toString());
        TripsDTO t = new TripsDTO(trips);
        //System.out.println(t.getAll());
        return t;
    }

    public String getGuideFromTripID(long id) {
        EntityManager em = emf.createEntityManager();
        Trip trip = em.find(Trip.class, id);
        if (trip == null) {
            System.out.println("no trip with that id");
        } else {
            System.out.println(trip.getGuide().getName());
        }
        return trip.getGuide().getName();
    }
}