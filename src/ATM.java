import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class ATM {
    Account act=new Account("sds", "sundongsheng", "sds", 10000.00);

    /*public ATM() {
        new Account("sds", "sundongsheng", "sds", 10000.00);
    }*/

    //*********欢迎界面***************
    protected void Welcome() {
        String str = "----------------------------";
        System.out.println(str);
        System.out.print("1.取款" + "\n" + "2.存款" + "\n" + "3.查询" + "\n" + "4.退出系统" + "\n");
        System.out.println(str);
    }

    //登录系统
    protected void Load_Sys() throws Exception {
        String card, pwd;
        int counter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("请输入您的卡号：");
            card = br.readLine();
            System.out.println("请输入您的密码：");
            pwd = br.readLine();
            if (!isRight(card,pwd)) {//判断卡号或密码的方法isRight()那个红色的这是一个断点
                System.out.println("您输入的卡号或密码有误");
                counter++;
            } else SysOpter();//进入系统操作提示方法SysOpter()
        } while (counter < 3);
        System.exit(1);
    }

    //系统操作提示
    protected void SysOpter() throws Exception {
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您要操作的项目:");
        num = br.read();
        switch (num) {
            case 49:
                quqian();
                break;//查询
            case 50:
                cunqian();
                break;//取钱
            case 51:
                chaxun();
                break;//存钱
            case 52:
                Exit_Sys();
                break;//退出
        }
        System.exit(1);
    }

    //查询操作
    protected void chaxun() throws Exception {
        System.out.println("---------------------" + "\n" +
                "账户:" + act.get_Number() + "\n" +
                "姓名:" + act.get_Name() + "\n" +
                "余额:" + act.get_Money() + "\n" +
                "-------------------------------\n");
        SysOpter();
    }

    //取钱
    public void quqian() throws Exception {
        String str = null, str1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("请输入取钱数目");
            str = br.readLine();
            double qu = Double.valueOf(str).doubleValue();//将字符串转换成double类型
            if (qu > act.get_Money()) {
                System.out.println("余额不足");
            } else {
                act.subBalance(qu);
                System.out.println("取款成功。您的剩余余额为：" + act.get_Money());
                Welcome();
                SysOpter();
            }
        } while (true);
    }

    //存钱操作
    public void cunqian() throws Exception {
        String str = null, str1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("请输入存钱数目");
            str = br.readLine();
            double cun = Double.valueOf(str).doubleValue();
            act.addBalance(cun);
            System.out.println("存款成功，您的剩余余额为：" + act.get_Money());
            Welcome();
            SysOpter();
        } while (true);
    }

    //判断卡内是否有钱
    protected boolean isBalance() {
        if (act.get_Money() < 0) {
            return false;
        }
        return true;
    }

    //检查卡号或密码是否正确
    protected boolean isRight(String card, String pwd) {//act.get_Number()  这个是空的吧？
        if (card.equals(act.get_Number()) && pwd.equals(act.get_Password()))
            return true;
        else return false;
    }

    //结束系统
    protected void Exit_Sys() {
        System.out.println("感谢您的使用，欢迎下次光临，谢谢,再见");
        System.exit(1);
    }
}
