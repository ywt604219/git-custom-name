package test5;

public class PaymentService {

    private final PaymentProcessor paymentProcessor = new PaymentProcessor();

    /**
     * 处理支付，统一捕获与包装异常
     *
     * @return 支付是否成功
     */
    public boolean processPayment(double amount, String transactionId) {
        try {
            paymentProcessor.pay(amount, transactionId);
            return true;

        } catch (InsufficientFundsException e) {
            // 捕获受检异常：打印余额不足及流水号
            System.out.println("余额不足，流水号为[" + e.getTransactionId() + "]");
            return false;

        } catch (IllegalArgumentException e) {
            // 将 IllegalArgumentException 包装为 SystemMaintenanceException 重新抛出
            throw new SystemMaintenanceException("支付参数非法，系统拒绝处理", e);

        } catch (Exception e) {
            // 捕获其他异常
            System.out.println("发生未知异常:" + e.getMessage());
            return false;

        } finally {
            // 无论支付是否成功，最后都会执行（日志/资源清理）
            System.out.println("交易[" + transactionId + "]处理完毕，释放资源。");
        }
    }
}