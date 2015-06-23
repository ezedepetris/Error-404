
/* this class model an atom an her behaviour*/
public class Atom{

	private int player;
	private int number;
/*this method create an atom with the player p and number the atom init 1 */
	public Atom(int p){
		player = p;
		number = 1;
	}

	public Atom(int p,int n){
		player = p;
		number = n;
	}
/* return the number of atoms*/
	public int getNumber(){
		return number;
	}  
/* return the player own of this atoms*/
	public int getPlayer(){
		return player;
	}
	/* this method set the number of atoms */
	public void setNumber(int num){
		number = num;

	}
/* this method convert an atom an plus 1 */
	public void setAtom(int p){
		player = p;
		number++;
	}
}