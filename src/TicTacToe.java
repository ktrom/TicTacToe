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