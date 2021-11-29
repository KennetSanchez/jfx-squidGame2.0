package model;

import java.io.Serializable;

public class Player implements Serializable {
    private String nickName;
    private String time;
    private String negativeScorePercentString;
    private double scoreToCompare;


    public Player(String nickName,String time,double totaltimeInMinutes,int negativeScore,int totalBoxesScore){
        this.nickName=nickName;
        this.time=time;
        double negativeScorePercent = negativeScore/totalBoxesScore;
        scoreToCompare = (60-totaltimeInMinutes)-(60-totaltimeInMinutes)*negativeScorePercent;
        negativeScorePercentString = negativeScorePercent*100+"%";
    }


}
