import java.util.ArrayList;
public class Fix{

	private LocalVisit[][] table;
	static final int team=4;
	static final int date=(team-1);
	static final int play=(team/2);

	public static LocalVisit getLocalTeam(int j, LocalVisit[][] aTable){
		return aTable[0][j];
	}

	public static void elUnicoBoludoQueRecorreLaTabla(ArrayList<String> listTeam, LocalVisit[][] aTable){
		int index=0;
		for (int i=0; i<team; i++){
			for (int j=0; j<date; j++){
				//tratamiento especial para la primera columna
				if (i==0){
					//cargo el equipo como local
					LocalVisit x = getLocalTeam(j,aTable);
					if(x.getLocal()==""){
						LocalVisit tupla = new LocalVisit();
						//reinicia el indice si termine de poner todos los equipos
						if(index<=listTeam.size()){
							tupla.setLocal(listTeam.get(index));
							aTable[i][j]=tupla;
						}
						else{
							index=0;
							tupla.setLocal(listTeam.get(index));
							aTable[i][j]=tupla;
							index++;
						}
					}
					//cargo el equipo como visitante
					else{
						LocalVisit tupla = new LocalVisit();
						//reinicia el indice si termine de poner todos los equipos
						if(index<=listTeam.size()){
							tupla.setVisit(listTeam.get(index));
							aTable[i][j]=tupla;
						}
						else{
							index=0;
							tupla.setVisit(listTeam.get(index));
							aTable[i][j]=tupla;
							index++;
						}
					}
				}
				//tratamiento para el resto de los partidos
				else{
					//reinicia el indice si termine de poner todos los equipos
					LocalVisit tupla = new LocalVisit();
					if(index<=listTeam.size()){
						tupla.setLocal(listTeam.get(index));
						aTable[i][j]=tupla;
					}
					else{
						index=0;
						tupla.setLocal(listTeam.get(index));
						aTable[i][j]=tupla;
						index++;
					}
				}
			}
		}
	}
}
