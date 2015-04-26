import java.util.ArrayList;
public class Test{
	//clase de testeo del sudoku
	public static void main(String[] args) {
		Integer[][] tablero = new Integer[9][9];
		 for (int i = 0;i<9 ;i++ ) {
		 	for (int j = 0;j<9 ;j++ ) {
		 		tablero[i][j]=null;
		 	}
		 }

		 //tablero pre carcado
		 
		/*tablero[0][0]=5;
		tablero[0][1]=4;
		tablero[0][2]=3;
		tablero[0][3]=9;
		tablero[0][7]=2;
		tablero[0][8]=1;

		tablero[1][0]=9;
		tablero[1][1]=1;
		tablero[1][2]=8;
		tablero[1][3]=2;
		tablero[1][4]=3;
		tablero[1][5]=6;
		tablero[1][6]=5;
		tablero[1][7]=4;
		tablero[1][8]=7;

		tablero[2][0]=2;
		tablero[2][1]=7;
		tablero[2][2]=6;
		tablero[2][3]=4;
		tablero[2][4]=5;
		tablero[2][5]=1;
		tablero[2][6]=9;
		tablero[2][7]=3;
		tablero[2][8]=8;

		tablero[3][1]=9;
		tablero[3][2]=5;
		tablero[3][4]=1;
		tablero[3][5]=2;
		tablero[3][6]=7;
		tablero[3][7]=8;
		tablero[3][8]=6;

		tablero[4][0]=8;
		tablero[4][1]=6;
		tablero[4][2]=2;
		tablero[4][3]=7;
		tablero[4][4]=9;
		tablero[4][5]=5;
		tablero[4][6]=3;
		tablero[4][7]=1;
		tablero[4][8]=4;

		tablero[5][0]=1;
		tablero[5][1]=3;
		tablero[5][2]=7;
		tablero[5][3]=8;
		tablero[5][4]=6;
		tablero[5][5]=4;
		tablero[5][6]=2;
		tablero[5][7]=5;
		tablero[5][8]=9;

		tablero[6][1]=5;
		tablero[6][2]=4;
		tablero[6][3]=6;
		tablero[6][4]=8;
		tablero[6][5]=9;
		tablero[6][6]=1;
		tablero[6][7]=7;
		tablero[6][8]=2;

		tablero[7][0]=7;
		tablero[7][1]=2;
		tablero[7][2]=9;
		tablero[7][3]=1;
		tablero[7][4]=4;
		tablero[7][5]=3;
		tablero[7][6]=8;
		tablero[7][7]=6;
		tablero[7][8]=5;

		tablero[8][0]=6;
		tablero[8][1]=8;
		tablero[8][2]=1;
		tablero[8][3]=5;
		tablero[8][4]=2;
		tablero[8][5]=7;
		tablero[8][6]=4;
		tablero[8][7]=9;
		tablero[8][8]=3;
		
		Integer[][] cuadradito = new Integer[3][3];
		cuadradito[0][0]=9;
		cuadradito[0][1]=1;
		cuadradito[0][2]=2;
		cuadradito[1][0]=3;
		cuadradito[1][1]=4;
		cuadradito[1][2]=5;
		cuadradito[2][0]=6;
		cuadradito[2][1]=7;
		cuadradito[2][2]=8;*/


		ArrayList<Integer> list = new ArrayList<Integer>();
		Boolean cond = false;
		Boolean con2 = true;
		for(Integer i = 1; i<=9;i++)
			list.add(i);

		for(int y = 0; y < 3; y++){
			for(int x = 0; x <3; x++){
				cond = list.remove(cuadradito[x][y]);
			if(cuadradito[x][y]!=null&&!cond)
				con2 = false;
			}
		}
		System.out.print(con2+" ");
		

		 tablero = Sudoku.sudokuResolve(tablero);
		System.out.println(Sudoku.checkAllSquare(tablero));

		if (tablero != null) {
			for ( int i = 0;i<9 ;i++ ) {
				for ( int j = 0;j<9 ;j++ ) {
					System.out.print(" "+tablero[i][j]+"");
				}
				System.out.println("");
			}
		}
		else {
			System.out.println("no se puede resolver");
		}
	 }
}