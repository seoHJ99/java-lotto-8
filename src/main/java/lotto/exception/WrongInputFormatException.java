package lotto.exception;

public class WrongInputFormatException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "잘못된 입력 형식입니다.";

    public WrongInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
