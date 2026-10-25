import com.itheima.ui.FightingGame;
import com.itheima.ui.Login;

public class app {
    public static void main(String[] args) {
        //启动类，启动整个程序，登录注册的页面
        //Login l = new Login();
        //l.start();
        FightingGame fg = new FightingGame();
        fg.gameStart("Player1");

    }
}
