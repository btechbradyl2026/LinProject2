import java.util.Scanner;


public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);


    public LinearEquationLogic() {
    }


    int num = 1;


    private void game(String p1, String p2) {
        welcome(p1, p2);
        System.out.println("Would you like to enter another pair of coordinates? y/n");
    }


    public void welcome(String point1, String point2) {
        int x1;
        int y1;
        int x2;
        int y2;
        x1 = Integer.parseInt(point1.substring(1, point1.indexOf(",")));
        y1 = Integer.parseInt(point1.substring(point1.indexOf(",") + 2, point1.length() -1));
        x2 = Integer.parseInt(point2.substring(1, point2.indexOf(",")));
        y2 = Integer.parseInt(point2.substring(point2.indexOf(",") + 2, point2.length() -1));
        if (x1 == x2) {
            System.out.println("This is a vertical line and thus not a linear equation");
        } else {
            LinearEquation lE = new LinearEquation(x1,y1,x2,y2);
            System.out.println(lE.lineInfo());
            System.out.println("Enter a value for x: ");
            System.out.println(lE.coordinateForX(scan.nextDouble()));
            scan.nextLine();
        }
    }


    public void next() {
        while (num == 1) {
            String c1;
            String c2;
            System.out.println("Enter coordinate 1: ");
            c1 = scan.nextLine();
            System.out.println("Enter coordinate 2: ");
            c2 = scan.nextLine();
            game(c1, c2);
            if (scan.nextLine().equals("y")) {
                num = 1;
            } else {
                num = 0;
                goodbye();
            }
        }
    }


    public void start() {
        System.out.println("Welcome to the linear equation calculator");
        next();
    }
    public void goodbye() {
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }
}
