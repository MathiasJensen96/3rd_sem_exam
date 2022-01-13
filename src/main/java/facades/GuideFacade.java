//package facades;
//
//import dtos.TripsDTO;
//import entities.Guide;
//import entities.Trip;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class GuideFacade {
//
//    private static EntityManagerFactory emf;
//    private static GuideFacade instance;
//
//    public GuideFacade() {
//    }
//
//    public static GuideFacade getGuideFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new GuideFacade();
//        }
//        return instance;
//    }
//
//    public TripsDTO getAllGuides() {
//        EntityManager em = emf.createEntityManager();
//        TypedQuery<Guide> query = em.createQuery("SELECT g FROM Guide g", Guide.class);
//        List<Guide> guides = query.getResultList();
//        //System.out.println(trips.toString());
//        TripsDTO t = new TripsDTO(trips);
//        //System.out.println(t.getAll());
//        return t;
//    }
//
//    public String getGuideFromTripID(long id) {
//        EntityManager em = emf.createEntityManager();
//        Trip trip = em.find(Trip.class, id);
//        if (trip == null) {
//            System.out.println("no trip with that id");
//        } else {
//            System.out.println(trip.getGuide().getName());
//        }
//        return trip.getGuide().getName();
//    }
//}
