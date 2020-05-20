package test.test_condition;

public class DepositThread implements Runnable{

    private Account account;

    private float depositAmount;//每次存钱数


    public DepositThread(Account account, float depositAmount) {
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
             account.deposit(depositAmount);
             try {
                 Thread.sleep(100);
                 } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}