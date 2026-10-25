package test5;
public class SystemMaintenanceException extends RuntimeException {

    public SystemMaintenanceException(String message) {
        super(message);
    }

    // 支持异常链的构造方法
    public SystemMaintenanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemMaintenanceException(Throwable cause) {
        super(cause);
    }
}