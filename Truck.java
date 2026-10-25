package test4;

public class Truck extends TransportVehicle {

    public Truck(String id) {
        super(id);
    }

    @Override
    public void startBilling() {
        System.out.println("卡车 [" + id + "]，计费启动...");
    }

    @Override
    public String displayName() {
        return "卡车";
    }
}