package lotto.infra;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.*;

public class OutputView {

    private static final String ERROR = "[ERROR] ";
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void outputError(String message) {
        System.out.println(ERROR + message);
    }

    public void outputAllLotto(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다.%n", lottos.size()));
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void outputStatistics(Map<LottoRank, Integer> lottoRanks) {
        List<LottoRank> ranks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        Collections.reverse(ranks);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("당첨 통계%n"));
        sb.append(String.format("---%n"));

        System.out.println(makeLottoResult(sb, lottoRanks));
    }

    public void outputTotalEarningRate(double earningRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));
    }

    private StringBuilder makeLottoResult(StringBuilder sb, Map<LottoRank, Integer> lottoRanks) {
        List<LottoRank> ranks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        Collections.reverse(ranks);
        for (LottoRank rank : ranks) {
            if (rank == LottoRank.NONE) continue;

            sb.append(String.format("%d개 일치", rank.matchingCount));
            if (rank.bonusMatching) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(String.format(" (%,d원) - %,d개%n", rank.prize, lottoRanks.getOrDefault(rank, 0)));
        }
        return sb;
    }
}
