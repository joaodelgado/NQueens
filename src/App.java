public class App {

    public static void main(String[] args) {
        Board board = new Board(20);

        if (board.solve()) {
            board.print();
        } else {
            System.out.println("Unable to solve the problem");
        }
    }
}
