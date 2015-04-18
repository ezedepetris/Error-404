import java.util.ArrayList;

public class Fixture{

	public static void fixture (ArrayList<String> listTeam){
		int team = listTeam.size();
		int date = (team-1);
		int numMatch = (team/2);
		LocalVisit[][] table = new LocalVisit[numMatch][team];
		table = Fixture.comoandas(listTeam,table,numMatch);
		
		table = Fixture.addVisit(listTeam,table,numMatch,date);
		Fixture.printFixture(table,numMatch,date);

	}

	public static LocalVisit[][] comoandas (ArrayList<String> listTeamAux, LocalVisit[][] tableAux, int matches){
		int i = 0;
		LocalVisit aux1 = new LocalVisit();
		LocalVisit aux2 = new LocalVisit();
		aux2.setVisit(listTeamAux.get(listTeamAux.size()-1));
		aux1.setLocal(listTeamAux.get(listTeamAux.size()-1));
		while(i < matches){
			if(i%2==0)
				tableAux[0][i] = aux1;
			else
				tableAux[0][i] = aux2;
			i++;
		}
		return tableAux;
	}

/** Pre : numOfTeams mod 2 = 0 **/
	public static LocalVisit[][] addVisit(ArrayList<String> listOfTeamsAux, LocalVisit[][] tableAux, int matches, int dates){
		int aux = 9;
		LocalVisit aux1 = new LocalVisit(); //Creo una instancia tipo LocalVisit(Tupla de String)
			for (int i = 1;  i < matches; i++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
				for (int j = 0; j < dates; j++){	
					
					System.out.println(listOfTeamsAux.get(aux-1));
					aux1.setVisit(listOfTeamsAux.get(aux-1)); //Seteo el valor Visit en la instancia aux1 creada
					tableAux[i][j] = aux1; //Le asigno el valor Visit seteado al Tablero
					aux--; //Incremento el indice que recorre el ArrayList
					if (aux < 1)
						aux = 9;	
				}
			}	
			return tableAux;
		}	
	


	public static void printFixture(LocalVisit[][] tableAux, int matches, int dates){
		int i = 1;
		int j = 0;
		LocalVisit x;
		while(i < matches){
			while(j < dates){
				x = tableAux[i][j];
				System.out.println("fecha " +i+" juega el equipo "+x.getLocal()+" como local, contra el equipo "+x.getVisit()+" como visitante");
				j++;
			}
			j=0;
			i++;
		}
	}

}