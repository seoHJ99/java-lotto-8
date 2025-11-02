package lotto.infra;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.WrongInputFormatException;

import java.util.Arrays;
import java.util.List;

public class InputView { // 싱글톤으로 교체 예정

    private static final String MONEY_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST = "보너스 번호를 입력해 주세요.";
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private String input() {
        return Console.readLine();
    }

    public int inputMoney() {
        try {
            System.out.println(MONEY_REQUEST);
            return Integer.parseInt(input());
        } catch (NumberFormatException ex) {
            throw new WrongInputFormatException();
        }
    }

    public List<Integer> inputWinNumbers() {
        System.out.println(WIN_NUMBERS_REQUEST);
        String input = input();

        if (!input.matches("\\d{1,2}(,\\d{1,2})*")) {
            throw new WrongInputFormatException();
        }

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int inputBonus() {
        try {
            System.out.println(BONUS_REQUEST);
            return Integer.parseInt(input());
        } catch (NumberFormatException ex) {
            throw new WrongInputFormatException();
        }
    }
}
