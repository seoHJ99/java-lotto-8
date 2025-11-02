package lotto.domain;

import lotto.exception.NotThousandMoneyException;

public class BuyMoney {

    private final int money;

    public BuyMoney(int money) {
        if (!isDivisibleByThousand(money))
            throw new NotThousandMoneyException();
        this.money = money;
    }

    private boolean isDivisibleByThousand(int num) {
        if (num % 1000 != 0 || num < 1)
            return false;
        return true;
    }

    public int getMoney() {
        return this.money;
    }
}
