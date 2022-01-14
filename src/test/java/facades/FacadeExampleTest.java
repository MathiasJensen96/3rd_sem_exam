package facades;

import entities.Guide;
import entities.Role;
import entities.Trip;
import entities.User;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = UserFacade.getUserFacade(emf);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from User").executeUpdate();
            em.createQuery("delete from Role").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.createQuery("delete from User").executeUpdate();
//            em.createQuery("delete from Role").executeUpdate();
//        } finally {
//            em.close();
//        }
//    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
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
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void getAllUsersTest() {
        String actual = facade.getAllUsers();
        String expected = "[2]";
        assertEquals(expected, actual);
    }

}
