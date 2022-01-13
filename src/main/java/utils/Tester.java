package utils;

import facades.TripFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TripFacade tripFacade = TripFacade.getTripFacade(emf);

        //TripFacade.getTripFacade(emf).getAllTrips();
        tripFacade.getGuideFromTripID(1);
    }
}
