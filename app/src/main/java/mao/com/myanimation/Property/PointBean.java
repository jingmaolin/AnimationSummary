package mao.com.myanimation.Property;

/**
 * Description ：   圆点坐标
 * Job number：600029
 * Phone ：13342446520
 */

public class PointBean {
    private int pointX;
    private int pointY;

    public PointBean(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    @Override
    public String toString() {
        return "PointBean{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                '}';
    }
}
