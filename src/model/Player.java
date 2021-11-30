package model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Player implements Serializable, Comparable<Player> {
    private String nickName;
    private String time;
    private String negativeScorePercentString;
    private double scoreToCompare;


    public Player(String nickName,String time,double totaltimeInMinutes,int negativeScore,int totalBoxesScore){
        this.nickName=nickName;
        this.time=time;
        double negativeScorePercent = (negativeScore*0.01)/(totalBoxesScore*0.01);
        scoreToCompare = (60-totaltimeInMinutes)-(60-totaltimeInMinutes)*negativeScorePercent;
        DecimalFormat df = new DecimalFormat("0.00");
        negativeScorePercentString = df.format(negativeScorePercent*100)+"%";
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNegativeScorePercentString() {
        return negativeScorePercentString;
    }

    public void setNegativeScorePercentString(String negativeScorePercentString) {
        this.negativeScorePercentString = negativeScorePercentString;
    }

    public double getScoreToCompare() {
        return scoreToCompare;
    }

    public void setScoreToCompare(double scoreToCompare) {
        this.scoreToCompare = scoreToCompare;
    }

    @Override
    public int compareTo(Player o) {
        Integer number = 0;
        if(scoreToCompare<o.getScoreToCompare()){
            number=1;
        }
        else if(scoreToCompare>o.getScoreToCompare()){
            number=-1;
        }
        return number;
    }
}
