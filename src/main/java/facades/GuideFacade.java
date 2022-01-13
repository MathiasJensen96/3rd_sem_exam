package facades;

import dtos.GuideDTO;
import dtos.GuidesDTO;
import dtos.TripsDTO;
import entities.Guide;
import entities.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class GuideFacade {

    private static EntityManagerFactory emf;
    private static GuideFacade instance;

    public GuideFacade() {
    }

    public static GuideFacade getGuideFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GuideFacade();
        }
        return instance;
    }

    public GuidesDTO getAllGuides() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Guide> query = em.createQuery("SELECT g FROM Guide g", Guide.class);
        List<Guide> guides = query.getResultList();
        //System.out.println(trips.toString());
        GuidesDTO g = new GuidesDTO(guides);
        //System.out.println(t.getAll());
        return g;
    }

    public GuideDTO getGuideFromName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("SELECT g FROM Guide g WHERE g.name =:name", Guide.class);
        query.setParameter("name", name);
        Guide guide = (Guide) query.getSingleResult();
        GuideDTO g = new GuideDTO(guide);
        return g;
    }
}