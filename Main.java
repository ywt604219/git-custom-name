package test5;

public class Main {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        //正常支付
        System.out.println("正常支付（金额=100");
        try {
            boolean result = service.processPayment(100, "TXN001");
            System.out.println(result);
        } catch (Exception e) {
            // 兜底：正常支付理论不会抛异常，但仍防御性捕获
            System.out.println("意外异常：" + e.getMessage());
        }

        System.out.println();

        //金额 < 0
        System.out.println("金额为负（金额=-1）");
        try {
            boolean result = service.processPayment(-1, "TXN002");
            System.out.println(result);
        } catch (SystemMaintenanceException e) {
            // 内部把 IllegalArgumentException 包装成 SystemMaintenanceException 重新抛出，这里必须捕获
            System.out.println("捕获到包装异常：" + e.getMessage());
            System.out.println("原始异常原因：" + e.getCause());
        } catch (Exception e) {
            System.out.println("其他异常：" + e.getMessage());
        }

        System.out.println();

        // 场景3：金额 > 10000（余额不足）
        System.out.println("余额不足（金额=20000");
        try {
            boolean result = service.processPayment(20000, "TXN003");
            System.out.println(result);
        } catch (Exception e) {
            // 理论上 processPayment 已内部捕获 InsufficientFundsException 并返回 false，
            // 此处兜底防止意外
            System.out.println("意外异常：" + e.getMessage());
        }

        System.out.println();

        // 场景4：金额 = 500（系统维护 / 网络超时）
        System.out.println("系统维护（金额=500）");
        try {
            boolean result = service.processPayment(500, "TXN004");
            System.out.println(result);
        } catch (SystemMaintenanceException e) {
            // SystemMaintenanceException 是 RuntimeException，processPayment 未捕获它，
            // 会向外传播，必须在这里捕获，否则程序崩溃
            System.out.println("捕获到系统维护异常：" + e.getMessage());
            System.out.println("原始异常（异常链）：" + e.getCause());
        } catch (Exception e) {
            System.out.println("其他异常：" + e.getMessage());
        }

    }
}