package test.test_condition;

public class WithdrawThread implements Runnable{

    private Account account;

    private float drawAmount;//每次取钱数


    public WithdrawThread(Account account, float drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
             account.withdraw(drawAmount);
             try {
                 Thread.sleep(100);
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}