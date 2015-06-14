import libraries.ab.AdversarySearchProblem;
import java.util.*;

public class AtomProblem implements AdversarySearchProblem<AtomState>{
	AtomState init;

	public AtomState initialState(){
		return new AtomState();
	}

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
   		AtomState aux = state;
			if(state.board[i][j]==null){
				aux = new AtomState(i,j,atom);
				list.add(aux);
			}
			else{
				if ((state.board[i][j]).getPlayer()==player){//computer is player1
					//AtomState aux = state.putAToken(i,j);
					list.add(putAnAtom(state,i,j,atom));
				}
			} 
		}
	}
	return list;
}

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




	public AtomState putAnAtom(AtomState s,int i, int j,Atom atom){
		putAnAtom1(s,i,j, atom);
		return s;

	}

	public void putAnAtom1(AtomState s, int i, int j,Atom atom){
		if(s.board[i][j] == null)
			s.board[i][j]= atom;
		else{
			s.board[i][j].setAtom(atom.getPlayer());
			if (i>0 && i<5 && j>0 && j<9){
				if ((s.board[i][j]).getNumber()==4){
					s.board[i][j] = null;
					putAnAtom1(s,i-1,j,atom);
					putAnAtom1(s,i,j-1,atom);
					putAnAtom1(s,i,j+1,atom);
					putAnAtom1(s,i+1,j,atom);
				}
				else{//lateral general
					if ((s.board[i][j]).getNumber()==3){
						if (i==0 && j>0 && j<9){//horizontal arriba
								s.board[i][j] = null;
								putAnAtom1(s,i+1,j,atom);
								putAnAtom1(s,i,j-1,atom);
								putAnAtom1(s,i,j+1,atom);
						}
						if (i==5 && j>0 && j<9){//horizontal abajo
								s.board[i][j] = null;
								putAnAtom1(s,i-1,j,atom);
								putAnAtom1(s,i,j-1,atom);
								putAnAtom1(s,i,j+1,atom);
						}
						if (i>0 && i<5 && j==0){//vertical izquierda
								s.board[i][j] = null;
								putAnAtom1(s,i+1,j,atom);
								putAnAtom1(s,i-1,j,atom);
								putAnAtom1(s,i,j+1,atom);
						}
						if (i>0 && i<5 && j==9){//vertical derecha
								s.board[i][j] = null;
								putAnAtom1(s,i+1,j,atom);
								putAnAtom1(s,i-1,j,atom);
								putAnAtom1(s,i,j-1,atom);
						}
					}
					else{
						if(i==0 && j==0){
							s.board[i][j] = null;
							putAnAtom1(s,i+1,j,atom);
							putAnAtom1(s,i,j+1,atom);
						}
						if(i==0 && j==9){
							s.board[i][j] = null;
							putAnAtom1(s,i+1,j,atom);
							putAnAtom1(s,i,j-1,atom);
						}
						if(i==5 && j==0){
							s.board[i][j] = null;
							putAnAtom1(s,i-1,j,atom);
							putAnAtom1(s,i,j+1,atom);
						}
						if(i==5 && j==9){
							s.board[i][j] = null;
							putAnAtom1(s,i-1,j,atom);
							putAnAtom1(s,i,j-1,atom);
						}
					}
				}//lateral genreal
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