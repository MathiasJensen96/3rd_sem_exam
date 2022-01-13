package utils;


import entities.Guide;
import entities.Role;
import entities.Trip;
import entities.User;
import facades.TripFacade;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    User user = new User("Mathias", "testHest", "Æblegade 8", 11111111, "Mathias@cphbusiness.dk", 1996, "male");
    User admin = new User("Jon", "testHest", "Mortensgade 97", 22222222, "Jon@cphbusiness.dk", 1965, "male");
    Trip trip = new Trip("Grand Canyon Tour", "Jan. 31st", "8 am", "Hotel Lobby", "Full day", "Packing List URL" );
    Trip trip1 = new Trip("Skiing in Chamonix", "Feb. 7th", "7.30 am", "Local bus stop", "7 days", "Packing List URL" );
    Guide guide = new Guide("Sofus", "male", 1993, "Profile URL", "image URL");
    Guide guide1 = new Guide("Æske", "male", 1991, "Profile URL", "image URL");

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    user.addTrip(trip);
    user.addTrip(trip1);
    trip.setGuide(guide);
    trip1.setGuide(guide1);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(trip);
    em.persist(trip1);
    em.persist(guide);
    em.persist(guide1);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("testHest"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
  }
}
