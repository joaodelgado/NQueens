import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        int n = in.nextInt();
        Board board = new Board(n);

        if (board.solve()) {
            board.print();
        } else {
            System.out.println("Unable to solve the problem");
        }
    }
}
