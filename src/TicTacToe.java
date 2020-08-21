import java.util.Arrays;
import java.util.Scanner;

/**
 * Eli Musgrove (eli): Wrote isOver() method.
 *
 */

public class TicTacToe {
    public static void main(String[] args) {
        int success = 0; // 0 if no success, 1 for p1 success, 2 for p2 success
        boolean playerOneTurn = true;
        Board board = new Board();
        int input;

        System.out.print(board.toString());
        while (success == 0) {
            input = getInput(board, playerOneTurn);
            board.updateBoard(playerOneTurn, input - 1);
            success = board.isOver();
            playerOneTurn = !playerOneTurn;
            System.out.print(board.toString());
        }
        if (success == 1) {
            System.out.println("Player 1 wins!! Congrats Player 1");
        } else if(success == 2){
            System.out.println("Player 2 wins!! Congrats Player 2");
        }
        else{
            System.out.println("It's a draw!");
        }

    }


    public static int getInput(Board board, boolean playerOneTurn) {
        // initial variables
        boolean goodInput = false;
        int input = -1;
        Scanner scan = new Scanner(System.in);

        // set xOrO to X if it is player 1's turn and O otherwise and ask for input
        char xOrO;
        if (playerOneTurn) {
            xOrO = 'X';
        } else {
            xOrO = 'O';
        }
        System.out.print("Please enter 1-9 to place an " + xOrO + ": ");

        while (!goodInput) {
            input = scan.nextInt();
            if (input >= 1 && input <= 9) {
                if (board.boardItems[input - 1] == 'e') {
                    goodInput = true;
                } else {
                    System.out.print("\nSpot Taken. Please enter 1-9 to place an " + xOrO + ": \n");
                }
            } else {
                System.out.print("\nInvalid number. Please enter 1-9 to place an " + xOrO + ": \n");
            }
        }
        return input;
    }

}

class Board {
    char[] boardItems;

    public Board() {
        boardItems = new char[9];
        Arrays.fill(boardItems, 'e');
    }

    public int isOver() {
        // Check rows
        for (int i=0; i < 9; i+=3) {
            if (boardItems[i] != 'e' && boardItems[i] == boardItems[i + 1] && boardItems[i + 1] == boardItems[i + 2]) {
                return boardItems[i] == 'X' ? 1 : 2;
            }
        }

        // Check columns
        for (int i=0; i < 3; i++) {
            if (boardItems[i] != 'e' && boardItems[i] == boardItems[i + 3] && boardItems[i + 3] == boardItems[i + 6]) {
                return boardItems[i] == 'X' ? 1 : 2;
            }
        }

        // Check diagonals
        if (boardItems[0] != 'e' && boardItems[0] == boardItems[4] && boardItems[4] == boardItems[8]) {
            return boardItems[0] == 'X' ? 1 : 2;
        }
        if (boardItems[2] != 'e' && boardItems[2] == boardItems[4] && boardItems[4] == boardItems[6]) {
            return boardItems[0] == 'X' ? 1 : 2;
        }

        // Check if the game is a draw
        for (int i=0; i < 9; i++) {
            if (boardItems[i] == 'e') {
                break;
            }

            if (i == 8) {
                // We're on the last square and haven't hit an empty
                return 3;
            }
        }

        // Game not over yet
        return 0;
    }

    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < boardItems.length; i++) {
            if (i % 3 == 0) {
                returnString += "\n+-+-+-+\n";
            }
            if (boardItems[i] == 'e') {
                returnString += "|" + (i + 1);
            } else {
                returnString += "|" + boardItems[i];
            }
            if(i%3 == 2){
                returnString += '|';
            }
        }
        returnString += "\n+-+-+-+\n\n";
        return returnString;
    }
    
    public void updateBoard(boolean playerOneTurn, int location) {
		if(playerOneTurn) {
			boardItems[location] = 'X';
		} else {
			boardItems[location] = 'O';
		}
    }
}


