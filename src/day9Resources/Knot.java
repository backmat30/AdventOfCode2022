package day9Resources;

public class Knot {
    private int xPos;
    private int yPos;

    public Knot(){
        xPos = 0;
        yPos = 0;
    }

    public int getxPos() {
        return xPos;
    }

    public void addxPos(int xPos) {
        this.xPos += xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void addyPos(int yPos) {
        this.yPos += yPos;
    }
}
