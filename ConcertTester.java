/*You are given the Audience class. You need to design the Concert (Parent) and VIPConcert (Child) classes so that the following tester code generates the desired output.
Hint: Assume a maximum of 5 artists can be added to a concert. 
Ticket Pricing:
1. Zone A: 500 per ticket
2. Zone B: 1,000 per ticket
3. Zone VIP: 2,000 per ticket
 */

public class ConcertTester { // Driver code
    public static void main(String[] args) {
        Concert concert = new Concert("ABC Conference Center", "7:00 PM");
        concert.showDetails();
        System.out.println("--------1--------");
        concert.addArtist("Tahsan Khan");
        concert.addArtist("Habib Wahid");
        concert.showDetails();
        System.out.println("--------2--------");
        Audience a1 = new Audience("Sarah");
        Audience a2 = new Audience("Alex");
        System.out.println("--------3--------");
        a1.buyConcertTicket(concert, "A", 3);
        a2.buyConcertTicket(concert, "B");
        System.out.println("--------4--------");
        concert.showDetails();
        System.out.println("--------5--------");
        VIPConcert vipConcert = new VIPConcert("Army Stadium", "10:00 PM");
        vipConcert.addArtist("Atif Aslam");
        Audience a3 = new Audience("Emily");
        a3.buyConcertTicket(vipConcert);
        System.out.println("--------6--------");
        vipConcert.showDetails();
        System.out.println("--------7--------");
        ;
        Concert.showTotalTicketsSold();
    }
}

// Class starts here

class Audience { // Tester class
    private String name;

    public Audience(String name) {
        this.name = name;
    }

    public void buyConcertTicket(Concert concert, String zone, int quantity) {
        System.out.println(name + " bought " + quantity + " ticket(s) in Zone " + zone);
        concert.buyTicket(zone, quantity);
    }

    public void buyConcertTicket(Concert concert, String zone) {
        System.out.println(name + " bought 1 ticket(s) in Zone " + zone);
        concert.buyTicket(zone);
    }

    public void buyConcertTicket(VIPConcert concert) {
        System.out.println(name + " bought 1 ticket(s) in Zone VIP");
        concert.buyTicket();
    }
}

class Concert { // Parent class
    public String venue;
    public String showtime;
    public String[] artists = new String[5];
    public int count;
    public int total_tickets;
    public static int total_tickets_venues;
    public String zone;
    public int price;
    public int total_price;

    public Concert(String venue, String showtime) {
        this.venue = venue;
        this.showtime = showtime;
    }

    public void addArtist(String name) {
        if (count < artists.length) {
            artists[count] = name;
            count++;
        } else {
            return;
        }
    }

    public void buyTicket(String zone, int quantity) {
        this.zone = zone;
        if (zone.equals("A")) {
            price = 500;
            total_price = quantity * price;
            System.out.println("Total price: " + total_price);
            total_tickets += quantity;
            total_tickets_venues += quantity;
        }

        else if (zone.equals("B")) {
            price = 1000;
            total_price = price * quantity;
            System.out.println("Total price: " + total_price);
            total_tickets += quantity;
            total_tickets_venues += quantity;
        } else {
            price = 2000;
            total_price = price * quantity;
            System.out.println("Total price: " + total_price);
            total_tickets += quantity;
            total_tickets_venues += quantity;
        }
    }

    public void buyTicket(String zone) {
        buyTicket(zone, 1);
    }

    public void buyTicket() {
        buyTicket("VIP", 1);
    }

    public void showDetails() {
        System.out.println("Venue: " + venue);
        System.out.println("Showtime: " + showtime);
        System.out.println("Artist: ");

        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println("-" + artists[i]);
            }
        }

        System.out.println("Tickets sold in this concert: " + total_tickets);
    }

    public static void showTotalTicketsSold() {
        System.out.println("Total tickets sold (all venues): " + total_tickets_venues);
    }
}

class VIPConcert extends Concert { // Child class
    public VIPConcert(String venue, String showtime) {
        super(venue, showtime);
    }

    public void buyTicket(String zone, int q) {
        super.buyTicket(zone, q);
    }

    public void addArtist(String name) {
        super.addArtist(name);
    }

    public void showDetails() {
        super.showDetails();
    }
}
