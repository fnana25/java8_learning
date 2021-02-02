package com.test.concurrent.drawMoneyExample;

import com.test.concurrent.drawMoneyExample.Bank;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/1/28 17:51
 */
public class DrawPerson extends Thread {

    private Bank bank;

    private String mode;

    private double drawMoney;

    public DrawPerson(Bank bank, String mode, double drawMoney){
        this.bank = bank;
        this.mode = mode;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {

        while (Bank.money >= drawMoney){
            try {
                bank.outMoney(drawMoney,mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
