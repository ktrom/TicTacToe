import java.util.Arrays;

public class TicTacToe {
    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b.toString());

    }
}

class Board {
    char[] boardItems;

    public Board() {
        boardItems = new char[9];
        Arrays.fill(boardItems, 'E');
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
            if (boardItems[i] == 'E') {
                returnString += "|" + i;
            } else {
                returnString += "|" + boardItems[i];
            }
            if(i%3 == 2){
                returnString += '|';
            }
        }
        returnString += "\n+-+-+-+";
        return returnString;
    }
}