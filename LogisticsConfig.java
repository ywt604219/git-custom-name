package test4;

/*Task1：独一无二的调度中心（单例模式 Singleton）*/
public class LogisticsConfig {

    // 1. 私有静态唯一实例
    private static final LogisticsConfig INSTANCE = new LogisticsConfig();
private String systemName = "系统";//现在就赋值
    private LogisticsConfig() {
    }
    public static LogisticsConfig getInstance() {
        return INSTANCE;//公共静态方法返回唯一实例
    }

    public String getSystemName() {
        return systemName;
    }
}
