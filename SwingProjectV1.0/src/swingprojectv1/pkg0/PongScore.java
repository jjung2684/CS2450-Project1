/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingprojectv1.pkg0;

/**
 *
 * @author barre
 */
public class PongScore {
   private int p1Score;
    private int p2Score;
    
    PongScore(int s1, int s2)
    {
        p1Score = s1;
        p2Score = s2;
    }
    
    public void setP1(int score)
    {
        p1Score = score;
    }
    
    
    public void setP2(int score)
    {
        p2Score = score;
    }
    
    public int getP1()
    {
        return p1Score;
    }
    
    public int getP2()
    {
        return p2Score;
    }
    
    
    
}
