class Car {
    int id;
    String model;
    String type;
    int price;
    boolean available = true;

    Car(int id, String model, String type, int price) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.price = price;
    }
}

class Fleet {
    Car[] cars = {
        new Car(101, "Honda City", "Sedan", 150),
        new Car(102, "Creta", "SUV", 250),
        new Car(103, "Verna", "Sedan", 180)
    };

    void showFleet() {
        System.out.println("\n--- Fleet ---");

        for (int i = 0; i < cars.length; i++) {
            System.out.println(
                cars[i].id + " " +
                cars[i].model + " " +
                cars[i].type + " Rs." +
                cars[i].price + "/hour " +
                (cars[i].available ? "Available" : "Rented")
            );
        }
    }
}

public class FleetManager {
    public static void main(String[] args) {
        Fleet f = new Fleet();
        f.showFleet();
    }
}
