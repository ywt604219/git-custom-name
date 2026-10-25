package test3;

import java.util.List;

public class Order implements Comparable<Order> {
    private final String orderId;
    private final String customerName;
    private final double amount;
    private final List<String> tags;

    public Order(String orderId, String customerName, double amount, List<String> tags) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.tags = tags;
    }

    public String getOrderId()      {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getAmount()       {
        return amount;
    }
    public List<String> getTags()   {
        return tags;
    }

    /*
     默认排序规则：金额降序（大的在前）
金额相同 → 订单号升序
     */
    @Override
    public int compareTo(Order other) {
        int byAmount = Double.compare(other.amount, this.amount); // 降序
        if (byAmount != 0) {
            return byAmount;
        }
        return this.orderId.compareTo(other.orderId);             // 升序
    }

    @Override
    public String toString() {
        return String.format("Order{%s, %s, %.1f, %s}",
                orderId, customerName, amount, tags);
    }
}
