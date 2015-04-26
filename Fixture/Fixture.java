import java.util.ArrayList;

public class Fixture{

	//metodo principal que arma el fixture
	public static void fixture (ArrayList<String> listTeam){
		int team = listTeam.size();//cantidad de equipos
		int date = (team-1);//fechas a jugar
		int numMatch = (team/2);//cantidad de equipos por fechas
		LocalVisit[][] table = new LocalVisit[date][numMatch];//matriz del ficture
		
		table = Fixture.completeLocal(listTeam,table,numMatch,date);
		table = Fixture.loadLastTeam(listTeam,table,date);
		table = Fixture.addVisit(listTeam,table,numMatch,date);
		Fixture.printFixture(table,numMatch,date);

	}

	/*segundo metodo quw carga el ultimo equipo en el primer partido de todoas las fechas intercalando local y visitante*/
	public static LocalVisit[][] loadLastTeam (ArrayList<String> listTeamAux, LocalVisit[][] tableAux, int dates){
		int i = 0;
		LocalVisit tupla;
		while(i < dates){
			tupla = tableAux[i][0];
			if(i%2==0)
				tupla.setLocal(listTeamAux.get(listTeamAux.size()-1));//carga como local
			else
				tupla.setVisit(listTeamAux.get(listTeamAux.size()-1));//carga como visitante
			tableAux[i][0] = tupla;
			i++;
		}
		return tableAux;
	}


	/*primer metodo que realiza una pasada completa por la matriz completando con todos los equipos, exepto el ultimo, que
	jugaran de local y en los casos en los que ya habia un local en la primer fecha, los carga como visitantes*/
	public static LocalVisit[][] completeLocal(ArrayList<String> listTeam, LocalVisit[][] aTable, int matches, int dates){
		
		int index = 0;
		for (int x = 0; x< dates; x++){
			for (int y = 0; y< matches; y++){
				LocalVisit tupla = new LocalVisit();
				if (y==0 && x%2==0)	//tratamiento especial para la primera columna
					tupla.setVisit(listTeam.get(index));
				else
					tupla.setLocal(listTeam.get(index));
				aTable[x][y]=tupla;
				index++;
				if(index>listTeam.size()-2)
					index = 0;//reinicia el indice si termine de poner todos los equipos
			}
		}
		return aTable;
	}



	/*metodo que realiza la segunda y ultima pasada por la matriz completando con los quipos, exepto el ultimo, los cuales
	seran todos visitantes*/
	public static LocalVisit[][] addVisit(ArrayList<String> listOfTeamsAux, LocalVisit[][] tableAux, int matches, int dates){
		int index = dates;
		for (int x = 0; x < dates; x++){
			for (int y = 1;  y < matches; y++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
				LocalVisit aux = tableAux[x][y];
				String auxiliar = listOfTeamsAux.get(index-1);	
				aux.visit = auxiliar; //Seteo el valor Visit en la instancia aux creada
				tableAux[x][y] = aux; //Le asigno el valor Visit seteado al Tablero
				index--; //decremento el indice que recorre el ArrayList
				if (index == 0)
					index = dates;	
			}
		}	
		return tableAux;
	}	
	

	//metodo que solo se encarga de imprimir el estado del fixture
	public static void printFixture(LocalVisit[][] tableAux, int matches, int dates){
		LocalVisit aux;
		for (int y = 0;  y < matches; y++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
			System.out.println("***********");
			System.out.println("fecha N "+(y+1));
			System.out.println("***********");
			for (int x = 0; x < dates; x++){	
				aux = tableAux[x][y];
				System.out.println("partido N-> "+(x+1)+" juega el equipo "+aux.getLocal()+" como local, contra el equipo "+aux.getVisit()+" como visitante");
			}
		}
	}
}
