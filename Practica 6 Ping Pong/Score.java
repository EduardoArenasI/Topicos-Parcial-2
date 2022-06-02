package com.example.p2_practica6;

public class Score {
    private int player1Score;
    private int player2Score;
    private int scoreToWin;

    public Score(int scoreToWin) {
        this.scoreToWin = scoreToWin;
    }

    public void Reset() {
        player1Score = 9;
        player2Score = 0;
    }

    public void Player1Scored() {
        player1Score++;
    }

    public void Player2Scored() {
        player2Score++;
    }

    public String CreateScoreBoard() {
        return "Puntaje " + player1Score + " : " + player2Score;
    }

    public String CreateWinnerBoard() {
        if (player1Score >= player2Score)
            return "Jugador 1 ganoe el juego";
        else
            return "Jugador 2 gano el juego";
    }

    public boolean isGameFinished() {
        if (player1Score >= scoreToWin || player2Score >= scoreToWin)
            return true;
        else
            return false;
    }
}
