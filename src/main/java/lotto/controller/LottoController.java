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

    private void inputBonusNum(WinNumbers winNumbers) {
        while (true) {
            try {
                int bonus = inputView.inputBonus();
                winNumbers.setBonusNumber(new BonusNumber(bonus));
                return;
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private BuyMoney inputMoney() {
        while (true) {
            try {
                int money = inputView.inputMoney();
                return new BuyMoney(money);
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }


}
