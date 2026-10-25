package test4;

public abstract class TransportVehicle {
    protected String id;

    public TransportVehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public abstract void startBilling();

    public abstract String displayName();
}