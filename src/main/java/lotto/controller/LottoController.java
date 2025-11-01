    private WinNumbers inputWinNum() {
        while (true) {
            try {
                List<Integer> numbers = inputView.inputWinNumbers();
                return new WinNumbers(numbers);
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNum() {
        while (true) {
            try {
                int bonus = inputView.inputBonus();
                return new BonusNumber(bonus);
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private int inputMoney() {
        while (true) {
            try {
                int money = inputView.inputMoney();
                if (!isDivisibleByThousand(money))
                    throw new IllegalArgumentException("구매 금액은 1000원 단위로만 입력해야 합니다.");
                return money;
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private boolean isDivisibleByThousand(int num) {
        if (num % 1000 != 0 || num < 1)
            return false;
        return true;
    }
}
