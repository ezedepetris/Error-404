import libraries.abstract.State;
import java.util.*;

public class AtomsState implements State{
	Atoms[][] board ;
	
	public AtomsState(){
		board = new Atoms[6][10];
	}

	public AtomsState(int x, int y,Atoms element){
		board[x][y] = element;
	}
	
	public boolean equals(State s){

	}

	public String toString(){
		for (int i=0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				
			}
		}
	}

}