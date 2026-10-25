package test4;
public class LogisticsOrder {


    private final String orderId;
    private final String sender;
    private final String receiver;
    private final boolean fragile;
    private final double insuredAmount;
    // 私有构造器只 Builder 调用
    private LogisticsOrder(Builder builder) {
        this.orderId = builder.orderId;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.fragile = builder.fragile;
        this.insuredAmount = builder.insuredAmount;
    }

    public static class Builder {
        private final String orderId;
        private String sender = "未填写";
        private String receiver = "未填写";
        private boolean fragile = false;
        private double insuredAmount = 0.0;

        public Builder(String orderId) {
            if (orderId == null || orderId.isEmpty()) {
                throw new IllegalArgumentException("订单号不能为空");
            }
            this.orderId = orderId;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder fragile(boolean fragile) {
            this.fragile = fragile;
            return this;
        }

        public Builder insuredAmount(double insuredAmount) {
            this.insuredAmount = insuredAmount;
            return this;
        }

        public LogisticsOrder build() {
            return new LogisticsOrder(this);
        }
    }


    @Override
    public String toString() {
        return String.format(
                "订单号[%s], 寄件人[%s], 收件人[%s], 易碎品[%b], 保价[%.1f元]",
                orderId, sender, receiver, fragile, insuredAmount);
    }
}
