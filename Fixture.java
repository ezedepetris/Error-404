import java.util.ArrayList;

public class Fixture{

	public static void fixture (ArrayList<String> listTeam){
		int team = listTeam.size();
		int date = (team-1);
		int numMatch = ((team/2)-1);
		LocalVisit[][] table = new LocalVisit[numMatch][team];
		table = Fixture.comoandas(listTeam,table,date);
		int i = 0;
		
		while(i < date){
			LocalVisit  x = new LocalVisit();
			x = table[0][i];
			System.out.println(x.local);
			System.out.println(x.visit);
			i++;
		}
		

	}

	public static LocalVisit[][] comoandas (ArrayList<String> listTeamAux, LocalVisit[][] tableAux, int matches){
		int i = 0;
		LocalVisit aux1 = new LocalVisit();
		LocalVisit aux2 = new LocalVisit();
		aux2.setLocal(listTeamAux.get(listTeamAux.size()-1));
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

}