package test5;
public class PaymentProcessor {
    public void pay(double amount, String transactionId) throws InsufficientFundsException {
        // 1. 金额为负数 -> 原生 IllegalArgumentException
        if (amount < 0) {
            throw new IllegalArgumentException("支付金额不能为负数");
        }

        // 2. 金额 > 10000 -> 自定义受检异常，携带流水号
        if (amount > 10000) {
            throw new InsufficientFundsException("余额不足", transactionId);
        }

        // 3. 金额 == 500 -> 自定义非受检异常，附带原始 NPE
        if (amount == 500) {
            NullPointerException original = new NullPointerException("底层网络对象为空");
            throw new SystemMaintenanceException("网络连接超时", original);
        }

        // 4. 其他情况 -> 支付成功
        System.out.println("交易[" + transactionId + "]支付成功，金额：" + amount);
    }
}
