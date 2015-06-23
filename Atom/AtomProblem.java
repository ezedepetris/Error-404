
import java.util.*;

public class AtomProblem implements AdversarySearchProblem<AtomState>{
	AtomState init;

	public AtomState initialState(){
		return init;
	}
	public AtomProblem(){
		init = new AtomState();
	}

	public AtomProblem(AtomState state){
		init = state;
	}

	/* this method return a list of state successors posible, runs over the list and
	 create a new atom if the position is null or plus one if the atom is mine
	 and return this list*/
	public LinkedList<AtomState> getSuccessors(AtomState state) {
		LinkedList<AtomState> list = new LinkedList<AtomState>();
		int player;	
		if(state.isMax())
			player = 1;
		else
			player = 2;
		for (int i = 0; i<6; i++){
			for (int j = 0; j<10; j++){
				Atom atom = new Atom(player);
	   		AtomState aux = state.clone();

				if(aux.board[i][j]==null){
					aux.add(i,j,atom);
					if(player == 2)
						aux.flag=false;
					else
						aux.flag=true;
					list.add(aux);
				}
				else {
					if ((aux.board[i][j]).getPlayer() == player){//computer is player1
						 list.add(putAnAtom(aux,i,j,atom));
					 	if(player == 2)
							aux.flag=false;
						else
							aux.flag=true;

					}
				} 
			}
		}
		return list;
	}

	public boolean positionOk(int x, int y){
		if(this.init.board[x][y]==null)
			return true;
		if(this.init.board[x][y].getPlayer()==2)
			return true;
		return false;
	}
/* the method verify if in the board only have one player*/
	public boolean end(AtomState s){
		int player = 0;
		int x = 0;
		int y = 0;
		Boolean found = false;
		while(x<=5 && !found){
			while(y<=9 && !found){
				if(s.board[x][y]!= null){
					player = s.board[x][y].getPlayer();
					found = true;
				}
				y++;
			}
			x++;
		}

		for (int i = 0; i<6; i++)
			for (int j = 0; j<10; j++) 
				if(s.board[i][j]!=null)
					if(s.board[i][j].getPlayer() != player)
						return false;
		return true;
	}


	/* here we return the player winner*/
	public int getWinner(AtomState s){
		int x = 0;
		int y = 0;

		while(x<=5 ){
			while(y<=9 ){
				if(s.board[x][y]!= null){
					return s.board[x][y].getPlayer();
				}
				y++;
			}
			x++;
		}
		return 0;
	}



/* this method retorn the value of a state, this method do the product between the
 number of atoms of a cell product her limits, and plus all this, then subtraction pc-hum if is a level
  max or human-pc  if is a level min, the retorn this result*/
	public int value(AtomState state){
		int aux = 0;
		int pc = 0;
		int human = 0;
		for (int i = 0; i<6; i++){
			for (int j = 0; j<10; j++){
				if(state.board[i][j]!=null){
					if((i == 0 || i == 5) && (j == 0 || j == 9))
						aux = state.board[i][j].getNumber() * 2;
					if((i==0 && j < 9 && j>0)||(i==5 && j < 9 && j>0)||(j==0 && i < 4 && i>0)||(j==9 && i < 4 && i>0))
						aux = state.board[i][j].getNumber() * 3;
					if(i != 0 && j != 0 && i != 5 && j != 9)
						aux = state.board[i][j].getNumber() * 4;

					if(state.board[i][j].getPlayer() == 1)
						pc += aux;
					else
						human += aux;
				}
			} 
		}
		if (state.isMax())
			return pc - human;
		return human - pc;
	}



/* this method is more simple than put an atom 1, cause this if the board in this position [x][y] is null
this method create a new atom, an return this state (s), but this position isnt null this check if the atom
in this position is mine, so call the putAnAtom1, otherwhise return the state S without changes*/
	public AtomState putAnAtom(AtomState s,int i, int j,Atom atom){
		if (s.board[i][j] == null){
			putAnAtom1(s,i,j, atom);
			return s;
		}
		if(atom.getPlayer() == s.board[i][j].getPlayer()) {
			putAnAtom1(s,i,j, atom);
			return s;
		}
		return s;
	}

	/*this method retorn true if we are in the lateral left, righ or on the top or down of the board */
	public boolean inEdge(int i, int j){
		return ((i==0 && j<9 && j>0)||(i==5 && j<9 && j>0)||(j==0 && i<5 && i>0)||(j==9 && i<5 && i>0));
	}

/* this retorn true if we are positionated in the some corner of the board*/
	public boolean inCorner(int i, int j){
		boolean c1 = (i==0 && j==0);
		boolean c2 = (i==0 && j==9);
		boolean c3 = (i==5 && j==0);
		boolean c4 = (i==5 && j==9);
		return (c1 || c2 || c3 || c4);
	}

/* this method plus one at the atom, or create a new atom, in the case of the atoms
is alrady to explote, this make it, and we create a new atom with out references for each new explosion
with whis ways we forget the overlap*/
	public void putAnAtom1(AtomState s, int i, int j,Atom atom){
		if(!this.end(s)){/* here we control the recursive for a avoid infinity explosion*/
			if(s.board[i][j] == null)
				s.board[i][j]= atom;
			else{
				if(inCorner(i,j)){/* verify if ar in the corner*/

					s.board[i][j].setAtom(atom.getPlayer());
					if(s.board[i][j].getNumber()>=2){/*if the number the atoms is more to two make explote */
						s.board[i][j]=null;

						if(i==0 && j==0){
							Atom aux = new Atom(atom.getPlayer());		
							putAnAtom1(s,i+1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j+1,aux);
						}
						if(i==5 && j==0){
							Atom aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i-1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j+1,aux);
						}
						if(i==0 && j==9){
							Atom aux = new Atom(atom.getPlayer());		
							putAnAtom1(s,i+1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j-1,aux);
						}
						if(i==5 && j==9){
							Atom aux = new Atom(atom.getPlayer());	
							putAnAtom1(s,i-1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j-1,aux);
						}
					}
					
				}
				else{
					if(inEdge(i,j)){/*verify if are in the enge */
						s.board[i][j].setAtom(atom.getPlayer());
						if(s.board[i][j].getNumber()>=3){/* if the number of atoms is more to 3 make explote*/
							s.board[i][j]=null;

							if((i==0 && j<9 && j>0)){
								Atom aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j+1,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j-1,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i+1,j,aux);
							}
							if((i==5 && j<9 && j>0)){
								Atom aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j+1,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j-1,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i-1,j,aux);
							}
							if((j==0 && i<5 && i>0)){
								Atom aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i+1,j,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i-1,j,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j+1,aux);
							}
							if((j==9 && i<5 && i>0)){
								Atom aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i+1,j,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i-1,j,aux);
								aux = new Atom(atom.getPlayer());
								putAnAtom1(s,i,j-1,aux);
							}
						}
						
					}
					else{/* the last case is if are in the center*/
						s.board[i][j].setAtom(atom.getPlayer());
						if(s.board[i][j].getNumber()>=4){/* verify if the number the atoms is more to 4 then make explote*/
							s.board[i][j]=null;
							Atom aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i-1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i+1,j,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j+1,aux);
							aux = new Atom(atom.getPlayer());
							putAnAtom1(s,i,j-1,aux);

						}
					}
				}
			}
		}
	}


	public int maxValue(){
		return 100;
	}


	public int minValue(){
		return 10;
	}










/*ezequiel@MacBook-Air-de-Ezequiel.local/Atom javac -cp ../../:. AtomProblem.java*/

}