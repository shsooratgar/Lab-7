package Test;

import Core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AirlineTest {
    static Airline myairline;
    static Plane myplane;
    static Seat seat1;
    static Seat seat2;
    static Seat seat3;
    static ArrayList<Seat> seats = new ArrayList<>();
    static Flight myflight;
    static Customer ali;

    @BeforeAll
    public static void createAirline() {
        myplane = new Plane("gg", 2, seats);
        seat1 = new Seat(1, "first", myplane);
        seat2 = new Seat(2, "economic", myplane);
        seat3 = new Seat(3, "buisiness", myplane);
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        myplane = new Plane("gg", 2, seats);
        ali = new Customer("ali", "Fellani", 23);
        myflight = new Flight(myplane, 1, 2, 4, 20, 45, "SS");
        myairline = new Airline();


    }


    @Test
    public void test1() {
        myairline.addFlights(myflight);
        myairline.addCustomers(ali);

       ali.addticket(myflight.getPlane().getTotalseats().get(0), myflight, 20, true);
        //assert (ali.getTickets().get(0).isFood());
    }


    @Test
    public void test2() {
        myairline.addFlights(myflight);
        myairline.addCustomers(ali);
        ali.addticket(myflight.getPlane().getTotalseats().get(1), myflight, 20, true);
        seats.remove(seat1);
        Assertions.assertEquals(myairline.getFlights().get(0).getPlane().getFreeSeats() ,seats );}

        @Test
        public void test3(){
            myairline.addFlights(myflight);
            myairline.addCustomers(ali);
            ali.addticket(myflight.getPlane().getTotalseats().get(0), myflight, 20, true);

            // Assertions.assertNull(myflight.getPlane().getTotalseats().get(0).getCustomer());
            Assertions.assertEquals("ali" ,myflight.getPlane().getTotalseats().get(0).getCustomer().getName());
        }
    }


