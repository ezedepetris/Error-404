import libraries.abstract.State;
import java.util.*;

public class AtomState implements State{
	Atom[][] board ;
	
	public AtomState(){
		board = new Atom[6][10];
		board[0][0] = new Atom(1);
		board[5][9] = new Atom(2);
	}

	public AtomState(int x, int y,Atom element){
		board[x][y] = element;
	}
	
	public boolean equals(State s){

	}

	public String toString(){
		String string ="";
		for (int i = 0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				string += board[x][y]+" "
			}
			string +="\n";
		}
		return string;
	}

}