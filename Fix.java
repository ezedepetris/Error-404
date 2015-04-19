import java.util.ArrayList;
public class Fix{

	private LocalVisit[][] table;
	static final int team=10;
	static final int date=(team-1);
	static final int play=(team/2);

	public Fix(){
		table = new LocalVisit [date][play];
	}


	public static void completeLocal(ArrayList<String> listTeam, LocalVisit[][] aTable){
		int index=0;
		for (int i=0; i<play; i++){
			for (int j=0; j<date; j++){
				LocalVisit tupla = new LocalVisit();
				if (i==0)	//tratamiento especial para la primera columna
					if(j%2==0)//cargo el equipo como visitante
						tupla.setVisit(listTeam.get(index));
				else
					tupla.setLocal(listTeam.get(index));

				aTable[j][i]=tupla;
				System.out.println("fecha  "+tupla.getLocal());
				index++;
				if(index<listTeam.size()-1)
					index = 0;//reinicia el indice si termine de poner todos los equipos
			}
		}
	}

	public static void main(String[] args) {
		Fix fixture = new Fix();
		ArrayList<String> listOfTeam = new ArrayList<String>();
		listOfTeam.add("1");
		listOfTeam.add("2");
		listOfTeam.add("3");
		listOfTeam.add("4");
		listOfTeam.add("5");
		listOfTeam.add("6");
		listOfTeam.add("7");
		listOfTeam.add("8");
		listOfTeam.add("9");
		listOfTeam.add("10");
		fixture.completeLocal(listOfTeam, fixture.table);
		//for (int i=0; i<play; i++){
		//	System.out.println(" ");
		//	for (int j=0; j<date; j++){
		//		LocalVisit aux=fixture.table[i][j];
		//		System.out.print(aux.getLocal());
		//		System.out.print(aux.getVisit());
		//	}
		//}
	}
}

