package test4;
public class VehicleFactory {
    private VehicleFactory() {
    }
    public static TransportVehicle createVehicle(String type) {
        if (type == null) {
            return null;
        }
        switch (type) {
            case "Truck":
                return new Truck("T-" + (System.currentTimeMillis() % 1000));
            case "Drone":
                return new Drone("D-007");
            default:
                return null;
        }
    }
}
