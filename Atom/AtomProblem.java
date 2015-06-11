import libraries.abstract.AbstractImformedSearchProblem;
import java.util.*;

public class AtomProblem implements AbstractImformedSearchProblem<AtomState>{
	private AtomState init;

	public ReinaState initialState(){
		init = new AtomState();
	}

	public List<AtomState> getSuccessors(AtomState s) {
		List<AtomState> list = new List<AtomState>();
		int player;
		if (s.isMax())
			player = 1;
		else
			player = 2;
		for (int i = 0; i<6; i++){
			for (int j = 0; j<10; j++){
				if(s.board[i][j]==null){
					Atom atom = new Atom(player);
					AtomState aux = new AtomState(i,j,atom);
					list.add(aux);
				}
				else{
					if ((s.board[i][j]).getPlayer()==player){
						AtomState aux = s.clone();
						list.add(aux.putAnAtom(i,j));
					}
				} 
			}
		}
		return list;
	}


	public Boolean succes(AtomState s){
		int i;
		int x = 0;
		int y = 0;
		boolean found = false;
		
		while(x<=5 && !found){
			while(y<=9 && !found){
				if(board[x][y]!= null){
					i = board[x][y].getPlayer();
					found = true;
				}
				y++;
			}
			x++;
		}

		for (int i = 0; i<6; i++)
			for (int j = 0; j<10; j++) 
				if(board[i][j]!=null)
					if(board[i][j].getPlayer() != i)
						return false;
		return true;

	}

	public int getValue(AtomState s){
	}

	public Comparator<AtomState> getComparator(){
	}

	public void putAnAtom1(int i, int j,Atom atom, AtomState s){
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
	
	public AtomState putAnAtom(int i, int j,Atom atom, AtomState s){
		s.putAnAtom1(int i, int j,Atom atom);
		return s;
	}

}