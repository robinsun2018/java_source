package test.test_condition.alterantely_printing;

/**
 * https://www.cnblogs.com/yanyapan/p/12915130.html
 */
public class CasMethod {

    enum ReadyToRun{
        T1,T2
    }

    private static volatile ReadyToRun readyToRun = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] letters = "ABCDEF".toCharArray();

        new Thread(() ->{
            for (char nt : numbers) {
                while (readyToRun != ReadyToRun.T1) {}
                System.out.println(nt);
                readyToRun = ReadyToRun.T2;
            }
        },"t1").start();

        new Thread(() ->{
            for (char nt : letters) {
                while (readyToRun != ReadyToRun.T2){}
                System.out.println(nt);
                readyToRun = ReadyToRun.T1;
            }
        },"t2").start();


    }
}
