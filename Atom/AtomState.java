import libraries.abstract.AdversarySearchState;
import java.util.*;

public class AtomState implements AdversarySearchState{
	Atoms[][] board ;
	boolean flag;
	
	public AtomState(){
		board = new Atom[6][10];
		board [0][0] = new Atom(1);
		board [5][9] = new Atom(2);
	}

	public AtomState(int x, int y,Atom eslement){
		if(board[x][y]==null)
			board[x][y] = element;
		else
			board[x][y] = board[x][y].setAtom(element.getPlayer());
	}
	
	public boolean equals(AdversarySearchState s){
		boolean flag = true;
		for (int i=0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				if((this.board[i][j]!=null && s.board[i][j]==null) || (s.board[i][j]!=null && this.board[i][j]==null))
					return false;
				if (this.board[i][j]!=null && s.board[i][j]!=null){
					if (this.board[i][j].getNumber()!=s.board[i][j].getNumber() || this.board[i][j].getPlayer()!=s.board[i][j].getPlayer())
						flag = false;
				}
			}
		}
		return flag;
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

	public boolean isMax(){
		return flag;

	}

	public Object ruleApplied(){
		return null;
	}









}