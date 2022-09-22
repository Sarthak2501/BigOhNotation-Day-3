public class Qtwo3 {
    public static boolean onBoard(int i, int j){
        return i >= 0 && i < 8 &&
                j >= 0 && j < 8;
    }

    public static boolean checkKing(char [][]chessBoard, char c, int i, int j)
    {

        int moveX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int moveY[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++)
        {

            int newX = i + moveX[k];
            int  newY = j + moveY[k];


            if (onBoard(newX, newY) && chessBoard[newX][newY] == c)
                return true;
        }
        return false;
    }

    public static boolean checkCamel(char [][]chessBoard, char c, int i, int j) {
        //chessBoard[][8]
        // Check the lower right diagonal
        int k = 0;
        while (onBoard(i + ++k, j + k)) {
            if (chessBoard[i + k][j + k] == c){
                return true;
            }
            if (chessBoard[i + k][j + k] != '-'){
                break;
            }
        }

        // Check the lower left diagonal
        k = 0;
        while (onBoard(i + ++k, j - k)) {
            if (chessBoard[i + k][j - k] == c){
                return true;
            }
            if (chessBoard[i + k][j - k] != '-'){
                break;
            }
        }

        // Check the upper right diagonal
        k = 0;
        while (onBoard(i - ++k, j + k)) {
            if (chessBoard[i - k][j + k] == c){
                return true;
            }
            if (chessBoard[i - k][j + k] != '-'){
                break;
            }
        }

        // Check the upper left diagonal
        k = 0;
        while (onBoard(i - ++k, j - k)) {
            if (chessBoard[i - k][j - k] == c){
                return true;
            }
            if (chessBoard[i - k][j - k] != '-'){
                break;
            }
        }
        return false;
    }

    // Check if Elephant can attack king
    public static boolean checkElephant(char [][] chessBoard, char c, int i, int j)
    {
        // Check downwards
        int k = 0;
        while (onBoard(i + ++k, j)) {
            if (chessBoard[i + k][j] == c){
                return true;
            }
            if (chessBoard[i + k][j] != '-'){
                break;
            }
        }

        // Check upwards
        k = 0;
        while (onBoard(i + --k, j)) {
            if (chessBoard[i + k][j] == c){
                return true;
            }
            if (chessBoard[i + k][j] != '-'){
                break;
            }
        }

        // Check right
        k = 0;
        while (onBoard(i, j + ++k)) {
            if (chessBoard[i][j + k] == c){
                return true;
            }
            if (chessBoard[i][j + k] != '-'){
                break;
            }
        }

        // Check left
        k = 0;
        while (onBoard(i, j + --k)) {
            if (chessBoard[i][j + k] == c){
                return true;
            }
            if (chessBoard[i][j + k] != '-'){
                break;
            }
        }
        return false;
    }

    //check if Queen can attack the King
    public static boolean checkQueen(char [][]chessBoard, char c, int i, int j) {
        // Queen's moves are a combination of both the camel and the Elephant
        if (checkCamel(chessBoard, c, i, j) || 	checkElephant(chessBoard, c, i, j)){
            return true;
        }
        return false;
    }

    // Check if the horse can attack the king
    public static boolean checkHorse(char [][]chessBoard, char c, int i, int j)
    {
        // All possible moves of the horse
        int moveX[] = {2, 2, -2, -2, 1, 1, -1, -1};
        int moveY[] = {1, -1, 1, -1, 2, -2, 2, -2};

        for (int k = 0; k < 8; k++)
        {
            // increasing the positions
            int newX = i + moveX[k];
            int newY = j + moveY[k];

            // checking positions and conditions on board
            if (onBoard(newX, newY) && chessBoard[newX][newY] == c)
                return true;
        }
        return false;
    }



    // Function to check if the king is safe or not
    public static boolean isKingSafe(char [][]chessBoard) {
        // Find the position of the king
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Check for all pieces which can attack KING
                if (chessBoard[i][j] == 'K') {
                    // Check for horse
                    if (checkHorse(chessBoard, 'H', i, j)) {
                        return false;
                    }
                    // Check for elephant
                    if (checkElephant(chessBoard, 'E', i, j)) {
                        return false;
                    }
                    // Check for Camel
                    if (checkCamel(chessBoard, 'C', i, j)) {
                        return false;
                    }
                    // Check for Queen
                    if (checkQueen(chessBoard, 'Q', i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // ChesschessBoard instance
        char [][]chessBoard = {
        {'-', '-', '-', 'K', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-', '-', '-', '-'},
        { '-', '-', '-','-', '-', '-', 'E', '-'},
        {'-', '-', 'H', '-', '-', '-', '-', '-'},
        {'-', '-', '-', '-', '-', '-', '-', '-'},
        {'Q', '-', '-', '-', '-', '-', '-', '-'},
        {'C', '-', '-', '-', '-', '-', '-', '-'}};

        if (isKingSafe(chessBoard) == true){
            System.out.println("King is safe");
        }
        else if (isKingSafe(chessBoard) == false){
            System.out.println("king is unsafe");
        }
    }
}
