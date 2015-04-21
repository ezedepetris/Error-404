import java.util.ArrayList;

public class Sudoku{

	public static Integer[][] sudokuResolve(Integer[][] board){
		int i =1;
		Integer[][] boardAux = board;
		for(int y = 0;y < 9;y++){
			for(int x = 0;x < 9;x++){
				if(board[x][y] == null){
					while(i<=9){
						if(!Sudoku.checkColumn(x,board)){
							if(!Sudoku.checkRow(y,board)){	
								if(!Sudoku.checkWin(board)){
									System.out.println("gaston hijo de scilingo");
									boardAux[x][y] = i;
									Sudoku.sudokuResolve(boardAux);
								}		
							}
						}
						i++;
					}
				}			
			}
		}
		return boardAux;
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
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i;
		for(i = 1; i<=9;i++)
			list.add(i);

		for(i = 0; i < 9; i++)
			list.remove(board[i][column]);
		return (list.size()==0);
	}

	public static boolean checkRow (int row, Integer[][] board){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i;
		for(i = 1; i<=9;i++)
			list.add(i);

		for(i = 0; i < 9; i++)
			list.remove(board[row][i]);
		return (list.size()==0);
	}
	
}