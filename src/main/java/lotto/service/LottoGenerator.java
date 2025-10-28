package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> create(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("[ERROR] 0이상의 숫자만 입력받을 수 있습니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(create());
        }
        return lottos;
    }

    private Lotto create() {
        return new Lotto(getSixNumber());
    }

    private List<Integer> getSixNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
