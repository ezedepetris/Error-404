import java.util.ArrayList;

import java.util.Arrays;

public class Sudoku{

	public static Integer[][] sudokuResolve(Integer[][] board){
		if(Sudoku.hasConflict(board))
			return null;

		if (Sudoku.isComplete(board))
			return board;
		Boolean found = false;
		int x = 0;
		int y = 0;
		while( x<9 && !found ){
			y = 0;
			while( y<9 && !found){
				if(board[x][y] == null)
					found = true;
				else
					y++;
			}
			if(!found)
			x++;
		}
		Boolean solved = false; 
		int i = 1;
		Integer[][] solution = null;
		while(i<=9 && !solved){
			Integer[][] boardAux = (Integer[][]) deepCopy(board);
			boardAux[x][y] = i;
			solution = Sudoku.sudokuResolve(boardAux);
			if (solution !=null )
				solved =  true;
			i++;
		}
		return solution;
	}

	public static Boolean isComplete(Integer[][] board){
		for(int y = 0;y < 9;y++)
			for(int x = 0;x < 9;x++)
				if(board[x][y] == null)
					return false;
		return true;
	}

	public static Boolean hasConflict(Integer[][] board){
		// if(!Sudoku.checkWin(board))
		// 	return false;

		for(int y = 0;y < 9;y++)
			for(int x = 0;x < 9;x++)
				if(!Sudoku.checkColumn(y,board) || !Sudoku.checkRow(x,board))
					return true;

		return false;
	}

	public static void show(Integer [][] tablero){
		System.out.println("boar aux");
		for ( int i = 0;i<9 ;i++ ) {
				for ( int j = 0;j<9 ;j++ ) {
					System.out.print(" "+tablero[i][j]+" ");
				}
				System.out.println();
			}
	}

	public static boolean checkWin(Integer[][] board){
		int x;
		int y;
		int i;
		Boolean cond = true;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 1; y <= 4; y++){
			for(x = 1; x <=4; x++){
				cond = list.remove(board[x][y]);
				if(!cond)
					return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);
		
		for(y = 1; y <= 4; y++){
			for(x = 5; x <= 8; x++){
				cond =list.remove(board[x][y]);
				if(!cond)
					return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 5; y <= 8; y++){
			for(x = 1; x <= 4; x++){
				cond =list.remove(board[x][y]);
				if(!cond)
					return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 5; y <= 8; y++){
			for(x = 5; x<= 8; x++){
				cond =list.remove(board[x][y]);
				if(!cond)
					return false;
			}
		}
		return cond;
	}



	public static boolean checkColumn (int column,Integer[][] board){
		Boolean cond ;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i;
		for(i = 1; i<=9;i++)
			list.add(i);

		for(i = 0; i <= 8; i++){
			cond =list.remove(board[i][column]);
			if(board[i][column]!=null &&!cond)
				return false;
		}
		return (true);

	}

	public static boolean checkRow (int row, Integer[][] board){
		Boolean cond;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i;
		for(i = 1; i<=9;i++)
			list.add(i);

		for(i = 0; i <= 8; i++){
			cond = list.remove(board[row][i]);
			if(board[row][i]!=null&&!cond)
				return false;
		}
		return (true);
	}
	

public static Integer[][] deepCopy(Integer[][] original) {
    if (original == null) {
        return null;
    }

    final Integer[][] result = new Integer[original.length][];
    for (int i = 0; i < original.length; i++) {
        result[i] = Arrays.copyOf(original[i], original[i].length);
        // For Java versions prior to Java 6 use the next:
        // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
    }
    return result;
  }
}
