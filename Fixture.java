import java.util.ArrayList;

public class Fixture{

	public static void fixture (ArrayList<String> listTeam){
		int team = listTeam.size();
		int date = (team-1);
		int numMatch = (team/2);
		LocalVisit[][] table = new LocalVisit[date][numMatch];
		
		table = Fixture.comoandas(listTeam,table,date);
		table = Fixture.completeLocal(listTeam,table,numMatch,date);
		table = Fixture.addVisit(listTeam,table,numMatch,date);
		Fixture.printFixture(table,numMatch,date);

	}

	public static LocalVisit[][] comoandas (ArrayList<String> listTeamAux, LocalVisit[][] tableAux, int dates){
		int i = 0;
		LocalVisit aux1 = new LocalVisit();
		LocalVisit aux2 = new LocalVisit();
		aux2.setVisit(listTeamAux.get(listTeamAux.size()-1));
		aux1.setLocal(listTeamAux.get(listTeamAux.size()-1));
		while(i < dates){
			if(i%2==0)
				tableAux[i][0] = aux1;
			else
				tableAux[i][0] = aux2;
			i++;
		}
		return tableAux;
	}




public static LocalVisit[][] completeLocal(ArrayList<String> listTeam, LocalVisit[][] aTable, int matches, int dates){
	
	int index = 0;
	for (int i = 0; i< matches; i++){
		for (int j = 0; j< dates; j++){
			LocalVisit tupla = new LocalVisit();
			if (i==0 &&j%2==0){	//tratamiento especial para la primera columna
				//if(j%2==0){//cargo el equipo como visitante
					tupla = aTable[j][i];						
					tupla.setVisit(listTeam.get(index));
				}
			else
				tupla.setLocal(listTeam.get(index));
			aTable[j][i]=tupla;
			index++;
			if(index>listTeam.size()-1)
				index = 0;//reinicia el indice si termine de poner todos los equipos
		}
	}
	return aTable;
}



/** Pre : numOfTeams mod 2 = 0 **/
	public static LocalVisit[][] addVisit(ArrayList<String> listOfTeamsAux, LocalVisit[][] tableAux, int matches, int dates){
		int index = 9;
		for (int y = 1;  y < matches; y++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
			for (int x = 0; x < dates; x++){
				LocalVisit aux = tableAux[x][y];
				String auxiliar = listOfTeamsAux.get(index-1);	
				System.out.println(auxiliar);
				aux.visit = auxiliar; //Seteo el valor Visit en la instancia aux creada
				tableAux[x][y] = aux; //Le asigno el valor Visit seteado al Tablero
				index--; //decremento el indice que recorre el ArrayList
				if (index == 0)
					index = 9;	
			}
		}	
		return tableAux;
	}	
	


	public static void printFixture(LocalVisit[][] tableAux, int matches, int dates){
		LocalVisit aux;
		for (int y = 0;  y < matches; y++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
			for (int x = 0; x < dates; x++){	
				aux = tableAux[x][y];
				System.out.println(" juega el equipo "+aux.getLocal()+" como local, contra el equipo "+aux.getVisit()+" como visitante");
			}
		}
	}
}