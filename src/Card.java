import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Comparable<Card> {
    String suite = new String();
    String value = new String();
    int rank;
    final String [ ] suites = {"Diamond", "Heart", "Spade", "Clubs" };
    final int [ ] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    final ArrayList<String> values =(ArrayList<String>) Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
    Card(String suite,String value){
        this.suite=suite;
        this.value=value;
        this.rank=calcRank(value);
    }
    public int calcRank(String value)
    {
        return ranks[values.indexOf(value)];
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getSuite() {
        return suite;
    }
    public void setSuite(String suite) {
        this.suite = suite;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public int compareTo(Card o) {
        return this.rank-o.rank;

    }
}