package lotto.domain;

public class BuyMoney {

    private final int money;

    public BuyMoney(int money) {
        if (!isDivisibleByThousand(money))
            throw new IllegalArgumentException("구매 금액은 1000원 단위로만 입력해야 합니다.");
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
