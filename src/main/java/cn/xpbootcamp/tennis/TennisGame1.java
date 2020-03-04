package cn.xpbootcamp.tennis;

import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        findWinner(playerName).wonPoint();
    }

    public String getScore() {
        String score = "";
        if (isStandOff()) {
            switch (this.player1.getScore()) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                default:
                    return "Deuce";
            }
        }

        if (this.player1.getScore()>=4 || this.player2.getScore()>=4)
        {
            int minusResult = this.player1.getScore()-this.player2.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                int tempScore=0;
                if (i==1) tempScore = this.player1.getScore();
                else { score+="-"; tempScore = this.player2.getScore();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private boolean isStandOff() {
        return this.player1.getScore() == this.player2.getScore();
    }

    private Player findWinner(String playerName) {
        return isPlayer1WonPoint(playerName) ? player1 : player2;
    }

    private boolean isPlayer1WonPoint(String playerName) {
        return Objects.equals(playerName, this.player1.getName());
    }
}