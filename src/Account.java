import java.io.*;

public class Account {
    private String number = null;
    private String name = null;
    private String password = null;
    private Double money = 0.0;

    //添加构造方法，生成多个储户信息
    public Account(String number, String name, String password, Double money) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    protected String get_Number() {
        return number;
    }

    protected String get_Name() {
        return name;
    }

    protected String get_Password() {
        return password;
    }

    protected Double get_Money() {
        return money;
    }

    //余额减少
    protected void subBalance(double mon) {
        money -= mon;
    }

    //余额增加
    protected void addBalance(double mon) {
        money += mon;
    }
}
