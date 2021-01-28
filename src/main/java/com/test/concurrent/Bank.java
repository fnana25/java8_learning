package com.test.concurrent;

import java.util.Objects;

/**
 * 类描述：两个人AB通过一个账户,A在柜台取钱和B在ATM机取钱
 *
 * @author fengna
 * @since 2021/1/28 17:36
 */
public class Bank {

    static double money = 1000;

    private void counter(double money){
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元");
    }

    private void ATM(double money){
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元");
    }

    //提供一个取款方法，防止直接调取方法同时取款时，并发余额显示错误
    public synchronized void outMoney(double money,String mode) throws Exception {
        if(money > Bank.money){
            throw new Exception("取款金额" + money + "，余额剩余" + Bank.money + "，取款失败");
        }
        if(Objects.equals(mode,"ATM")){
            ATM(money);
        }else {
            counter(money);
        }
    }
}
