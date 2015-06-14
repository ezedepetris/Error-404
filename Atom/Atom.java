
public class Atom{

	private int player;
	private int number;

	public Atom(int p){
		player = p;
		number = 1;
	}

	public int getNumber(){
		return number;
	}  

	public int getPlayer(){
		return player;
	}

	public void setAtom(int p){
		player = p;
		number++;
	}
}