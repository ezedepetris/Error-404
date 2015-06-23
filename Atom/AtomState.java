/*in this class we define how is a Atom state and her method */
import java.util.*;

public class AtomState implements AdversarySearchState{
	Atom[][] board;
	boolean flag; /*TRUE is MAX,FALSE is MIN*/


	/* this is the constructor with the two atoms init*/
	public AtomState(){
		board = new Atom[6][10];
		board[0][0] = new Atom(1);
		board[5][9] = new Atom(2);
		flag = true;
	}

/* this method add a atom o convert an atom, if you are her owner this plus 1*/
	public void add(int x, int y,Atom element){
		if(this.board[x][y]==null)
			this.board[x][y] = element;
		else{
			this.board[x][y].setAtom(element.getPlayer());
			//System.out.println("EENNNTTREEE");
		}
	}


	public boolean equals(AdversarySearchState other){
		/*we not uses this method so the implementations is not necesary */
		return true;
	}

/* this method give us a ide how to look the board*/
	public String toString(){
		String string = "";
		for (int i=0; i<6; i++) {
			for (int j = 0; j<10; j++) {
				if(board[i][j] == null)
					string +="\033[30m"+"0"+" ";
				else{
					if(board[i][j].getPlayer() == 1)
						string += "\033[31m"+board[i][j].getNumber()+" "+"\033[30m"+"";
					
					if(board[i][j].getPlayer() == 2)
						string += "\033[32m"+board[i][j].getNumber()+" "+"\033[30m"+"";
				}
			}
			string += "\n";
		}
		return string;
	}

/* this method clone an state, but with out her references,this is uses when overlap the data*/
	public AtomState clone() {
    if (this == null) 
      return null;
    AtomState aux = new AtomState();
    aux.board = new Atom[6][10];
    if(this.flag)
    	aux.flag = true;
    else
    	aux.flag = false;
    for (int i = 0; i<6; i++) {
    	for (int j = 0; j<10; j++) {
    		if(this.board[i][j]!= null)
    			aux.board[i][j] = new Atom (this.board[i][j].getPlayer(),this.board[i][j].getNumber());
    	}
    }
    return aux;
  }
/* this method return true if the level is max, and false if the level is min*/
	public boolean isMax(){
		return flag;

	}

/*we not uses this method so the implementations is not necesary */
	public Object ruleApplied(){
		return null;
	}
}




