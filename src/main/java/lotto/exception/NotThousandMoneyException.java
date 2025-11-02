package lotto.exception;

public class NotThousandMoneyException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "구매 금액은 1000원 단위로만 입력해야 합니다.";

    public NotThousandMoneyException() {
        super(ERROR_MESSAGE);
    }
}
