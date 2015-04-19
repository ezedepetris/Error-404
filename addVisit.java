/** Pre : numOfTeams mod 2 = 0 **/
public void addVisit(ArrayList<String> listOfTeamsAux, LocalVisit[][] table, int numOfTeams){
	int aux = 0;
	LocalVisit aux1 = new LocalVisit(); //Creo una instancia tipo LocalVisit(Tupla de String)
		for (int i=1;  i<(numOfTeams/2)); i++){ //Evito la primer columna de la tabla, por eso i=1 y NO 1=0
			for (int j=0; j<(numOfTeams - 1); j++)	
				if (aux <= listOfTeamsAux.size()){	
					aux1.setVisit(ListOfTeamsAux.get(aux)); //Seteo el valor Visit en la instancia aux1 creada
					table[i][j] = aux1; //Le asigno el valor Visit seteado al Tablero
				}
				else{
					aux = 0; //Restauro el valor del indice para comenzar desde el principio de la lista
					aux1.setVisit(ListOfTeamsAux.get(aux)); //Seteo el valor Visit en la instancia aux1 creada
					table[i][j] = aux1; //Le asigo el valor Visit seteado al Tablero
				}
				aux++; //Incremento el indice que recorre el ArrayList
			}
		}		
	}
}