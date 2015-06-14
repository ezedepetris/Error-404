import libraries.ab.AdversarySearchProblem;
import java.util.*;

public class AtomProblem implements AdversarySearchProblem<AtomState>{
	AtomState init;

	public AtomState initialState(){
		return new AtomState();
	}

public List<AtomState> getSuccessors(AtomState state) {
	List<AtomState> list = new List<AtomState>();
	int player;	
	if(state.isMax())
		player = 1;
	else
		player = 2;
	for (int i = 0; i<6; i++){
		for (int j = 0; j<10; j++){
			Atom atom = new Atom(player);
   		AtomState aux = state;
			if(state.board[i][j]==null){
				aux = new AtomState(i,j,atom);
				list.add(aux);
			}
			else{
				if ((state.board[i][j]).getPlayer()==player){//computer is player1
					//AtomState aux = state.putAToken(i,j);
					list.add(putAnAtom(i,j,atom));
				}
			} 
		}
	}
	return list;
}

	public Boolean succes(AtomState s){
		int i = 0;
		int x = 0;
		int y = 0;
		Boolean found = false;
		while(x<=5 && !found){
			while(y<=9 && !found){
				if(this.board[x][y]!= null){
					i = this.board[x][y].getPlayer();
					found = true;
				}
				y++;
			}
			x++;
		}

		for (int i = 0; i<6; i++)
			for (int j = 0; j<10; j++) 
				if(this.board[i][j]!=null)
					if(this.board[i][j].getPlayer() != i)
						return false;
		return true;

	}

	public int getValue(){
		int aux = 0;
		int pc = 0;
		int human = 0;
		for (int i = 0; i<6; i++){
			for (int j = 0; j<10; j++){
				if(this.board[i][j]!=null){
					if((i == 0 || i == 5) && (j == 0 || j == 9))
						aux = this.board[i][j].getNumber() * 2;
					if((i==0 && j < 9 && j>0)||(i==5 && j < 9 && j>0)||(j==0 && i < 4 && i>0)||(j==9 && i < 4 && i>0))
						aux = this.board[i][j].getNumber() * 3;
					if(i != 0 && j != 0 && i != 5 && j != 9)
						aux = this.board[i][j].getNumber() * 4;

					if(this.board[i][j].getPlayer() == 1)
						pc += aux;
					else
						human += aux;
				}
			} 
		}
		if (this.isMax())
			return pc - human;
		return humn - pc;
	}

	public Comparator<AtomState> getComparator(){
		return this;
		}





	public AtomState putAnAtom(AtomState s,int i, int j,Atom atom){
		s.putAnAtom1(i,j, atom);
		return s;

	}

	public void putAnAtom1(AtomState s, int i, int j,Atom atom){
		if(s.board[i][j] == null)
			s.board[i][j]= atom;
		else{
			s.board[i][j].setAtom(atom.getPlayer());
			if (i>0 && i<5 && j>0 && j<9){
				if ((s.board[i][j]).getNumber==4){
					s.board[i][j] = null;
					s.putAnAtom1(i-1,j,atom);
					s.putAnAtom1(i,j-1,atom);
					s.putAnAtom1(i,j+1,atom);
					s.putAnAtom1(i+1,j,atom);
				}
				else{//lateral general
					if ((s.board[i][j]).getNumber==3){
						if (i==0 && j>0 && j<9){//horizontal arriba
								s.board[i][j] = null;
								s.putAnAtom1(i+1,j,atom);
								s.putAnAtom1(i,j-1,atom);
								s.putAnAtom1(i,j+1,atom);
						}
						if (i==5 && j>0 && j<9){//horizontal abajo
								s.board[i][j] = null;
								s.putAnAtom1(i-1,j,atom);
								s.putAnAtom1(i,j-1,atom);
								s.putAnAtom1(i,j+1,atom);
						}
						if (i>0 && i<5 && j==0){//vertical izquierda
								s.board[i][j] = null;
								s.putAnAtom1(i+1,j,atom);
								s.putAnAtom1(i-1,j,atom);
								s.putAnAtom1(i,j+1,atom);
						}
						if (i>0 && i<5 && j==9){//vertical derecha
								s.board[i][j] = null;
								s.putAnAtom1(i+1,j,atom);
								s.putAnAtom1(i-1,j,atom);
								s.putAnAtom1(i,j-1,atom);
						}
					}
					else{
						if(i==0 && j==0){
							s.board[i][j] = null;
							s.putAnAtom1(i+1,j,atom);
							s.putAnAtom1(i,j+1,atom);
						}
						if(i==0 && j==9){
							s.board[i][j] = null;
							s.putAnAtom1(i+1,j,atom);
							s.putAnAtom1(i,j-1,atom);
						}
						if(i==5 && j==0){
							s.board[i][j] = null;
							s.putAnAtom1(i-1,j,atom);
							s.putAnAtom1(i,j+1,atom);
						}
						if(i==5 && j==9){
							s.board[i][j] = null;
							s.putAnAtom1(i-1,j,atom);
							s.putAnAtom1(i,j-1,atom);
						}
					}
				}//lateral genreal
			}
		}
	}











/*ezequiel@MacBook-Air-de-Ezequiel.local/Atom javac -cp ../../:. AtomProblem.java*/

}