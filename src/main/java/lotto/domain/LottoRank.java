package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    FIFTH(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    THIRD(3, false, 5_000),
    NONE(0, false, 0);

    public final int matchingCount;
    public final boolean bonusMatching;
    public final int prize;

    LottoRank(int matchingCount, boolean bonusMatching, int prize) {
        this.matchingCount = matchingCount;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public static LottoRank getRank(int matchingCount, boolean bonusMatching) {
        if (matchingCount == 6)
            return FIRST;
        if (matchingCount == 5 && bonusMatching)
            return SECOND;
        if (matchingCount == 5)
            return FIFTH;
        if (matchingCount == 4)
            return FOURTH;
        if (matchingCount == 3)
            return THIRD;
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
