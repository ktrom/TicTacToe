import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int success = 0; // 0 if no success, 1 for p1 success, 2 for p2 success
        boolean playerOneTurn = true;
        Board board = new Board();
        int input;

        System.out.print(board.toString());
        while (success == 0) {
            input = getInput(board, playerOneTurn);
            board.updateBoard(playerOneTurn, input);
            success = board.isOver();
            playerOneTurn = !playerOneTurn;
            System.out.print(board.toString());
        }
        if (success == 1) {
            System.out.println("Congrats Player 1");
        } else {
            System.out.println("Congrats Player 2");
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
        System.out.print("Please enter 0-8 to place an " + xOrO + ": ");

        while (!goodInput) {
            input = scan.nextInt();
            if (input >= 0 && input <= 8) {
                if (board.boardItems[input] != 'e') {
                    goodInput = true;
                } else {
                    System.out.print("\n Spot Taken. Please enter 0-8 to place an " + xOrO + ": ");
                }
            } else {
                System.out.print("\n Invalid number. Please enter 0-8 to place an " + xOrO + ": ");
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
                returnString += "|" + i;
            } else {
                returnString += "|" + boardItems[i];
            }
            if(i%3 == 2){
                returnString += '|';
            }
        }
        returnString += "\n+-+-+-+\n";
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


