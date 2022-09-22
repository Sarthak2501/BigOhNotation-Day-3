import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedMap;

public class Qone3 {
    //naive method
//    public static boolean isValidSudoku(String [][]Sudoku){
//        int n = Sudoku.length;
//        int count = 0;
//
//        for (int i = 0 ; i < n ; i++ ){
//            int innerLength = Sudoku[i].length;
//            for (int j = 0 ; j < innerLength ; j++){
//                if(Sudoku[i][j] != ".") {
//                    if (Integer.parseInt(Sudoku[i][j]) > 9) {
//                        return false;
//                    }
//                    if (isDuplicates(Sudoku[i])) {
////                        System.out.println("kuch bhi");
//                        return false;
//                    }
//                }
//            }
//        }
//        String [][] newSudoku = new String[n][10];
//        newSudoku = transposeMatrix(Sudoku);
//        for (int i = 0 ; i < n ; i++ ){
//            int colLength = newSudoku[i].length;
//            for (int j = 0 ; j < colLength ; j++){
//                if(newSudoku[i][j] != ".") {
//                    if (Integer.parseInt(Sudoku[i][j]) > 9) {
//                        return false;
//                    }
//                    if (isDuplicates(newSudoku[i])) {
////                        System.out.println("kuch bhi");
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//    public static String[][] transposeMatrix(String[][] Sudoku){
//        int m = Sudoku.length;
//        int n = Sudoku[0].length;
//
//        String[][] transposedMatrix = new String[n][m];
//
//        for(int x = 0; x < n; x++) {
//            for(int y = 0; y < m; y++) {
//                transposedMatrix[x][y] = Sudoku[y][x];
//            }
//        }
//
//        return transposedMatrix;
//    }
//
//    public static boolean isDuplicates(String[] arr ){
//        boolean containsDuplicate = true;
//        int n = arr.length;
//        String eknum = "";
//        for (int i = 0 ; i < n ; i++){
////            if(arr[i] == "0") continue;
//            eknum = arr[i];
//            for (int j = 0; j < n ; j++){
//
//                if(arr[i] == arr[j]){
//                    containsDuplicate = false;
//                }
//            }
//        }
//        return containsDuplicate;
//    }


    public static boolean isValidSudoku(String [][]Sudoku){
        HashSet<String> dekhahai = new HashSet<>();
        for(int i = 0 ; i < 9 ; i ++ ){
            for (int j = 0 ; j < 9 ; j++){
                if(Sudoku[i][j] != "."){
                    if(!dekhahai.add("row" + i + Sudoku[i][j]) || !dekhahai.add("Col" + j + Sudoku[i][j] )){
                        return false;
                    }
                    if(!dekhahai.add("box" + (i/3)*3 + j/3 + Sudoku[i][j])){
                        return false;
                    }
                }
            }
        }
    return true;
    }
    public static void main(String[] args) {
        String [][]board =
                {{"5","3",".",".","7",".",".",".","."}
                ,{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."}
                ,{"8",".",".",".","6",".",".",".","3"}
                ,{"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"}
                ,{".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"}
                ,{".",".",".",".","8",".",".","7","9"}};
        String [][]board2 =
                {{"8","3",".",".","8",".",".",".","."}
                ,{"6",".",".","1","9","5",".",".","."}
                ,{".","9","8",".",".",".",".","6","."}
                ,{"8",".",".",".","6",".",".",".","3"}
                ,{"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"}
                ,{".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"}
                ,{".",".",".",".","8",".",".","7","9"}};

        boolean isvalid = isValidSudoku(board);

        System.out.println("The Following Sudoku is Valid Or Not : " + isvalid);

    }
}
