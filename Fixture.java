public class Fixture{

	private int[][] table;
	static final int team=4;
	static final int date=(team-1);


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

	//retorna un elemento de la tabla
	public int getTeam(int i, int j){
		return (table[i][j]);
	}

	//hacela la primera pasada por la tabla cargando los valores
	public void firstInstanceOfCreateDate(){
		int x=1;
		for(int  i=0; i<team; i++){
			for(int j=0; j<date; j++){
				this.addTeam(i,j,x);
				if (x!=team){
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
	public void secondInstanceOfCreateDate(){
		int x=team;
		for(int  i=0; i<team; i++){
			for(int j=0; j<date; j++){
				this.addTeam(i,j,x);
				if (x!=1){
					x--;
				}
				else{
					x=10;
				}
				j++;
			}
		}
	}

	public static void main(String[] args) {

		Fixture tableOfTeams = new Fixture();
		tableOfTeams.firstInstanceOfCreateDatef();
		tableOfTeams.secondInstanceOfCreateDate();
			for(int  i=0; i<team; i++){
				System.out.println(" ");
				for(int j=0; j<date; j++){
					System.out.print(tableOfTeams.getTeam(i,j));
				}
			}
	}

}