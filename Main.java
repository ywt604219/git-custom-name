package test4;

/**
 * 智能物流系统联调入口：单例 + 工厂 + 建造者三模式测试
 */
public class Main {
    public static void main(String[] args) {

        LogisticsConfig configA = LogisticsConfig.getInstance();
        LogisticsConfig configB = LogisticsConfig.getInstance();
        System.out.println("单例测试：配置类实例A与实例B是否相同？ -> " + (configA == configB));

        System.out.println();

        TransportVehicle vehicle = VehicleFactory.createVehicle("Drone");
        System.out.print("工厂调度：工厂成功分配 -> ");
        vehicle.startBilling();

        TransportVehicle truck = VehicleFactory.createVehicle("Truck");
        if (truck != null) {
            truck.startBilling();
        }

        TransportVehicle unknown = VehicleFactory.createVehicle("Ship");
        System.out.println();

        LogisticsOrder order = new LogisticsOrder.Builder("OD-999")
                .sender("Alice")
                .receiver("Bob")
                .fragile(true)
                .insuredAmount(1000.0)
                .build();
        System.out.println("运单生成：" + order);
    }
}