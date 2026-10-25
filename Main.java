package test3;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderAnalyzer analyzer = new OrderAnalyzer();

        analyzer.add(new Order("O001", "Alice",   150.0, List.of("电子", "数码")));
        analyzer.add(new Order("O002", "Bob",     -50.0, List.of("服装")));
        analyzer.add(new Order("O003", "Alice",   200.0, List.of("图书", "电子")));
        analyzer.add(new Order("O004", "Charlie", 200.0, List.of("生鲜")));
        analyzer.add(new Order("O005", "Bob",     300.0, List.of("服装", "户外")));
        System.out.println("初始订单");
        analyzer.getOrders().forEach(System.out::println);

        //删除无效订单
        analyzer.removeInvalidOrders();
        System.out.println("\n删除金额<=0的订单");
        analyzer.getOrders().forEach(System.out::println);

        //测试2：标签去重
        System.out.println("\n 所有唯一标签");
        System.out.println(analyzer.getAllUniqueTags());

        //测试3：按客户分组汇总
        System.out.println("\n 客户消费汇总");
        analyzer.getCustomerSpendMap()
                .forEach((name, total) -> System.out.printf("%s: %.1f%n", name, total));
        //测试4：按客户名排序（新 List）
        System.out.println("\n 按客户姓名升序");
        analyzer.sortOrdersByCustomerName().forEach(System.out::println);
        //验证 Order 默认排序规则（金额降序、同额订单号升序）
        List<Order> all = new ArrayList<>(analyzer.getOrders());
        Collections.sort(all);   // 使用 Order.compareTo 的默认规则
        System.out.println("\n默认规则：金额降序、同额订单号升序");
        all.forEach(System.out::println);
    }
}