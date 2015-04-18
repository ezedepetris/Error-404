public class Fixture{

	private int[][] table;


	//constructir
	public Fixture(){
		for(int i=0; i<team; i++){//team es la cantidad de equipos
			for(int j=0; j<(team-1); j++){//(team-1) es la cantidad de fecha
				table[i][j]=0;
			}
		}
	}

	//carga un nuevo elemento a la tabla
	public void addTeam(int i, int j, int x){
		table[i][j]=x;
	}

	//hacela la primera pasada por la tabla cargando los valores
	public void firstInstanceOfCreateDate(int date){
		int x=1;
		for(int  i=0; i<team; i++){
			for(int j=0: j<team; j++){
				table.addTeam(i,j,x);
				if (x<>team){
					x++;
				}
				else{
					x=1;
				}
				j++;
			}
		}
	}

	//hacela la segunda pasada por la tabla cargando los valores
	public void SecondInstanceOfCreateDate(int date){
		int x=team;
		for(int  i=0; i<team; i++){
			for(int j=0: j<team; j++){
				table.addTeam(i,j,x);
				if (x<>1){
					x--;
				}
				else{
					x=10;
				}
				j++;
			}
		}
	}

	
}