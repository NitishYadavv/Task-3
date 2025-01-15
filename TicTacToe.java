import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    static boolean gameOver = false;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        do {
            initializeBoard();
            gameOver = false;
            printBoard();
            
            while (!gameOver) {
                playerTurn(scanner);
                printBoard();
                checkWinner();
                switchPlayer();
            }
            
            // Ask for restart or exit
            System.out.print("Do you want to play again? (y/n): ");
            char playAgain = scanner.next().charAt(0);
            if (playAgain == 'n' || playAgain == 'N') {
                System.out.println("Thanks for playing!");
                break;
            }
            
        } while (true);
        
        scanner.close();
    }
    
    // Initialize the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    // Print the current board state
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    // Handle player's turn
    public static void playerTurn(Scanner scanner) {
        int row, col;
        
        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.print("Enter row (0, 1, 2): ");
            row = scanner.nextInt();
            System.out.print("Enter column (0, 1, 2): ");
            col = scanner.nextInt();
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }
    
    // Switch the current player
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    // Check if there's a winner or a draw
    public static void checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                gameOver = true;
                System.out.println("Player " + currentPlayer + " wins!");
                return;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                gameOver = true;
                System.out.println("Player " + currentPlayer + " wins!");
                return;
            }
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            gameOver = true;
            System.out.println("Player " + currentPlayer + " wins!");
            return;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            gameOver = true;
            System.out.println("Player " + currentPlayer + " wins!");
            return;
        }
        
        // Check for draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    draw = false;
                    break;
                }
            }
        }
        
        if (draw) {
            gameOver = true;
            System.out.println("It's a draw!");
        }
    }
}
