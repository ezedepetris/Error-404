import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku{

	//metodo que dice si es posible resolver el sudoku o si no tiene solcion
	public static Integer[][] sudokuResolve(Integer[][] board){
		if(Sudoku.hasConflict(board))//consulta si tiene conflictos, columnas, filas, win y por cuadrado
			return null;

		if (Sudoku.isComplete(board))//pregunta si tiene lugares vacios
			return board;
			
		Boolean found = false;//true si hay lugar vacio
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
				solved =  true;//si se lleno devuelve true y es porque es correcto
			i++;
		}
		return solution;//retorna el tablero o null si hubo onflictos
	}

	//metodo que retorna true sii el tablero esta completo
	public static Boolean isComplete(Integer[][] board){
		for(int y = 0;y < 9;y++)
			for(int x = 0;x < 9;x++)
				if(board[x][y] == null)
					return false;
		return true;
	}

	//metodo que retorna true sii el tablero presenta algun problema ya sea en las filas
	//columnas o los cuadrantes comunes y win
	public static Boolean hasConflict(Integer[][] board){
		if(!Sudoku.checkAllSquare(board))
			return true;


		if(!Sudoku.checkWin(board))
			return true;

		for(int y = 0;y < 9;y++)
			for(int x = 0;x < 9;x++)
				if(!Sudoku.checkColumn(y,board) || !Sudoku.checkRow(x,board))
					return true;

		return false;
	}

	//metodo que solo imprime por pantalla el estado del tablero
	public static void show(Integer [][] tablero){
		System.out.println("boar aux");
		for ( int i = 0;i<9 ;i++ ) {
				for ( int j = 0;j<9 ;j++ ) {
					System.out.print(" "+tablero[i][j]+" ");
				}
				System.out.println();
			}
	}

	//metodo que chequea el variante win
	public static boolean checkWin(Integer[][] board){
		int x;
		int y;
		int i;
		Boolean cond = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		/*creamos un conjunto con valores del 1 al 9 luego iremos sacando elemento por elemento del cuadrante y
		luego si querermos sacar un mismo elemento dos veces retorna false y hacemos esto para todos los cuadrantes
		por cuadrntes vaciamos y lllenamos el conjunto de valores*/
		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 1; y <= 3; y++){
			for(x = 1; x <=3; x++){
			/*lo que hacemos en esta sesion es ire eliminando elementos del cuadrante y esto devuelve true si se pudo
			borrar y false si no s epudo borrar, si nos e pudo borrar pasan dos cosas que el elemento ya alla sido borrado o que
			en esa posicion haya sido null por eso controlamos que solo devuelva false si no se pudo borrar y que en esa posicion halla
			algo que sea distinto de null, esto se hace para todos los cuadrantes al igualr que el check square utiliza la misma tecnica*/
				cond = list.remove(board[x][y]);
			if(board[x][y]!=null&&!cond)
				return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);
		
		for(y = 1; y <= 3; y++){
			for(x = 5; x <= 7; x++){
				cond =list.remove(board[x][y]);
			if(board[x][y]!=null&&!cond)
				return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 5; y <= 7; y++){
			for(x = 1; x <= 3; x++){
				cond =list.remove(board[x][y]);
		if(board[x][y]!=null&&!cond)
				return false;
			}
		}

		list.clear();
		for(i = 1; i<=9;i++)
			list.add(i);

		for(y = 5; y <= 7; y++){
			for(x = 5; x<= 7; x++){
				cond =list.remove(board[x][y]);
			if(board[x][y]!=null&&!cond)
				return false;
			}
		}
		return true;
	}

	//metodo que devuelve true sii los cuadrados no presentan problemas
	public static Boolean checkAllSquare(Integer[][] board){
		int i = 0;
		int j = 0;
		Boolean cond = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(i<9){
			j=0;
			while(j<9){
				list.clear();
				for(int h = 1; h<=9;h++)
					list.add(h);
				for (int y = i; y < i+3;y++ ){
					for (int x = j;x < j+3 ;x++ ) {
						cond =list.remove(board[x][y]);
						if(board[x][y]!=null&&!cond)
							return false;
					}
				}
				j = j+3;
			}		
			i=i+3;
		}				
		return true;
	}


	//metodo que retorna true sii la columna no presenta problema
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

	//metodo que retorna true sii la columna no presenta problemas
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
	


	//metodo que clona el tablero
	public static Integer[][] deepCopy(Integer[][] original) {
	    if (original == null) {
	        return null;
	    }

	    final Integer[][] result = new Integer[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	  }
}
