public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double changeX;
    private double changeY;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        changeX = x2 - x1;
        changeY = y2 - y1;
    }

    double rounder(double x) {
        return (double) Math.round(x * 100) /100;
    }
    public double slope() {
        return rounder(changeY/changeX);
    }

    public double distance() {
        return rounder(Math.sqrt(Math.pow(changeX, 2) + Math.pow(changeY, 2)));
    }

    public double yIntercept() {
        if (x1 < 0) {
            return Math.abs(x1) * slope() + y1;
        } else if (x1 > 0) {
            return y1 - (x1 * slope());
        } else {
            return y1;
        }
    }

    public String equation() {
        double yInt = yIntercept();
        String superSlope = "x";

        if (changeY == 0) {
            return "y = " + (int) yInt;
        } else {
                if (changeY > 0 && changeX > 0) {
                superSlope = ((int)changeY) + "/" + ((int)changeX) + "x";
                }
                if (changeX < 0 || changeY < 0) {
                    if (changeY < 0) {
                        superSlope = "-" + ((int)changeY * -1) + "/" + ((int)changeX) + "x";
                    }
                    if (changeX < 0) {
                        superSlope = "-" + ((int)changeY) + "/" + ((int)changeX * -1) + "x";
                    }
                } if (changeX < 0 && changeY < 0) {
                    superSlope = ((int)changeY * -1) + "/" + ((int)changeX * -1) + "x";
                } if (changeY % changeX == 0) {
                    superSlope = (int)(changeY / changeX) + "x";
                } if (changeY / changeX == 1) {
                    superSlope = "x";
                } if (changeY / changeX == -1) {
                    superSlope = "-x";
                }

            if (yInt == 0) {
                return "y = " + superSlope;
            }
            if (yInt < 0) {
                return  "y = " + superSlope + " - " + rounder(yInt * -1);
            }
            return "y = " + superSlope + " + " + rounder(yInt);
        }
    }


    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }

    public String lineInfo() {
        return "The two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" + "\n" + "The equation of the line between these points is: " + equation() + "\n" + "The y-intercept of the line is: " + yIntercept() + "\n" + "The slope of this line is: "
                + slope() + "\n" + "The distance between these 2 points is " + distance();   }
}
