import libraries.abstract.State;
import java.util.*;

public class AtomsState implements State{
	Atoms[][] board ;
	
	public AtomsState(){
		board = new Atoms[6][10];
		board [0][0] = new Atom(1);
		board [5][9] = new Atom(2);
	}

	public AtomsState(int x, int y,Atoms element){
		board[x][y] = element;
	}
	
	public boolean equals(State s){
		boolean flag = true;
		for (int i=0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				if (this[i][j]!=null){
					if (this[i][j].getNumber()!=s[i][j].getNumber() || this[i][j].getPlayer()!=s[i][j].getPlayer())
						flag = false;
				}
			}
		}
		return false;
	}

	public String toString(){
		String string = "";
		for (int i=0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				string += board[x][y]+" ";
			}
			string += "\n"
		}
		return string;
	}

}