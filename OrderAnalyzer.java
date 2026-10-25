package test3;

import java.util.*;

public class OrderAnalyzer {
     private final List<Order> orders = new ArrayList<>();

    //添加订单
    public void add(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    //删除无效订单（金额 <= 0）
    public void removeInvalidOrders() {
        Iterator<Order> it = orders.iterator();
        while (it.hasNext()) {
            if (it.next().getAmount() <= 0) {
                it.remove();   //迭代器
            }
        }

    }
    //去重
    public Set<String> getAllUniqueTags() {
        Set<String> uniqueTags = new HashSet<>();
        for (Order order : orders) {
            uniqueTags.addAll(order.getTags());
        }
        return uniqueTags;
    }

    //分组，汇总
    public Map<String, Double> getCustomerSpendMap() {
        Map<String, Double> spendMap = new HashMap<>();
        for (Order order : orders) {
            spendMap.merge(
                    order.getCustomerName(),
                    order.getAmount(),
                    Double::sum
            );
        }
        return spendMap;
    }

    // 姓名升序返回新
    public List<Order> sortOrdersByCustomerName() {
        List<Order> sorted = new ArrayList<>(orders);
        sorted.sort(Comparator.comparing(Order::getCustomerName));
        return sorted;
    }
    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}