interface HotelService {
    void executeService(String request);
}

class Valet implements HotelService {
    @Override
    public void executeService(String plateNumber) {
        pickUpVehicle(plateNumber);
    }

    public void pickUpVehicle(String plateNumber) {
        System.out.println("\nValet service: Picking up vehicle with plate number " + plateNumber);
    }
}

class HouseKeeping implements HotelService {
    @Override
    public void executeService(String roomNumber) {
        cleanRoom(roomNumber);
    }

    public void cleanRoom(String roomNumber) {
        System.out.println("Housekeeping service: Cleaning room number " + roomNumber);
    }
}

class Cart implements HotelService {
    @Override
    public void executeService(String numberOfCarts) {
        requestCart(Integer.parseInt(numberOfCarts));
    }

    public void requestCart(int numberOfCarts) {
        System.out.println("Cart service: Delivering " + numberOfCarts + " luggage cart(s)");
    }
}

class FrontDesk {
    private Valet valet;
    private HouseKeeping houseKeeping;
    private Cart cart;

    public FrontDesk() {
        this.valet = new Valet();
        this.houseKeeping = new HouseKeeping();
        this.cart = new Cart();
    }

    public void requestValet(String plateNumber) {
        valet.executeService(plateNumber);
    }

    public void requestHouseKeeping(String roomNumber) {
        houseKeeping.executeService(roomNumber);
    }

    public void requestCart(String numberOfCarts) {
        cart.executeService(numberOfCarts);
    }
}

public class HotelApp {
    public static void main(String[] args) {
        FrontDesk frontDesk = new FrontDesk();

        frontDesk.requestValet("ABC123");
        frontDesk.requestHouseKeeping("101");
        frontDesk.requestCart("2");
    }
} 
