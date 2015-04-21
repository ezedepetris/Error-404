import java.util.ArrayList;
public class Sudoku{

	private Integer[][] cuadrante;

	public Sudoku(){
		cuadrante = new Integer[3][3];
	}

	//lsi = limite superior izquierdo
	//lsd = limite superior derecho
	//lii = limite inferior izquierdo
	//lid = limite inferior derecho
	public boolean checkSquare(ArrayList list, int lsi, int lsd, int lii, int lid){
		for(int i=lsi; i<lsd; i++){
			for(int j=lii; j<lid; j++){
				list.remove(cuadrante[i][j]);
			}
		}
		return (list.size()==0);
	}

	public static void main(String[] args) {
		Sudoku cuadrado = new Sudoku();
		cuadrado.cuadrante[0][0]=1;
		cuadrado.cuadrante[0][1]=2;
		cuadrado.cuadrante[0][2]=3;
		cuadrado.cuadrante[1][0]=4;
		cuadrado.cuadrante[1][1]=5;
		cuadrado.cuadrante[1][2]=6;
		cuadrado.cuadrante[2][0]=7;
		cuadrado.cuadrante[2][1]=8;
		cuadrado.cuadrante[2][2]=9;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		System.out.println(cuadrado.checkSquare(list,0,3,0,3));
	}
}