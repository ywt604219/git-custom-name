package test4;

public class Drone extends TransportVehicle {

    public Drone(String id) {
        super(id);
    }

    @Override
    public void startBilling() {
        System.out.println("无人机 [" + id + "]，计费启动...");
    }

    @Override
    public String displayName() {
        return "无人机";
    }
}