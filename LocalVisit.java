public class LocalVisit{

/*clase que representa un partido en la parte de local va el equipo local y en el atributo visitante el equipo visitante*/
	private String local ;
	private String visit ;

// constructor
	public LocalVisit(){
		local = "";
		visit = "";
	}

/*set's and get's*/
	public void setLocal(String value){
		local = value;
	}	
	public void setVisit(String value){
		visit = value;
	}
	public String getLocal(){
		return local;
	}
	public String getVisit(){
		return visit;
	}
	
}